package com.revature.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.application.model.ApartmentComplex;

public interface ApartmentComplexRepository extends JpaRepository<ApartmentComplex, Integer> {
	public ApartmentComplex findByComplexId(int id);
	
}
