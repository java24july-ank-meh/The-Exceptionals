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

@Entity
@Table(name="APARTMENT")
public class Apartment {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer apartmentId;
	private int apartmentNumber;
	private int occupancy;
	private int capacity;
	private int complexId;
	
	@OneToMany(mappedBy="apartment", cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	private Set<Resident> residents;

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
		return apartmentId;
	}

	public void setApartmentId(Integer apartmentId) {
		this.apartmentId = apartmentId;
	}

	public int getApartmentNumber() {
		return apartmentNumber;
	}

	public void setApartmentNumber(int apartmentNumber) {
		this.apartmentNumber = apartmentNumber;
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

	public Set<Resident> getResidents() {
		return residents;
	}

	public void setResidents(Set<Resident> residents) {
		this.residents = residents;
	}

	@Override
	public String toString() {
		return "Apartment [apartmentId=" + apartmentId + ", apartmentNumber=" + apartmentNumber + ", occupancy="
				+ occupancy + ", capacity=" + capacity + ", complexId=" + complexId + ", residents=" + residents + "]";
	}

	

}
