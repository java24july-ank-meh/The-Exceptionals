package com.Exceptional.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class ApartmentImpl implements ApartmentDAO {
	
	@Autowired
	SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");

	@Override
	public void readApartment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateApartment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createApartment() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteApartment() {
		// TODO Auto-generated method stub
		
	}
	
	//@Transactional will be with the crud methods and anything that deals with changing the database
}
