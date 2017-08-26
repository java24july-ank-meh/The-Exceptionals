package com.revature.application.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Apartment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="aptNumber")
	private int aptNumber;
	private int occupancy;
	private int capacity;
	private int complexId;
	
	
//	@ManyToOne
//	@JoinColumn(name="aptNumber")
//	private ApartmentComplex complex;


	public Apartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartment(int aptNumber, int occupancy, int capacity, int complexId) {
		super();
		this.aptNumber = aptNumber;
		this.occupancy = occupancy;
		this.capacity = capacity;
		this.complexId = complexId;
	}

	public int getAptnumber() {
		return this.aptNumber;
	}

	public void setAptnumber(int aptNumber) {
		this.aptNumber = aptNumber;
	}

	public int getOccupancy() {
		return occupancy;
	}

	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getComplexId() {
		return complexId;
	}

	public void setComplexId(int complexId) {
		this.complexId = complexId;
	}

	@Override
	public String toString() {
		return "Apartment [aptnumber=" + aptNumber + ", occupancy=" + occupancy + ", capacity=" + capacity + ", complexId="
				+ complexId + "]";
	}

}
