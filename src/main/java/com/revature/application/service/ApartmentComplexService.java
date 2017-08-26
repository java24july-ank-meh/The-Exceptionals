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
	ApartmentComplexRepository apartmentComplexRepository;
	
	public List<ApartmentComplex> findAll() {
		return apartmentComplexRepository.findAll();
	}
	
	public ApartmentComplex findByComplexId(int id) {
		return apartmentComplexRepository.findByComplexId(id);
	}
	
	public int save(ApartmentComplex complex){
		return apartmentComplexRepository.saveAndFlush(complex).getComplexId();
	}
	
	public void delete(ApartmentComplex complex) {
		 apartmentComplexRepository.delete(complex);
	}
	

	

}
