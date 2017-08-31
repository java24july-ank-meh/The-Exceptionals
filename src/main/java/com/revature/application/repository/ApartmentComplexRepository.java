package com.revature.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.application.model.ApartmentComplex;

@Repository
public interface ApartmentComplexRepository extends JpaRepository<ApartmentComplex, Integer> {
	public ApartmentComplex findByComplexId(int id);

}
