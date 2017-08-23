package com.Exceptional.Objects;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.springframework.stereotype.Repository;
@Repository
@Entity
public class Apartment {
	
	@Id
	private int apt_id;
	@Column
	private String apt_number;
	@Column
	private int capacity;
	@Column
	private int occupancy;
	
	/*@OneToMany(mappedBy = "", cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinColumn(name= "apt_id")
    private Set<Resident> res;
	
	@ManyToOne
	@JoinColumn(name = "apt_id", referencedColumnName = "apt_id", insertable = false, updatable = false)
	private ApartmentComplex ac2;*/
	
	public Apartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartment(int apt_id, String apt_number, int capacity, int occupancy, ApartmentComplex ac2) {
		super();
		this.apt_id = apt_id;
		this.apt_number = apt_number;
		this.capacity = capacity;
		this.occupancy = occupancy;
	}

	public int getApts_id() {
		return apt_id;
	}

	public void setApt_id(int apts_id) {
		this.apt_id = apts_id;
	}

	public String getApt_number() {
		return apt_number;
	}

	public void setApt_number(String apt_number) {
		this.apt_number = apt_number;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}
	
	
	
	
}
