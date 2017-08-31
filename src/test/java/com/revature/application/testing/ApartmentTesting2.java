package com.revature.application.testing;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.revature.application.controller.ApartmentController;
import com.revature.application.model.Apartment;
import com.revature.application.service.ApartmentService;

@RunWith(SpringRunner.class)
//@SpringBootTest
//@ContextConfiguration(classes = {ConfigTest.class})
//@WebAppConfiguration
@WebMvcTest(ApartmentController.class)
public class ApartmentTesting2 {
	
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private ApartmentService apartmentService;

	    @Test
	    public void getAllApartment() throws Exception {
	    	List<Apartment> mockApartments =Arrays.asList(new Apartment(32, 301, 4, 6), 
					new Apartment(12, 120, 6, 8));
	    	when(apartmentService.findAll()).thenReturn(mockApartments);
	        this.mockMvc.perform(get("http://localhost:8181/api/Apartment").accept(MediaType.parseMediaType("application/json;charset=UTF-8")))
	          .andExpect(status().isOk()).andDo(print())
	          .andExpect(content().contentType("application/json"));
	    }

}
