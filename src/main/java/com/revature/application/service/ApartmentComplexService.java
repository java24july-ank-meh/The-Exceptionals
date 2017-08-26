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

	ApartmentComplexRepository apartmentComplexRespository;
	
	public List<ApartmentComplex> findAll() {
		return apartmentComplexRespository.findAll();
	}
	
	public ApartmentComplex findByComplexId(int id) {
		return apartmentComplexRespository.findByComplexId(id);
	}
	
	public int save(ApartmentComplex complex){
		return apartmentComplexRespository.saveAndFlush(complex).getComplexId();
	}
	

	

}
