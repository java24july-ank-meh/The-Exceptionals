package com.Exceptional.DAO;

import org.springframework.stereotype.Repository;

import com.Exceptional.Objects.Address;

@Repository
public interface AddressDAO {

	public void viewAddress();
	public void updateAddress(Address ess);
	public void createAddress();
	public void deleteAddress();
	
	//Add any other methods to use to manipulate the data
}

