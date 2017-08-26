package com.revature.application.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.application.model.ApartmentComplex;
import com.revature.application.service.ApartmentComplexService;

@RestController
@RequestMapping("api")
public class ApartmentComplexController {
	@Autowired
	ApartmentComplexService apartmentComplexService;
	
	@GetMapping("ApartmentComplexes")
	public ResponseEntity<Object> displayApartmentComplexes() {
		return ResponseEntity.ok(apartmentComplexService.findAll());
	}
	
	@GetMapping("ApartmentComplexes/{id}")
	public ResponseEntity<Object> displayApartmentComplex(@PathVariable("id") int id) {
		return ResponseEntity.ok(apartmentComplexService.findByComplexId(id));
	}
	
	@RequestMapping(value = "ApartmentComplexes/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Object> updateApartmentComplex(@RequestBody ApartmentComplex complex) {
	
		return ResponseEntity.ok(apartmentComplexService.save(complex));
	}
	
	
	@RequestMapping(value = "ApartmentComplexes/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Object> deleteApartmentComplex(@PathVariable("id") int id ) {
		
		ApartmentComplex complex = apartmentComplexService.findByComplexId(id);
		
		if(complex != null)
			apartmentComplexService.delete(complex);
		
			
		return ResponseEntity.ok("file deleted");
	}
	
	
	@RequestMapping(value = "ApartmentComplexes/create", method = RequestMethod.POST)
	public ResponseEntity<Object> createApartmentComplex(@RequestBody ApartmentComplex complex) {
		
		return ResponseEntity.ok(apartmentComplexService.save(complex));
	}
}
