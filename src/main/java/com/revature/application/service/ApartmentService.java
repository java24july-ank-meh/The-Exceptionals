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
	@Autowired
	ApartmentComplexRepository apartmentComplexRepository;
	
	public List<Apartment> findAll(){
		return apartmentRepository.findAll();
	};
	
	public List<Apartment> findByComplexId(int id) {
		ApartmentComplex apartmentComplex = apartmentComplexRepository.findByComplexId(id);
		return apartmentComplex.getApartments();
	}
	
	public Apartment findByApartmentId(Integer id) {
		return apartmentRepository.findByApartmentId(id);
	}
	
	public int save(Apartment apartment) {
		return apartmentRepository.saveAndFlush(apartment).getApartmentNumber();
	}
	
	public int update(Apartment apartment) {
		return apartmentRepository.saveAndFlush(apartment).getApartmentNumber();
	}
	
	public void delete(Apartment apartment) {
		 apartmentRepository.delete(apartment);
	}
}
