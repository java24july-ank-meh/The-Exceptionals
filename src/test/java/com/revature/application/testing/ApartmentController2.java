package com.revature.application.testing;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.revature.application.controller.ApartmentController;
import com.revature.application.model.Apartment;
import com.revature.application.service.ApartmentService;

@RunWith(SpringRunner.class)
//@WebMvcTest(ApartmentController.class)
@WebAppConfiguration
@ContextConfiguration(classes = {MvcConfig.class})
public class ApartmentController2 {
	
	@Autowired
	public WebApplicationContext wac;
	
	private MockMvc mockMvc;
	
	@MockBean
	private ApartmentService apartmentService;
	
	@Before
	public void setUp()
	{
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}
	    @Test
	    public void getAllApartment() throws Exception {
	    	MockHttpServletRequestBuilder allApartments = get("/api/Apartments")
	        this.mockMvc.perform(allApartments)
	          .andExpect(status().isOk()).andDo(print())
	          .andExpect(content().contentType("application/json"));
	    }


}
