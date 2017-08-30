package com.revature.application.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;
@Entity
@Table(name="APARTMENT_COMPLEX")
public class ApartmentComplex {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int complexId;
	private String website;
	private String email;
	private String phone;
	private String name;
	private String address;
	
	@OneToMany(mappedBy="complex", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private List<Apartment> apartments;

	public ApartmentComplex() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApartmentComplex(int complexId, String website, String email, String phone, String name) {
		super();
		this.complexId = complexId;
		this.website = website;
		this.email = email;
		this.phone = phone;
		this.name = name;
	}

	public long getComplexId() {
		return this.complexId;
	}

	public void setComplexId(int complexId) {
		this.complexId = complexId;
		
	}

	public String getWebsite() {
		return this.website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public List<Apartment> getApartments() {
		return this.apartments;
	}

	public void setApartments(List<Apartment> apartments) {
		this.apartments = apartments;
	}


	@Override
	public String toString() {
		return "ApartmentComplex [aptsid=" + complexId + ", website=" + website + ", email=" + email + ", phone=" + phone
				+ ", name=" + name + "]";
	}

}
