package com.revature.mockmodels;

public class ApartmentComplex {
	private int id;
	private String name;
	private String phone;
	private String email;
	private String address;
	private String website;

	@Override
	public String toString() {
		return "ApartmentComplex [id=" + id + ", name=" + name + ", phone=" + phone + ", email=" + email + ", address="
				+ address + ", website=" + website + "]";
	}

	public ApartmentComplex() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApartmentComplex(int id, String name, String phone, String email, String address, String website) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.email = email;
		this.address = address;
		this.website = website;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
