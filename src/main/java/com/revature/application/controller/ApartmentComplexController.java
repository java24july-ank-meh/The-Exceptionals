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

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.revature.application.model.Apartment;
import com.revature.application.model.ApartmentComplex;
import com.revature.application.service.ApartmentComplexService;
import com.revature.application.slackapi.Slack;

@RestController
@RequestMapping("api")
public class ApartmentComplexController {
	@Autowired
	ApartmentComplexService apartmentComplexService;
	
	@Autowired
	Slack slack;
	
	private String legacyToken = "xoxp-229600595489-230131963906-234509735570-17a3145b533362b2859ee0bed449127d";
	
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
	
		ApartmentComplex oldComplex = apartmentComplexService.findByComplexId(complex.getComplexId());
		try {
			String requestUrl = "https://slack.com/api/channels.list?token=" + legacyToken;
			URL url = new URL(requestUrl);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("GET");
			
			//slack channel naming must be 21 characters or less
			String shortenedComplexName;
			if(complex.getName().length() > 17) {
				shortenedComplexName =complex.getName().replaceAll("\\s","").substring(0, 17);
			} else {
				shortenedComplexName = complex.getName().replaceAll("\\s","");
			}
			
			String oldShortenedComplexName;
			if(complex.getName().length() > 17) {
				oldShortenedComplexName =oldComplex.getName().replaceAll("\\s","").substring(0, 17);
			} else {
				oldShortenedComplexName = oldComplex.getName().replaceAll("\\s","");
			}
			
			String channelName = oldShortenedComplexName; 
			String newChannelName = shortenedComplexName; 
			
			Apartment newApartment = new Apartment();
			newApartment.setComplex(complex);
			
			List<Apartment> apartments = new ArrayList<Apartment>();
			apartments = oldComplex.getApartments();
			for(int i = 0; i < complex.getApartments().size(); ++i) {
				newApartment.setApartmentNumber(apartments.get(i).getApartmentNumber());
				slack.updateApartmentName(newApartment, apartments.get(i));
			}
			
			BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			JsonObject jobj = new Gson().fromJson(br.readLine(), JsonObject.class);
			JsonArray jarray = jobj.get("channels").getAsJsonArray();
			String channelId = null;
			for(int i = 0; i < jarray.size(); ++i) {
				if(channelName.toLowerCase().equals(jarray.get(i).getAsJsonObject().get("name").getAsString())) {
					channelId  = jarray.get(i).getAsJsonObject().get("id").getAsString();
				}
			}
			System.out.println("channelname: " + channelName + " id:"+channelId);
			
			requestUrl = "https://slack.com/api/channels.rename?token=" +legacyToken +"&channel=" +channelId+
			"&name="+newChannelName;
			url = new URL(requestUrl);
			httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("GET");
			
			br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			System.out.println(br.readLine());
			
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
	
	
	@RequestMapping(value = "ApartmentComplexes/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteApartmentComplex(@PathVariable("id") int id ) {
		
		ApartmentComplex complex = apartmentComplexService.findByComplexId(id);
		
		
		String channelId = null;
		
		String shortenedComplexName;
		if(complex.getName().length() > 17) {
			shortenedComplexName =complex.getName().replaceAll("\\s","").substring(0, 17);
		} else {
			shortenedComplexName = complex.getName().replaceAll("\\s","");
		}
		
		try {
			List<Apartment> apartments = new ArrayList<Apartment>();
			apartments = complex.getApartments();
			for(int i = 0; i < apartments.size(); ++i) {
				slack.deleteApartment(apartments.get(i));
			}
			
			String requestUrl = "https://slack.com/api/channels.list?token=" +legacyToken;
			URL url = new URL(requestUrl);
			HttpURLConnection httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("GET");
			
			//slack channel naming must be 21 characters or less
			String channelName = shortenedComplexName; 
			
			
			BufferedReader br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			JsonObject jobj = new Gson().fromJson(br.readLine(), JsonObject.class);
			JsonArray jarray = jobj.get("channels").getAsJsonArray();
			for(int i = 0; i < jarray.size(); ++i) {
				if(channelName.toLowerCase().equals(jarray.get(i).getAsJsonObject().get("name").getAsString())) {
					channelId = jarray.get(i).getAsJsonObject().get("id").getAsString();
				}
			}
			System.out.println("channelname: " + channelName + " id:"+channelId);
			
			requestUrl = "https://slack.com/api/channels.archive?token=" +legacyToken +"&channel=" +channelId;
			url = new URL(requestUrl);
			httpCon = (HttpURLConnection) url.openConnection();
			httpCon.setDoOutput(true);
			httpCon.setRequestMethod("GET");
			
			br = new BufferedReader(new InputStreamReader(httpCon.getInputStream()));
			System.out.println(br.readLine());
			
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
		
		
		if(complex != null)
			apartmentComplexService.delete(complex);
		
			
		return ResponseEntity.ok("file deleted");
	}
	
	
	@RequestMapping(value = "ApartmentComplexes/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createApartmentComplex(@RequestBody ApartmentComplex complex) {
		
		String shortenedComplexName;
		if(complex.getName().length() > 17) {
			shortenedComplexName =complex.getName().replaceAll("\\s","").substring(0, 17);
		} else {
			shortenedComplexName = complex.getName().replaceAll("\\s","");
		}
		
		try {
			String requestUrl = "https://slack.com/api/channels.create?token=" +
			legacyToken +"&name=" + shortenedComplexName;
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
	
	@RequestMapping(value = "ApartmentComplexes/message/{id}", method = RequestMethod.POST)
	public ResponseEntity<Object> messageComplexChannel(@PathVariable("id") int id, @RequestBody String announcement) {
	
		ApartmentComplex complex = apartmentComplexService.findByComplexId(id);
		
		slack.sendApartmentComplexMessage(complex, announcement);
		
		return ResponseEntity.ok("success");
	}
}
