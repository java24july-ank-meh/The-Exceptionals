package com.Exceptional.Objects;


import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;

import org.springframework.stereotype.Repository;

@Repository
@Entity
public class Address {
	
	@Id
	private int a_id;
	@Column
	private String apt;
	private String street;
	private String city;
	private int zip;
	
	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Address(int a_id, String apt, String street, String city, int zip) {
		super();
		this.a_id = a_id;
		this.apt = apt;
		this.street = street;
		this.city = city;
		this.zip = zip;
	}

	public int getA_id() {
		return a_id;
	}

	public void setA_id(int a_id) {
		this.a_id = a_id;
	}

	public String getApt() {
		return apt;
	}

	public void setApt(String apt) {
		this.apt = apt;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getZip() {
		return zip;
	}

	public void setZip(int zip) {
		this.zip = zip;
	}
	
	

}
