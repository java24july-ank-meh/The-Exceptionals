package com.Exceptional.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Exceptional.Objects.Address;

@Component("Address")
public class AddressImpl implements AddressDAO {
	
	@Autowired
	SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");

	@Override
	public void viewAddress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAddress(Address ess) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createAddress() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteAddress() {
		// TODO Auto-generated method stub
		
	}

	//@Transactional will be with the crud methods and anything that deals with changing the database
	
	
	

}
