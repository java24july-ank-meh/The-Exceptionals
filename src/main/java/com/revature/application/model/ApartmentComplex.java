package com.revature.application.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity
public class ApartmentComplex {
	@Id
	@Column(name="complexId")
	private Integer complexId;
	private String website;
	private String email;
	private String phone;
	private String name;
	
	//@OneToMany
	//@JoinColumn(name="aptsid")
	//private List<Apartment> apartments;

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

	public int getApts_id() {
		return complexId;
	}

	public void setApts_id(int complexId) {
		this.complexId = complexId;
		
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getApt_name() {
		return name;
	}

	public void setApt_name(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "ApartmentComplex [aptsid=" + complexId + ", website=" + website + ", email=" + email + ", phone=" + phone
				+ ", name=" + name + "]";
	}

}
