package com.revature.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.revature.application.model.Apartment;
import com.revature.application.model.ApartmentComplex;
import com.revature.application.service.ApartmentComplexService;
import com.revature.application.service.ApartmentService;



@RestController
@RequestMapping("api")
public class ApartmentController {

	@Autowired
	ApartmentService apartmentService;
	@Autowired
	ApartmentComplexService apartmentComplexService;
	
	@GetMapping("Apartments")
	public ResponseEntity<Object> displayAllApartments() {
		return ResponseEntity.ok(apartmentService.findAll());
	}
	
	@GetMapping("ApartmentComplexes/{id}/Apartments")
	public ResponseEntity<Object> displayApartmentsFromComplex(@PathVariable("id") int id) {
		return ResponseEntity.ok(apartmentService.findByComplexId(id));
	}
	
	@GetMapping("Apartments/{id}")
	public ResponseEntity<Object> displayApartment(@PathVariable("id") int id) {
		return ResponseEntity.ok(apartmentService.findByApartmentId(id));
	}
	
	@RequestMapping(value ="ApartmentComplexes/{id}/Apartments/create", method=RequestMethod.POST)
	public ResponseEntity<Object> createApartment(@PathVariable("id") int id, @RequestBody Apartment apartment)
	{
		ApartmentComplex complex = apartmentComplexService.findByComplexId(id);
		apartment.setComplex(complex);
		
		return ResponseEntity.ok(apartmentService.save(apartment));
		
	}
	
	@RequestMapping(value ="Apartments/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateApartment(@PathVariable("id") int id, @RequestBody Apartment apartment)
	{
		Apartment oldApartment = apartmentService.findByApartmentId(id);
		apartment.setComplex(oldApartment.getComplex());

		return ResponseEntity.ok(apartmentService.update(apartment));
		
	}
	
	@RequestMapping(value ="Apartments/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Object> deleteApartment(@PathVariable("id") int id)
	{
		Apartment apartment = apartmentService.findByApartmentId(id);
		
		if(apartment != null)
			apartmentService.delete(apartment);

		
		return ResponseEntity.ok("apartment deleted");
		
	}
}
