package com.Exceptional.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Exceptional.Objects.Resident;

@Transactional
@Component("Resident")
public class ResidentImpl implements ResidentDAO {
	@Autowired
	SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");

	@Override
	public void viewResident() {
		
	}

	@Override
	public void updateResident() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createResident() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteResident() {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
	//@Transactional will be with the crud methods and anything that deals with changing the database
}
