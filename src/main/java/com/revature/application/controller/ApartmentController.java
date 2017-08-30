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

import com.revature.application.model.Apartment;
import com.revature.application.model.ApartmentComplex;
import com.revature.application.service.ApartmentComplexService;
import com.revature.application.service.ApartmentService;



@RestController
@RequestMapping("api")
public class ApartmentController {

	@Autowired
	ApartmentService apartmentService;
	@Autowired
	ApartmentComplexService apartmentComplexService;
	
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

		String channelName =  complex.getName()+ new Integer(apartment.getApartmentNumber()).toString(); 
		try {
		String requestUrl = "https://slack.com/api/channels.create?token=" +
		"xoxp-229600595489-230131963906-233040140545-7e731ba52127f9adaadee62b925ac827" +"&name=" + channelName;
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

		return ResponseEntity.ok(apartmentService.update(apartment));
		
	}
	
	@DeleteMapping(value ="Apartments/{id}")
	public ResponseEntity<Object> deleteApartment(@PathVariable("id") int id)
	{
		Apartment apartment = apartmentService.findByApartmentId(id);
		apartment.setComplex(null);
		
		apartmentService.update(apartment);

		if(apartment != null)
			apartmentService.delete(apartment);

		
		return ResponseEntity.ok("apartment deleted");
		
	}
}
