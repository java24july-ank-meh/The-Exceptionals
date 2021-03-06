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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "APARTMENT")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "apartmentId")
public class Apartment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer apartmentId;
	private int apartmentNumber;
	private int occupancy;
	private int capacity;

	@OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private Set<Resident> residents;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COMPLEX_ID")
	@JsonIdentityInfo(scope=ApartmentComplex.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "complexId")
	@JsonIdentityReference(alwaysAsId = true)
	private ApartmentComplex complex;

	public Apartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartment(Integer apartmentId, int apartmentNumber, int occupancy, int capacity) {
		super();
		this.apartmentId = apartmentId;
		this.apartmentNumber = apartmentNumber;
		this.occupancy = occupancy;
		this.capacity = capacity;
		
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
	
	public void setComplex(ApartmentComplex complex) {
		this.complex = complex;
	}
	
	public ApartmentComplex getComplex() {
		return complex;
	}
	
	public Set<Resident> getResidents() {
		return this.residents;
	}

	public void setResidents(Set<Resident> residents) {
		this.residents = residents;
	}

	@Override
	public String toString() {
		return "Apartment [apartmentId=" + apartmentId + ", apartmentNumber=" + apartmentNumber + ", occupancy="
				+ occupancy + ", capacity=" + capacity + ", residents=" + residents + ", complex=" + complex + "]";
	}

	

}
