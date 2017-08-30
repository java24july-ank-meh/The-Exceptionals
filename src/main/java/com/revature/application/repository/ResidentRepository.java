package com.revature.application.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.application.model.Resident;

public interface ResidentRepository extends JpaRepository<Resident, Integer> {
	public Resident findByResidentId(Integer id);
	public Resident findByEmail(String email);
}
