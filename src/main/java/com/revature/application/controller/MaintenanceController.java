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
import com.revature.application.model.Maintenance;
import com.revature.application.service.ApartmentService;
import com.revature.application.service.MaintenanceService;

@RestController
@RequestMapping("api")
public class MaintenanceController
{
	@Autowired
	MaintenanceService maintenanceService;
	@Autowired
	ApartmentService apartmentService;
	
	@GetMapping("Maintenance")
	public ResponseEntity<Object> displayAllMaintenanceRequest(){
		return ResponseEntity.ok(maintenanceService.findAll());
	}
	
	@RequestMapping(value="Apartments/{id}/Maintenance/create", method=RequestMethod.POST)
	public ResponseEntity<Object> createMaintanenceRequest(@PathVariable("id") int id, @RequestBody Maintenance maintenance)
	{
		Apartment apartment = apartmentService.findByApartmentId(id);
		maintenance.setApartment(apartment);
		return ResponseEntity.ok(maintenanceService.save(maintenance));
		
	}
	
	@RequestMapping(value="Maintenance/{id}")
	public ResponseEntity<Object> displayMaintenance(@PathVariable("id") int id)
	{
		return ResponseEntity.ok(maintenanceService.findById(id));
	}
	
	@GetMapping("Apartments/{id}/Maintenance")
	public ResponseEntity<Object> displayAllFromApartment(@PathVariable("id") int id)
	{
		return ResponseEntity.ok(maintenanceService.findByApartmentId(id));
	}
	
	@RequestMapping(value="Maintenance/{id}/complete", method=RequestMethod.POST)
	public ResponseEntity<Object> completeMaintenance(@PathVariable("id") int id)
	{
		Maintenance maintenance = maintenanceService.findById(id);
		
		maintenance.setResolved(true);
		return ResponseEntity.ok(maintenanceService.update(maintenance));
	}
}
