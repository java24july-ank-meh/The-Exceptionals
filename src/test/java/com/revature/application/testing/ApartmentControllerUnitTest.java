package com.revature.application.testing;




import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.application.controller.ApartmentController;
import com.revature.application.model.Apartment;
import com.revature.application.model.ApartmentComplex;
import com.revature.application.service.ApartmentService;

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
		
		mockMvc.perform(get("api/Apartment")).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON));
		
		verify(apartmentService, times(1)).findAll();
	    verifyNoMoreInteractions(apartmentService);
	}
	
	//("*********Getting the Apartments By Complex Id********");	
	
	@Test
	public void getAllApartmentByComplexIdTest() throws Exception{
		ApartmentComplex mockApartment2 = new ApartmentComplex(2, "The Web", "email@mail.com", "240-878-0091", "The Apartment", "2345 How To Street", "3er4");
		when(apartmentService.findByComplexId(2)).thenReturn(mockApartment2);
		mockMvc.perform(get("ApartmentComplexes/{id}/Apartments", 2)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		verify(apartmentService, times(1)).findByComplexId(2);
	    verifyNoMoreInteractions(apartmentService);
	 
	}
	
	@Test
	public void displayApartmentbyApartmentIdTest() throws Exception {
		
		Apartment mockApartment3 = new Apartment(4, 210, 3, 10);
		when(apartmentService.findByApartmentId(4)).thenReturn(mockApartment3);
		mockMvc.perform(get("Apartments/{id}", 4)).andExpect(status().isOk())
		.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		verify(apartmentService, times(1)).findByApartmentId(2);
	    verifyNoMoreInteractions(apartmentService);
		
	}
	
	@Test
	public void createApartmentTest() throws Exception{
		Apartment mockApartment4 = new Apartment(76, 303, 3, 6);
		doNothing().when(apartmentService).create(mockApartment4);
	    mockMvc.perform(
	            post("\"ApartmentComplexes/{id}/Apartments/create")
	                    .contentType(MediaType.APPLICATION_JSON)
	                    .content(asJsonString(mockApartment4)))
	            .andExpect(status().isCreated())
	            .andExpect(header().string("location", containsString("http://localhost/users/")));
	    verify(userService, times(1)).create(user);
	    verifyNoMoreInteractions(userService);
		
	}
	
	@Test 
	public void updateApartmentTest() throws Exception{
		
	}
	
	@Test
	public void deleteApartmentTest()throws Exception{
		
	}
	
}
	
