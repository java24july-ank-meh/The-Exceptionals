package com.revature.application.controller;

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
import com.revature.application.model.Resident;
import com.revature.application.service.ApartmentService;
import com.revature.application.service.ResidentService;

@RestController
@RequestMapping("api")
public class ResidentController {

	@Autowired
	ResidentService residentService;
	@Autowired
	ApartmentService apartmentService;
	
	@GetMapping("Residents")
	public ResponseEntity<Object> displayResidents() {
		return ResponseEntity.ok(residentService.findAll());
	}
	
	@RequestMapping(value ="Residents/create", method=RequestMethod.POST)
	public ResponseEntity<Object> createNewResident(@RequestBody Resident resident){
		Apartment apartment = apartmentService.findByApartmentId(1);
		resident.setApartment(apartment);
		System.out.println("hi");
		return ResponseEntity.ok(residentService.createResident(resident) );
	}
	
	@RequestMapping(value ="Apartments/{apartmentId}/Resident/{residentId}", method=RequestMethod.POST)
	public ResponseEntity<Object> removeResidentFromApartment(@PathVariable("apartmentId") int apartmentId, @PathVariable("residentId") int residentId){
		
		Apartment apartment = apartmentService.findByApartmentId(apartmentId);
		
		Resident resident = residentService.findByResidentId(residentId);
		
		resident.setApartment(apartment);
		
		return ResponseEntity.ok(residentService.updateResident(resident));
		
	}
	
	@RequestMapping(value="Residents/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Object> updateResident(@PathVariable("id") int id, @RequestBody Resident resident){

	
		Resident oldRes = residentService.findByResidentId(id);
		Apartment newApt = oldRes.getApartment();
		ApartmentComplex aptCom = newApt.getComplex();
		
		newApt.setComplex(aptCom);
		resident.setApartment(newApt);
		
		
		return ResponseEntity.ok(residentService.updateResident(resident));
	}
	
	
	@RequestMapping(value ="Residents/{id}/Apartment", method=RequestMethod.DELETE)
	public ResponseEntity<Object> removeResidentFromApartment(@PathVariable("id") int id){
		Resident resident = residentService.findByResidentId(id);
		resident.removeApartment();
		
		return ResponseEntity.ok(residentService.updateResident(resident) );
		
	}
	
	@GetMapping("Residents/{id}")
	public ResponseEntity<Object> displayResident(@PathVariable("id") int id) {
		return ResponseEntity.ok(residentService.findByResidentId(id));
	}
	
	
}
