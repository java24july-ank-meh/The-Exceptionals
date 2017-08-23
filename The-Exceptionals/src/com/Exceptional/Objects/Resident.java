package com.Exceptional.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Repository;

@Repository
@Entity
public class Resident {

	// Thinking of using just the slack id to use a the primary key and get rid of
	// r_id since Slack_id is Unique anyways
	@Id
	private int r_id;
	@Column
	private String fname;
	@Column
	private String lname;
	@Column
	private String phone;
	@Column
	private String about;
	@Column
	private String email;
	@Column(unique = true)
	private int Slack_id;

	@ManyToOne(fetch = FetchType.LAZY, optional=false)
	@JoinColumn(name="apt_id")
	private Apartment apts;

	public Resident() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Resident(int r_id, String fname, String lname, String phone, String about, String email, int slack_id,
			Apartment apts) {
		super();
		this.r_id = r_id;
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.about = about;
		this.email = email;
		Slack_id = slack_id;
		this.apts = apts;
	}

	public int getR_id() {
		return r_id;
	}

	public void setR_id(int r_id) {
		this.r_id = r_id;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
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

	public int getSlack_id() {
		return Slack_id;
	}

	public void setSlack_id(int slack_id) {
		Slack_id = slack_id;
	}

	public Apartment getApts() {
		return apts;
	}

	public void setApts(Apartment apts) {
		this.apts = apts;
	}

}
