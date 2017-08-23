package com.Exceptional.DAO;

import org.hibernate.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

//import com.Exceptional.Util.SessionsUtil;
import com.Exceptional.Objects.Address;

public class HibernateTest {
	
	public static void main(String args[]) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext("appContext.xml");
		AddressDAO service = (AddressDAO)ctx.getBean("service");
		
		//Persist teacher object
		Address where = new Address(34, "WtheApt", "Wave Street", "Reston", 38845);
		
		//call business logic
		//service.insertTeacher(where);
		System.out.println("done");

		
	}

}
