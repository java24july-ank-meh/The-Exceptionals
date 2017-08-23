package com.Exceptional.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Repository;

@Repository
@Entity
public class Manager {
	@Id
	private long m_id;
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
	private long Slack_id;
	
	public Manager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Manager(long m_id, String fname, String lname, String phone, String about, String email, long slack_id) {
		super();
		this.m_id = m_id;
		this.fname = fname;
		this.lname = lname;
		this.phone = phone;
		this.about = about;
		this.email = email;
		Slack_id = slack_id;
	}
	public long getM_id() {
		return m_id;
	}
	public void setM_id(long m_id) {
		this.m_id = m_id;
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
	public long getSlack_id() {
		return Slack_id;
	}
	public void setSlack_id(long slack_id) {
		Slack_id = slack_id;
	}
	
	
}
