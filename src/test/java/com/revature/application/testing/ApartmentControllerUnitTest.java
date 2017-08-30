package com.revature.application.testing;




import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.revature.application.controller.ApartmentController;
import com.revature.application.model.Apartment;
import com.revature.application.service.ApartmentService;

public class ApartmentControllerUnitTest {
	
	private MockMvc mockMvc;
	
	@Mock
	private ApartmentService apartmentService;
	@InjectMocks
	private ApartmentController apartmentController;
	
	public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(apartmentController).build();
    }
	
	@Test
	public void getAllApartmentTest() throws Exception {
		List<Apartment> mockApartments =Arrays.asList(new Apartment(32, 301, 4, 6), new Apartment(12, 120, 6, 8)); 
		when(apartmentService.findAll()).thenReturn(mockApartments);
		mockMvc.perform(get("api/Apartment")).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON);
		
		
	}
	
	
	
	
}
	
