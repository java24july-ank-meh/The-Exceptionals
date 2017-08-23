package com.Exceptional.DAO;

import org.springframework.stereotype.Repository;

@Repository
public interface ApartmentComplexDAO {
	
	public void readApartmentComplex();
	public void updateApartmentComplex();
	public void createApartmentComplex();
	public void deleteApartmentComplex();
	
	//Add any other methods to use to manipulate the data
}
