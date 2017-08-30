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
	ResidentRepository residentRepository;
	
	public Resident findByResidentId(Integer id) {
		return residentRepository.findByResidentId(id);
	}
	
	public List<Resident> findAll() {
		return residentRepository.findAll();
	}
	
	public Integer createResident(Resident resident) {
		return (int)residentRepository.saveAndFlush(resident).getResidentId();
	}
	
	public Integer updateResident(Resident resident) {
		return (int) residentRepository.saveAndFlush(resident).getResidentId();
	}
	
	public Resident findByEmail(String email) {
		return residentRepository.findByEmail(email);
	}
}

