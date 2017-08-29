package com.revature.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.application.model.Resident;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {
	public Resident findByResidentId(Integer id);

	public Iterable<Resident> findByApartmentId();
}
