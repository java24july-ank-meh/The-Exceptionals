package com.Exceptional.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ApartmentComplexImpl implements ApartmentComplexDAO{
	
	@Autowired
	SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");

	@Override
	public void readApartmentComplex() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateApartmentComplex() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createApartmentComplex() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteApartmentComplex() {
		// TODO Auto-generated method stub
		
	}
	
	//@Transactional will be with the crud methods and anything that deals with changing the database
}
