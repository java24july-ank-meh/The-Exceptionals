package com.revature.application.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name="APARTMENT")
public class Apartment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer apartmentId;
	private int apartmentNumber;
	@Column(name="aptNumber")
	private int aptNumber;
	private int occupancy;
	private int capacity;
	private int complexId;
	
	@OneToMany(mappedBy="apartment", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Resident> residents;
	
//	@ManyToOne
//	@JoinColumn(name="aptNumber")
//	private ApartmentComplex complex;


	public Apartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartment(int apartmentNumber, int occupancy, int capacity, int complexId, Set<Resident> residents) {
		super();
		this.apartmentNumber = apartmentNumber;
		this.occupancy = occupancy;
		this.capacity = capacity;
		this.complexId = complexId;
		this.residents = residents;
	}

	public Integer getApartmentId() {
		return this.apartmentId;
	}

	public void setApartmentId(Integer apartmentId) {
		this.apartmentId = apartmentId;
	}

	public int getApartmentNumber() {
		return this.apartmentNumber;
	}

	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
	}
	public int getAptnumber() {
		return this.aptNumber;
	}

	public void setAptnumber(int aptNumber) {
		this.aptNumber = aptNumber;
	}

	public int getOccupancy() {
		return this.occupancy;
	}

	public void setOccupancy(int occupancy) {
		this.occupancy = occupancy;
	}

	public int getCapacity() {
		return this.capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getComplexId() {
		return this.complexId;
	}

	public void setComplexId(int complexId) {
		this.complexId = complexId;
	}

	public Set<Resident> getResidents() {
		return this.residents;
	}

	public void setResidents(Set<Resident> residents) {
		this.residents = residents;
	}

	@Override
	public String toString() {
		return "Apartment [apartmentId=" + apartmentId + ", apartmentNumber=" + apartmentNumber + ", aptNumber="
				+ aptNumber + ", occupancy=" + occupancy + ", capacity=" + capacity + ", complexId=" + complexId
				+ ", residents=" + residents + "]";
	}

	

	

}
