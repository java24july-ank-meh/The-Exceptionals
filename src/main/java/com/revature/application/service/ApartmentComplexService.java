package com.revature.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.application.model.ApartmentComplex;
import com.revature.application.repository.ApartmentComplexRepository;

@Service
@Transactional
public class ApartmentComplexService {
	@Autowired
	ApartmentComplexRepository acr;
	
	public List<ApartmentComplex> findAll() {
		return acr.findAll();
	}
	
	public List<ApartmentComplex> findByComplexId(Integer id) {
		return acr.findByComplexId(id);
	}
}
