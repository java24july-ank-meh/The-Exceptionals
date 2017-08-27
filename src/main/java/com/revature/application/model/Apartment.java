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
import com.fasterxml.jackson.annotation.JsonManagedReference;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@Table(name = "APARTMENT")
public class Apartment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer apartmentId;
	private int apartmentNumber;
	private int occupancy;
	private int capacity;

	@OneToMany(mappedBy = "apartment", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private Set<Resident> residents;

	@Transient
	private int complexId;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "COMPLEX_ID")
	@JsonBackReference
	private ApartmentComplex complex;

	public Apartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartment(Integer apartmentId, int apartmentNumber, int occupancy, int capacity, Set<Resident> residents,
			ApartmentComplex complex) {
		super();
		this.apartmentId = apartmentId;
		this.apartmentNumber = apartmentNumber;
		this.occupancy = occupancy;
		this.capacity = capacity;
		this.residents = residents;
		this.complex = complex;
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

	public int getComplexId() {
		return complexId;
	}

	public ApartmentComplex getComplex() {
		return this.complex;
	}

	public void setComplex(ApartmentComplex complex) {
		this.complex = complex;
		this.complexId = complex.getComplexId();
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
				+ occupancy + ", capacity=" + capacity + ", residents=" + residents + ", complexId=" + complexId + "]";
	}

}
