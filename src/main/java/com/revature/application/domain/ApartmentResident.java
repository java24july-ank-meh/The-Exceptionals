package com.revature.application.domain;

import java.sql.Date;

import com.revature.application.model.ApartmentComplex;

public class ApartmentResident {
	
	private long residentId;
	private long apartmentId;
	private long complexId;
	private String firstName;
	private String lastName;
	private String apartmentNumber;
	private Date date;
	private ApartmentComplex complex;
	
	public long getResidentId() {
		return residentId;
	}
	public void setResidentId(long residentId) {
		this.residentId = residentId;
	}
	public long getApartmentId() {
		return apartmentId;
	}
	public void setApartmentId(long apartmentId) {
		this.apartmentId = apartmentId;
	}
	public long getComplexId() {
		return complexId;
	}
	public void setComplexId(long complexId) {
		this.complexId = complexId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getApartmentNumber() {
		return apartmentNumber;
	}
	public void setApartmentNumber(String apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public ApartmentComplex getComplex() {
		return complex;
	}
	public void setComplex(ApartmentComplex complex) {
		this.complex = complex;
	}
	
	
	

}
