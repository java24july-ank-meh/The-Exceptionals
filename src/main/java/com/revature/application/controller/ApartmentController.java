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
	ApartmentService as;
	
	@GetMapping("ApartmentComplexes/{id}/Apartments")
	public ResponseEntity<Object> displayApartmentComplex(@PathVariable("id") int id) {
		/*List<ApartmentComplex> ACs = new ArrayList<>();
		ACs.add(new ApartmentComplex(1, "Sycamores", "2856395737", "sycamores@email.com", "1815 Sycomre dr something", "www.sycamores.com"));
		ACs.add(new ApartmentComplex(2, "Wesley Worldgate", "2856395737", "worldgate@email.com", "worldgate dr something", "www.worldgate.com"));*/
		return ResponseEntity.ok(as.findByComplexId(id));
	}
}
