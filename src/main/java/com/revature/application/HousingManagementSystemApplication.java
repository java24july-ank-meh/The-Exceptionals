package com.revature.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class HousingManagementSystemApplication extends SpringBootServletInitializer {

	 	@Override
	    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
	        return application.sources(HousingManagementSystemApplication.class);
	    }
	
	public static void main(String[] args) {
		SpringApplication.run(HousingManagementSystemApplication.class, args);
	}
}


