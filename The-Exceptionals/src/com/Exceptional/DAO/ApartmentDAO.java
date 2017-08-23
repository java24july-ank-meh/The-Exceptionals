package com.Exceptional.DAO;

import org.springframework.stereotype.Repository;

import com.Exceptional.Objects.Apartment;

@Repository
public interface ApartmentDAO {
	
	public void readApartment();
	public void updateApartment();
	public void createApartment();
	public void deleteApartment();
	
	//Add any other methods to use to manipulate the data
}
