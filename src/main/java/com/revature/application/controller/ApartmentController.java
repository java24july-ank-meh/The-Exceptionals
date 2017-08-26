package com.revature.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.application.service.ApartmentService;

@RestController
@RequestMapping("api")
public class ApartmentController {

	@Autowired
	ApartmentService service;
	
	@GetMapping("ApartmentComplexes/{id}/Apartments")
	public ResponseEntity<Object> displayApartment(@PathVariable("id") int id) {
		return ResponseEntity.ok(service.findByComplexId(id));
	}
}
