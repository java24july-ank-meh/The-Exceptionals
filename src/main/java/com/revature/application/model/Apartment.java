package com.revature.application.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Apartment {
	@Id
	private Integer aptnumber;
	private int occupancy;
	private int capacity;
	private int complexId;

	public Apartment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Apartment(Integer aptnumber, int occupancy, int capacity, int complexId) {
		super();
		this.aptnumber = aptnumber;
		this.occupancy = occupancy;
		this.capacity = capacity;
		this.complexId = complexId;
	}

	public Integer getAptnumber() {
		return aptnumber;
	}

	public void setAptnumber(Integer aptnumber) {
		this.aptnumber = aptnumber;
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
		return "Apartment [aptnumber=" + aptnumber + ", occupancy=" + occupancy + ", capacity=" + capacity + ", complexId="
				+ complexId + "]";
	}

}
