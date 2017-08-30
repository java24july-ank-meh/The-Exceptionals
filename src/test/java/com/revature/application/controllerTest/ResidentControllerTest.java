package com.revature.application.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.revature.application.controller.ResidentController;
import com.revature.application.model.Apartment;
import com.revature.application.model.ApartmentComplex;
import com.revature.application.model.Resident;
import com.revature.application.service.ApartmentService;
import com.revature.application.service.ResidentService;

import oracle.net.aso.e;

import com.google.gson.*;

@RunWith(SpringRunner.class)
@WebMvcTest(ResidentController.class)
public class ResidentControllerTest {

	@Autowired
	private MockMvc mvc;
	
	@MockBean
	Resident resident;
	@MockBean
	Apartment apartment;
	@MockBean
	ApartmentComplex apartmentComplex;
	
	@MockBean
	ResidentService residentService;
	@MockBean
	ApartmentService apartmentService;
	
	
	public TestRestTemplate restTemplate;
	
	
	@Test
	public void displayResidentsTest() throws Exception {
		mvc.perform(MockMvcRequestBuilders.get("http://localhost:8181/api/Residents")
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}
	
	@Test//this still has problems with the apartment...
	public void createNewResidentTest() throws Exception {
		
		
		Apartment apartment = apartmentService.findByApartmentId(234);
		
		resident = new Resident();
		resident.setResidentId(2);
		resident.setFirstName("Cool");
		resident.setLastName("Man");
		resident.setEmail("coolman@cool.com");
		resident.setPhone("548791234");
		resident.setSlackId("32f4443rwd");
		resident.setAbout("Yeah boi");
		resident.setApartment(apartment);
		
		Gson gson = new Gson();
		
		String json = gson.toJson(resident);
		System.out.println(json);
		mvc.perform(MockMvcRequestBuilders.put("http://localhost:8181/api/Residents/create")
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
		
		/*.param("residentId", resident.getResidentId().toString())
		.param("firstName", resident.getFirstName())
		.param("lastName", resident.getLastName())
		.param("phone", resident.getPhone())
		.param("about", resident.getAbout())
		.param("email", resident.getEmail())
		.param("slackId", resident.getSlackId())
		.param("apartmentId", "0")
		.param("apartment", "234")*/
	}
	
	@Test
	public void removeResidentFromApartment() throws Exception {
		
		apartmentComplex = new ApartmentComplex();
		apartment = new Apartment();
		resident = new Resident();
		
		//complex
		apartmentComplex.setComplexId(111);
		apartmentComplex.setEmail("this@isatest.com");
		apartmentComplex.setName("Westerly");
		apartmentComplex.setPhone("9526445555");
		apartmentComplex.setAddress("1234 theStreet");
		apartmentComplex.setWebsite("www.westerly.com");
		
		//apartment
		apartment.setApartmentId(1);
		apartment.setApartmentNumber(101);
		apartment.setCapacity(6);
		apartment.setComplex(apartmentComplex);
		apartment.setOccupancy(1);
		
		//resident
		resident.setResidentId(1);
		resident.setFirstName("Cool");
		resident.setLastName("Man");
		resident.setEmail("coolman@cool.com");
		resident.setPhone("4995468585");
		resident.setSlackId("23rf34f");
		resident.setAbout("I am a cool man");
		
		Set<Resident> resLi = new HashSet<Resident>();
		
		resLi.add(resident);
		
		apartment.setResidents(resLi);
		
		String a_id = apartment.getApartmentId().toString();
		String r_id = resident.getResidentId().toString();
		mvc.perform(MockMvcRequestBuilders.post("http://localhost:8181/api/Apartments/" + a_id + "/Resident/" + r_id)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	
	}
	
	@Test
	public void updateResidentTest() {
		
	}

}