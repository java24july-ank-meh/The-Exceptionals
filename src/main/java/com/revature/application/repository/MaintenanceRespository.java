package com.revature.application.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.revature.application.model.Apartment;
import com.revature.application.model.Maintenance;

public interface MaintenanceRespository extends JpaRepository<Maintenance, Integer>
{
	public List<Maintenance> findByApartment(Apartment apartment);

	public Maintenance findByMaintenanceId(int id);
}
