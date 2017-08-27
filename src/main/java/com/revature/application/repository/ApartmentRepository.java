package com.revature.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.application.model.Apartment;

public interface ApartmentRepository extends JpaRepository<Apartment, Integer> {
	//public List<Apartment> findByComplexId(int id);
	
	public Apartment findByApartmentNumber(int id);
}
