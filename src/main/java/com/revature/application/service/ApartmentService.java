package com.revature.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.application.model.Apartment;
import com.revature.application.model.ApartmentComplex;
import com.revature.application.repository.ApartmentComplexRepository;
import com.revature.application.repository.ApartmentRepository;

@Service
@Transactional
public class ApartmentService {
	@Autowired
	ApartmentRepository ar;
	
	public List<Apartment> findByComplexId(Integer id) {
		return ar.findByComplexId(id);
	}
}
