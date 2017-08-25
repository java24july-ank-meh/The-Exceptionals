package com.revature.beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ApartmentComplex {
	@Id
	private int apts_id;
	private String website;
	private String email;
	private String phone;
	private String apt_name;

	public ApartmentComplex() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApartmentComplex(int apts_id, String website, String email, String phone, String apt_name) {
		super();
		this.apts_id = apts_id;
		this.website = website;
		this.email = email;
		this.phone = phone;
		this.apt_name = apt_name;
	}

	public int getApts_id() {
		return apts_id;
	}

	public void setApts_id(int apts_id) {
		this.apts_id = apts_id;
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
		return apt_name;
	}

	public void setApt_name(String apt_name) {
		this.apt_name = apt_name;
	}

	@Override
	public String toString() {
		return "ApartmentComplex [apts_id=" + apts_id + ", website=" + website + ", email=" + email + ", phone=" + phone
				+ ", apt_name=" + apt_name + "]";
	}

}
