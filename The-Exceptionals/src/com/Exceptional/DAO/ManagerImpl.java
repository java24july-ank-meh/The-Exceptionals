package com.Exceptional.DAO;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.Exceptional.Objects.Manager;


public class ManagerImpl implements ManagerDAO {

	@Autowired
	SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}
	
	private static ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");

	@Override
	public void readManager() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateManager(Manager m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createManager() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteManager() {
		// TODO Auto-generated method stub
		
	}
	
	//@Transactional will be with the crud methods and anything that deals with changing the database

}
