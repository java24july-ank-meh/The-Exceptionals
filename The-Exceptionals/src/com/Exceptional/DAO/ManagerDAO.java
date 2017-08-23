package com.Exceptional.DAO;

import org.springframework.stereotype.Repository;

import com.Exceptional.Objects.Manager;

@Repository
public interface ManagerDAO {
	
	public void readManager();
	public void updateManager(Manager m);
	public void createManager();
	public void deleteManager();
	
	//Add any other methods to use to manipulate the data
}
