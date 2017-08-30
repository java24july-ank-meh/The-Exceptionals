package com.revature.application.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.application.model.ApartmentComplex;
import com.revature.application.service.ApartmentComplexService;

@RestController
@RequestMapping("api")
public class ApartmentComplexController {
	@Autowired
	ApartmentComplexService apartmentComplexService;
	
	@GetMapping("ApartmentComplexes")
	public ResponseEntity<Object> displayApartmentComplexes() {
		return ResponseEntity.ok(apartmentComplexService.findAll());
	}
	
	@GetMapping("ApartmentComplexes/{id}")
	public ResponseEntity<Object> displayApartmentComplex(@PathVariable("id") int id) {

		return ResponseEntity.ok(apartmentComplexService.findByComplexId(id));
	}
	
	@RequestMapping(value = "ApartmentComplexes/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateApartmentComplex(@RequestBody ApartmentComplex complex) {
	
		return ResponseEntity.ok(apartmentComplexService.save(complex));
	}
	
	
	@RequestMapping(value = "ApartmentComplexes/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteApartmentComplex(@PathVariable("id") int id ) {
		
		ApartmentComplex complex = apartmentComplexService.findByComplexId(id);
		
		if(complex != null)
			apartmentComplexService.delete(complex);
		
			
		return ResponseEntity.ok("file deleted");
	}
	
	
	@RequestMapping(value = "ApartmentComplexes/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createApartmentComplex(@RequestBody ApartmentComplex complex) {
		
		try {
			String requestUrl = "https://slack.com/api/channels.create?token=" +
			"xoxp-229600595489-230131963906-233040140545-7e731ba52127f9adaadee62b925ac827" +"&name=" + complex.getName();
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
			
		return ResponseEntity.ok(apartmentComplexService.save(complex));
	}
}
