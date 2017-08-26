package com.revature.application.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Resident {
	@Id
	private Integer residentId;
	private String firstName;
	private String lastName;
	private String phone;
	private String about;
	private String email;
	private String slackId;
	private int aptnumber;

	public Resident(int residentId, String firstName, String lastName, String phone, String about, String email,
			String slackId, int aptnumber) {
		super();
		this.residentId = residentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.about = about;
		this.email = email;
		this.slackId = slackId;
		this.aptnumber = aptnumber;
	}

	public Resident() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getResidentId() {
		return residentId;
	}

	public void setResidentId(int residentId) {
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

	public int getAptnumber() {
		return aptnumber;
	}

	public void setAptnumber(int aptnumber) {
		this.aptnumber = aptnumber;
	}

	@Override
	public String toString() {
		return "Resident [residentId=" + residentId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", about=" + about + ", email=" + email + ", slackId=" + slackId + ", aptnumber=" + aptnumber
				+ "]";
	}

}
