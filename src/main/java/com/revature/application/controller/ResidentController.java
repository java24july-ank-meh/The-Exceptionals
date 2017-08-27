package com.revature.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.revature.application.service.ResidentService;

@RestController
@RequestMapping("api")
public class ResidentController {

	@Autowired
	ResidentService service;
	
	@GetMapping("Residents")
	public ResponseEntity<Object> displayResidents() {
		return ResponseEntity.ok(service.findAll());
	}
	
	@GetMapping("Residents/{id}")
	public ResponseEntity<Object> displayResident(@PathVariable("id") int id) {
		return ResponseEntity.ok(service.findByResidentId(id));
	}
	
	
}
