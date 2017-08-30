package com.revature.application.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="RESIDENT")
@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property = "residentId")
public class Resident {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long residentId;
	private String firstName;
	private String lastName;
	private String phone;
	private String about;
	private String email;
	private String slackId;
	
	@Transient
	private long apartmentId;
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="APARTMENT_ID")
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "apartmentId", scope=Apartment.class)
	@JsonIdentityReference(alwaysAsId = true)
	//@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="apartmentId", scope = Apartment.class)
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
	
	public long getResidentId() {
		return residentId;
	}

	public void setResidentId(long residentId) {
		this.residentId = residentId;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAbout() {
		return this.about;
	}

	public void setAbout(String about) {
		this.about = about;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSlackId() {
		return this.slackId;
	}

	public void setSlackId(String slackId) {
		this.slackId = slackId;
	}

	public long getApartmentId() {
		return this.apartmentId;
	}

	public Apartment getApartment() {
		return this.apartment;
	}

	public void setApartment(Apartment apartment) {
		this.apartment = apartment;
		this.apartmentId = apartment.getApartmentId();
	}
	
	public void removeApartment() {
		this.apartment = null;
	}

	@Override
	public String toString() {
		return "Resident [residentId=" + residentId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", about=" + about + ", email=" + email + ", slackId=" + slackId + ", apartmentId="
				+ apartmentId + "]";
	}

	
	

}
