package com.revature.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.application.model.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer>{
	List<Manager> findByManagerId(Integer id);
}
