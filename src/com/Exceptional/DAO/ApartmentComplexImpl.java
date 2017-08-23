package com.Exceptional.DAO;

import javax.naming.spi.DirStateFactory.Result;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.Exceptional.Objects.Apartment;
import com.Exceptional.Objects.ApartmentComplex;
import com.Exceptional.Objects.Resident;

@Service
public class ApartmentComplexImpl implements ApartmentComplexDAO{
	
	
	@Autowired
	SessionFactory sf;
	
	public void setSf(SessionFactory sf) {
		this.sf = sf;
	}

	@Override
	public void createApartmentComplex(ApartmentComplex Apt) throws Exception {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		session.save(Apt);
	}
	
	@Override
	public ApartmentComplex readApartmentComplex(int id) throws Exception {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		ApartmentComplex resi = (ApartmentComplex) session.load(ApartmentComplex.class, id);
		return resi;
	}

	@Override
	public void updateApartmentComplex(ApartmentComplex Apt) throws Exception {
		// TODO Auto-generated method stub
		Session session = sf.getCurrentSession();
		session.saveOrUpdate(Apt);
	}

	

	@Override
	public void deleteApartmentComplex(ApartmentComplex Apt) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//@Transactional will be with the crud methods and anything that deals with changing the database
}
