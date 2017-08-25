package Calebsthings;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.*;

import org.springframework.stereotype.Repository;

@Repository
@Entity
public class ApartmentComplex {

	@Id
	private int apt_id;
	@Column
	private String aptName;
	@Column
	private String website;
	@Column
	private String email;
	@Column
	private String phone;

	@OneToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "a_id")
	private Address add;
	@OneToMany
	@JoinColumn(name = "apt_id")
	private List<Apartment> apat;

	public ApartmentComplex() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApartmentComplex(int apt_id, String aptName, String website, String email, String phone, Address add,
			Apartment apat) {
		super();
		this.apt_id = apt_id;
		this.aptName = aptName;
		this.website = website;
		this.email = email;
		this.phone = phone;
	}

	
	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}

	public String getAptName() {
		return aptName;
	}

	public void setAptName(String aptName) {
		this.aptName = aptName;
	}


	public List<Apartment> getApat() {
		return apat;
	}

	public void setApat(List<Apartment> apat) {
		this.apat = apat;
	}

	public int getApt_id() {
		return apt_id;
	}

	public void setApt_id(int apt_id) {
		this.apt_id = apt_id;
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

}
