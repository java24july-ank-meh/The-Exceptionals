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
	ApartmentRepository apartmentRepository;
	
	public List<Apartment> findAll(){
		return apartmentRepository.findAll();
	};
	
	public List<Apartment> findByComplexId(int id) {
		return apartmentRepository.findByComplexId(id);
	}
	
	public Apartment findByAptNumber(int id) {
		return apartmentRepository.findByAptNumber(id);
	}
	
	public int save(Apartment apartment) {
		return apartmentRepository.saveAndFlush(apartment).getAptnumber();
	}
	
	public int update(Apartment apartment) {
		return apartmentRepository.saveAndFlush(apartment).getAptnumber();
	}
	
	public void delete(Apartment apartment) {
		 apartmentRepository.delete(apartment);
	}
}
