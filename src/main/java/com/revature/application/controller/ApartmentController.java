package com.revature.application.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.revature.application.model.Apartment;
import com.revature.application.model.ApartmentComplex;
import com.revature.application.service.ApartmentComplexService;
import com.revature.application.service.ApartmentService;
import com.revature.application.slackapi.Slack;



@RestController
@RequestMapping("api")
public class ApartmentController {

	@Autowired
	ApartmentService apartmentService;
	@Autowired
	ApartmentComplexService apartmentComplexService;
	@Autowired
	Slack slack;
	
	@GetMapping("Apartments")
	public ResponseEntity<Object> displayAllApartments() {
		return ResponseEntity.ok(apartmentService.findAll());
	}	
	
	@GetMapping("ApartmentComplexes/{id}/Apartments")
	public ResponseEntity<Object> displayApartmentsFromComplex(@PathVariable("id") int id) {
		return ResponseEntity.ok(apartmentService.findByComplexId(id));
	}
	
	@GetMapping("Apartments/{id}")
	public ResponseEntity<Object> displayApartment(@PathVariable("id") int id) {
		return ResponseEntity.ok(apartmentService.findByApartmentId(id));
	}
	
	@RequestMapping(value ="ApartmentComplexes/{id}/Apartments/create", method=RequestMethod.POST)
	public ResponseEntity<Object> createApartment(@PathVariable("id") int id, @RequestBody Apartment apartment)
	{

		
		
		ApartmentComplex complex = apartmentComplexService.findByComplexId(id);
		apartment.setComplex(complex);
		String shortenedComplexName;
		if(complex.getName().length() > 17) {
			shortenedComplexName =complex.getName().replaceAll("\\s","").substring(0, 17);
		} else {
			shortenedComplexName = complex.getName().replaceAll("\\s","");
		}
		String channelName = shortenedComplexName+ new Integer(apartment.getApartmentNumber()).toString(); 
		try {
		String requestUrl = "https://slack.com/api/channels.create?token=" +
		"xoxp-229600595489-230131963906-233829842706-5845cfcf77a37f8ac146986f84c4f460" +"&name=" + channelName;
		requestUrl = requestUrl.replaceAll("\\s","");
		URL url = new URL(requestUrl);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod("GET");

		BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
			System.out.println(line);
		}
		br.close();
		
	} catch (ProtocolException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		
		return ResponseEntity.ok(apartmentService.save(apartment));
		
	}
	
	@RequestMapping(value ="Apartments/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateApartment(@PathVariable("id") int id, @RequestBody Apartment apartment)
	{
		Apartment oldApartment = apartmentService.findByApartmentId(id);
		apartment.setComplex(oldApartment.getComplex());
		System.out.println(slack.updateApartmentName(apartment, oldApartment));

		return ResponseEntity.ok(apartmentService.update(apartment));
		
	}
	
	@DeleteMapping(value ="Apartments/{id}")
	public ResponseEntity<Object> deleteApartment(@PathVariable("id") int id)
	{
		
		Apartment apartment = apartmentService.findByApartmentId(id);
		slack.deleteApartment(apartment);
		
		
		apartment.setComplex(null);
		apartmentService.update(apartment);

		if(apartment != null)
			apartmentService.delete(apartment);

		
		
		
		return ResponseEntity.ok("apartment deleted");
		
	}
	
	@RequestMapping(value ="Apartments/message/{id}")
	public ResponseEntity<Object> messageApartmentChannel(@PathVariable("id") int id, @RequestBody String announcement)
	{
		System.out.println(id + "announcement" + announcement);
		Apartment apartment = apartmentService.findByApartmentId(id);
		slack.sendApartmentMessage(apartment, announcement);
		return ResponseEntity.ok("Message sent");
	}
}
