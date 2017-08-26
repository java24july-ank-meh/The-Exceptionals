package com.revature.application.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Manager {
	@Id
	private Integer managerId;
	private String firstName;
	private String lastName;
	private String phone;
	private String about;
	private String email;
	private String slackId;

	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Manager(int managerId, String firstName, String lastName, String phone, String about, String email,
			String slackId) {
		super();
		this.managerId = managerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.about = about;
		this.email = email;
		this.slackId = slackId;
	}

	public int getManagerId() {
		return managerId;
	}

	public void setManagerId(int managerId) {
		this.managerId = managerId;
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

	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", firstName=" + firstName + ", lastName=" + lastName + ", phone="
				+ phone + ", about=" + about + ", email=" + email + ", slackId=" + slackId + "]";
	}

}
