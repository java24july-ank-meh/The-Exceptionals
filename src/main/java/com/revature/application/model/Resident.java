package com.revature.application.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="RESIDENT")
public class Resident {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer residentId;
	private String firstName;
	private String lastName;
	private String phone;
	private String about;
	private String email;
	private String slackId;
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="APARTMENT_ID")
	private Apartment apartment;

	public Resident() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resident(String firstName, String lastName, String phone, String about, String email, String slackId,
			Apartment apartment) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.about = about;
		this.email = email;
		this.slackId = slackId;
		this.apartment = apartment;
	}

	public Integer getResidentId() {
		return residentId;
	}

	public void setResidentId(Integer residentId) {
		this.residentId = residentId;
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAbout() {
		return about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSlackId() {
		return slackId;
	}

	public void setSlackId(String slackId) {
		this.slackId = slackId;
	}

	public Apartment getApartment() {
		return apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
	}

	@Override
	public String toString() {
		return "Resident [residentId=" + residentId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", about=" + about + ", email=" + email + ", slackId=" + slackId + ", apartment=" + apartment
				+ "]";
	}

	

}
