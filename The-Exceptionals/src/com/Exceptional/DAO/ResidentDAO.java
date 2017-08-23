package com.Exceptional.DAO;

import org.springframework.stereotype.Repository;

import com.Exceptional.Objects.Resident;
@Repository
public interface ResidentDAO {
	
	public void viewResident();
	public void updateResident();
	public void createResident();
	public void deleteResident();
	
	//Add any other methods to use to manipulate the data

}
