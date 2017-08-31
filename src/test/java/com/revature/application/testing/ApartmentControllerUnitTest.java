package com.revature.application.testing;




import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.revature.application.controller.ApartmentController;
import com.revature.application.model.Apartment;
import com.revature.application.model.ApartmentComplex;
import com.revature.application.service.ApartmentService;

@RunWith(SpringJUnit4ClassRunner.class)
public class ApartmentControllerUnitTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private ApartmentService apartmentService;
	
	@InjectMocks
	private ApartmentController apartmentController;
	
	@Before
	public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(apartmentController).build();
    }
	
	@Test
	public void getAllApartmentTest() throws Exception {
		List<Apartment> mockApartments =Arrays.asList(new Apartment(32, 301, 4, 6), 
				new Apartment(12, 120, 6, 8)); 
		when(apartmentService.findAll()).thenReturn(mockApartments);
		
		mockMvc.perform(get("http://localhost:8181/api/Apartment")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON))
		.andExpect(jsonPath("$[0].apartmentId", is(32)))
        .andExpect(jsonPath("$[0].apartmentNumber", is(301)))
        .andExpect(jsonPath("$[0].occupancy", is(4)))
        .andExpect(jsonPath("$[0].capacity", is(6)))
        .andExpect(jsonPath("$[1].apartmentId", is(12)))
        .andExpect(jsonPath("$[1].apartmentNumber", is(120)))
        .andExpect(jsonPath("$[1].occupancy", is(6)))
        .andExpect(jsonPath("$[1].capacity", is(8)));
		verify(apartmentService, times(1)).findAll();
	    verifyNoMoreInteractions(apartmentService);
	}
	
	//*************Getting the Apartments By Complex Id*************	
	
	@Test
	public void getAllApartmentByComplexIdTest() throws Exception{
		ApartmentComplex mockApartment2 = new ApartmentComplex(2, "The Web", "email@mail.com", "240-878-0091", "The Apartment", "2345 How To Street", "3er4");
		List<Apartment> mockApartments =Arrays.asList(new Apartment(32, 301, 4, 6), 
				new Apartment(12, 120, 6, 8), new Apartment(98, 308, 10, 20));
		when(apartmentService.findByComplexId(2)).thenReturn(mockApartments);
		mockMvc.perform(get("http://localhost:8181/ApartmentComplexes/{id}/Apartments", 2)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		verify(apartmentService, times(1)).findByComplexId(2);
	    verifyNoMoreInteractions(apartmentService);
	 
	}
	
	//*************Getting the Apartments By Apartment Id*************	
	
	@Test
	public void displayApartmentbyApartmentIdTest() throws Exception {
		
		Apartment mockApartment3 = new Apartment(4, 210, 3, 10);
		when(apartmentService.findByApartmentId(4)).thenReturn(mockApartment3);
		mockMvc.perform(get("http://localhost:8181/Apartments/{id}", 4)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		verify(apartmentService, times(1)).findByApartmentId(2);
	    verifyNoMoreInteractions(apartmentService);
		
	}
	
	//*************Create the Apartments ******************
	
	@Test
	public void createApartmentTest() throws Exception{
		Apartment mockApartment4 = new Apartment(76, 303, 3, 6);
		Gson gson = new Gson();
        String json = gson.toJson(mockApartment4);
		
        doNothing().when(apartmentService).save(mockApartment4);
	    mockMvc.perform(
	            post("http://localhost:8181/ApartmentComplexes/{id}/Apartments/create")
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(json))
	            .andExpect(status().isCreated())
	            .andExpect(header().string("location", containsString("http://localhost/users/")));
	    verify(apartmentService, times(1)).save(mockApartment4);
	    verifyNoMoreInteractions(apartmentService);
		
	}
	//*******************Update the Apartment****************
	@Test 
	public void updateApartmentTest() throws Exception{
		Apartment mockApartment5 = new Apartment(60, 303, 3, 6);
		Gson gson = new Gson();
        String json = gson.toJson(mockApartment5);
		when(apartmentService.findByApartmentId(mockApartment5.getApartmentId())).thenReturn(mockApartment5);
	    doNothing().when(apartmentService).update(mockApartment5);
	    mockMvc.perform(
	            put("http://localhost:8181/Apartments/{id}", mockApartment5.getApartmentId())
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(json))
	            .andExpect(status().isOk());
	    verify(apartmentService, times(1)).findByApartmentId(mockApartment5.getApartmentId());
	    verify(apartmentService, times(1)).update(mockApartment5);
	    verifyNoMoreInteractions(apartmentService);
	}
	
	//******************Delete the Apartment**************
	
	@Test
	public void deleteApartmentTest()throws Exception{
		Apartment mockApartment6 = new Apartment();
		mockApartment6.setApartmentId(60);
		mockApartment6.setApartmentNumber(303);
		mockApartment6.setOccupancy(3);
		mockApartment6.setCapacity(6);
		when(apartmentService.findByApartmentId(mockApartment6.getApartmentId())).thenReturn(mockApartment6);
	    doNothing().when(apartmentService).delete(mockApartment6);
	    mockMvc.perform(
	            delete("http://localhost:8181/Apartments/{id}", mockApartment6.getApartmentId()))
	            .andExpect(status().isOk());
	    verify(apartmentService, times(1)).findByApartmentId(mockApartment6.getApartmentId());
	    verify(apartmentService, times(1)).delete(mockApartment6);
	    verifyNoMoreInteractions(apartmentService);
	}
	
}
	
