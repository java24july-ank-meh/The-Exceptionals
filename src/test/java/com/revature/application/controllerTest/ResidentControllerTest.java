package com.revature.application.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
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
	
	@Test//Doubtfull functionality
	public void createNewResidentTest() throws Exception {
		
		
		Apartment apartment = apartmentService.findByApartmentId(234);
		
		resident = new Resident();
		resident.setFirstName("Cool");
		resident.setLastName("Man");
		resident.setEmail("coolman@cool.com");
		
		Gson gson = new Gson();
		
		String json = gson.toJson(resident);
		mvc.perform(MockMvcRequestBuilders.post("http://localhost:8181/api/Residents/create")
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
	
	@Test//doubtful
	public void removeResidentFromApartmentTest() throws Exception {
		
		List<Apartment> aptLis = new ArrayList();
		Set<Resident> resSet = new HashSet();
		ApartmentComplex aptCom = new ApartmentComplex();
		Apartment apt = new Apartment();
		Resident res = new Resident();
		
		aptCom.setComplexId(1);
		aptCom.setName("westerly");
		aptCom.setAddress("1234 raven");
		aptCom.setEmail("westerly@westerly.com");
		aptCom.setPhone("9876541122");
		aptCom.setPhoto("somePhoto");
		aptCom.setWebsite("thiswebsite.com");
		
		apt.setApartmentId(1);
		apt.setApartmentNumber(101);
		apt.setCapacity(6);
		apt.setOccupancy(1);
		apt.setComplex(aptCom);
		
		aptLis.add(apt);
		aptCom.setApartments(aptLis);
		
		res.setResidentId(1);
		res.setFirstName("cool");
		res.setLastName("Man");
		res.setEmail("cool@man.com");
		res.setPhone("9548257575");
		res.setSlackId("efer234f");
		res.setApartment(apt);
		
		resSet.add(res);
		apt.setResidents(resSet);
		
		String r_id = res.getResidentId().toString();
		String a_id = apt.getApartmentId().toString();
		
		mvc.perform(MockMvcRequestBuilders.post("http://localhost:8181/api/Apartments/{apartmentId}/Resident/{residentId}", a_id, r_id)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	
	}
	
	@Test
	public void updateResidentTest() throws Exception{
		
		Apartment apt = new Apartment();
		Resident res = new Resident();
		Resident newRes = new Resident();
		
		
		
		apt.setApartmentId(1);
		apt.setApartmentNumber(101);
		apt.setCapacity(6);
		apt.setOccupancy(1);
		apt.setComplex(null);
		apt.setResidents(null);
		
		res.setResidentId(1);
		res.setFirstName("cool");
		res.setLastName("Man");
		res.setEmail("cool@man.com");
		res.setPhone("9548257575");
		res.setSlackId("efer234f");
		res.setApartment(apt);
		
		
		newRes.setResidentId(1);
		newRes.setFirstName("coolest");
		newRes.setLastName("Man");
		newRes.setEmail("coolest@man.com");
		newRes.setPhone("9548200575");
		newRes.setSlackId("efeww34f");
		newRes.setApartment(res.getApartment());
		
		Gson gson = new Gson();
		String json = gson.toJson(newRes);
		System.out.println(json);
		int id = res.getResidentId();
		mvc.perform(MockMvcRequestBuilders.put("http://localhost:8181/api/Residents/{id}", id)
				.contentType(MediaType.APPLICATION_JSON)
				.content(json)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk());
	}

}