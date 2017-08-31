package com.revature.application.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.application.model.Apartment;
import com.revature.application.model.ApartmentComplex;
import com.revature.application.model.Resident;
import com.revature.application.service.ApartmentService;
import com.revature.application.service.ResidentService;
import com.revature.application.slackapi.Slack;

@RestController
@RequestMapping("api")
public class ResidentController {

	@Autowired
	ResidentService residentService;
	@Autowired
	ApartmentService apartmentService;
	@Autowired
	Slack slack;
	
	
	@GetMapping("Residents")
	public ResponseEntity<Object> displayResidents() {
		return ResponseEntity.ok(residentService.findAll());
	}
	
	@RequestMapping(value ="Residents/Create", method=RequestMethod.POST)
	public ResponseEntity<Object> createNewResident(@RequestBody Resident resident){
		
		String requestUrl = "https://slack.com/api/users.admin.invite?token=" +
		"xoxp-229600595489-230131963906-233829842706-5845cfcf77a37f8ac146986f84c4f460" +"&email=" +resident.getEmail() +
		"&first_name=" + resident.getFirstName() + "&last_name=" + resident.getLastName();
		try {
		URL url = new URL(requestUrl);
		HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
		httpCon.setDoOutput(true);
		httpCon.setRequestMethod("GET");
		BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
		System.out.println(br.readLine());
		//View Slack response
		/*BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = br.readLine()) != null) {
			sb.append(line + "\n");
			System.out.println(line);
		}
		br.close();
		*/
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
		
		return ResponseEntity.ok(residentService.createResident(resident) );
	}
	
	@RequestMapping(value ="Apartments/{apartmentId}/Resident/{residentId}", method=RequestMethod.POST)
	public ResponseEntity<Object> removeResidentFromApartment(@PathVariable("apartmentId") int apartmentId, @PathVariable("residentId") int residentId){
		
		Apartment apartment = apartmentService.findByApartmentId(apartmentId);
		
		Resident resident = residentService.findByResidentId(residentId);
		
		
		
		slack.inviteUserApartmentComplexChannel(apartment, resident.getSlackId());
		slack.inviteUserApartmentChannel(apartment, resident.getSlackId());
		
		resident.setApartment(apartment);
		
		return ResponseEntity.ok(residentService.updateResident(resident));
		
	}
	
	@PutMapping("Residents/{id}")
	public ResponseEntity<Object> updateResident(@PathVariable("id") int id, @RequestBody Resident resident){
		System.out.println("im here right");
		Apartment apartment = apartmentService.findByApartmentId(id);
		resident.setApartment(apartment);
		
		
		return ResponseEntity.ok(residentService.updateResident(resident));
	}
	
	
	@RequestMapping(value ="Residents/{id}/Apartment", method=RequestMethod.DELETE)
	public ResponseEntity<Object> removeResidentFromApartment(@PathVariable("id") int id){
		Resident resident = residentService.findByResidentId(id);
		resident.removeApartment();
		
		return ResponseEntity.ok(residentService.updateResident(resident) );
		
	}
	
	@GetMapping("Residents/{id}")
	public ResponseEntity<Object> displayResident(@PathVariable("id") int id) {
		return ResponseEntity.ok(residentService.findByResidentId(id));
	}
	
	@GetMapping("Residents/email/{email}")
	public ResponseEntity<Object> displayResident(@PathVariable("email") String email) {
		email += ".com";//the .com is lost here because of url
		return ResponseEntity.ok(residentService.findByEmail(email));
	}
	
	@DeleteMapping("Residents/{id}")
	public void deleteResident(@PathVariable("id") int id){
		Resident resident = residentService.findByResidentId(id);
		resident.removeApartment();
		residentService.deleteResident(resident);
		//return ResponseEntity.ok();
		
	}
	
	
}
