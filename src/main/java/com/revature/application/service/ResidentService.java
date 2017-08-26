package com.revature.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.application.model.Resident;
import com.revature.application.repository.ResidentRepository;

@Service
@Transactional
public class ResidentService {
	@Autowired
	ResidentRepository repo;
	
	public List<Resident> findByResidentId(Integer id) {
		return repo.findByResidentId(id);
	}
	
	public List<Resident> findAll() {
		return repo.findAll();
	}
}

