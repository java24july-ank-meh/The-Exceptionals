package com.revature.application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.revature.application.model.Apartment;
import com.revature.application.model.Maintenance;
import com.revature.application.repository.MaintenanceRespository;

@Service
@Transactional
public class MaintenanceService
{
	@Autowired
	MaintenanceRespository maintenanceRepository;
	
	
	public List<Maintenance> findAll(){
		return maintenanceRepository.findAll();
	}
	
	public List<Maintenance> findByApartment(Apartment apartment){
		return maintenanceRepository.findByApartment(apartment);
	}
	
	
	public int save(Maintenance maintenance )
	{
		return maintenanceRepository.saveAndFlush(maintenance).getMaintenanceId();
	}

	public Maintenance findById(int id)
	{
		return maintenanceRepository.findByMaintenanceId(id);
	}

	public int update(Maintenance maintenance)
	{
		
		return maintenanceRepository.saveAndFlush(maintenance).getMaintenanceId();
	}

	
	
}
