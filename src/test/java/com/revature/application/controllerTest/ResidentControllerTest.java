package com.revature.application.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.revature.application.model.Apartment;
import com.revature.application.model.Resident;
import com.revature.application.service.ApartmentService;
import com.revature.application.service.ResidentService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
public class ResidentControllerTest {

	
	
	Resident resident;
	@Autowired
	ResidentService residentService;
	@Autowired
	ApartmentService apartmentService;
	@Autowired
	public TestRestTemplate restTemplate;
	
	
	@Test
	public void displayResidentsTest(){
		
		String body = restTemplate.getForObject("http://localhost:8181/api/Residents", String.class);
		assertThat(body).isNotEmpty();
	}
	
	@Test
	public void createNewResidentTest() {
		//this works without adding the apartment to it.
		Resident newRes = new Resident();
		newRes.setResidentId(102);
		newRes.setFirstName("Jonh");
		newRes.setLastName("Connor");
		newRes.setEmail("john.connor@skynet.com");
		newRes.setPhone("(230)2341234");
		newRes.setSlackId("qs3124wq");
		newRes.setAbout("I like robots");
		
		String body = restTemplate.postForObject("http://localhost:8181/api/Residents/create", newRes, String.class);
		assertThat(body).isNotEmpty();
	}
	
}
