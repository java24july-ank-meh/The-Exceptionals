package com.revature.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.application.model.Manager;
import com.revature.application.repository.ManagerRepository;

@Service
@Transactional
public class ManagerService {
	@Autowired
	ManagerRepository repo;
	
	public List<Manager> findByManagerId(Integer id) {
		return repo.findByManagerId(id);
	}
}
