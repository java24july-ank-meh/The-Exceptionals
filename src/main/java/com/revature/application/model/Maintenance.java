package com.revature.application.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name="MAINTENANCE")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "maintenanceId")
public class Maintenance
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int maintenanceId;
	private String type;
	private String location;
	private String description;
	private Date submitDate;
	private boolean isResolved;
	

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "APARTMENT_ID")
	@JsonIdentityInfo(scope=Apartment.class, generator = ObjectIdGenerators.PropertyGenerator.class, property = "apartmentId")
	@JsonIdentityReference(alwaysAsId = true)
	private Apartment apartment;

	
	public Maintenance() {};

	public Maintenance(int maintenanceId, String type, String location, String description, Date submitDate,
			boolean isResolved, Apartment apartment)
	{
		super();
		this.maintenanceId = maintenanceId;
		this.type = type;
		this.location = location;
		this.description = description;
		this.submitDate = submitDate;
		this.isResolved = isResolved;
		this.apartment = apartment;
	}


	public int getMaintenanceId()
	{
		return maintenanceId;
	}


	public void setMaintenanceId(int maintenanceId)
	{
		this.maintenanceId = maintenanceId;
	}


	public String getType()
	{
		return type;
	}


	public void setType(String type)
	{
		this.type = type;
	}


	public String getLocation()
	{
		return location;
	}


	public void setLocation(String location)
	{
		this.location = location;
	}


	public String getDescription()
	{
		return description;
	}


	public void setDescription(String description)
	{
		this.description = description;
	}


	public Date getSubmitDate()
	{
		return this.submitDate;
	}


	public void setSubmitDate(Date submitDate)
	{
		this.submitDate = submitDate;
	}


	public boolean isResolved()
	{
		return this.isResolved;
	}


	public void setResolved(boolean isResolved)
	{
		this.isResolved = isResolved;
	}


	public Apartment getApartment()
	{
		return apartment;
	}


	public void setApartment(Apartment apartment)
	{
		this.apartment = apartment;
	}

	@Override
	public String toString()
	{
		return "Maintenance [maintenanceId=" + maintenanceId + ", type=" + type + ", location=" + location
				+ ", description=" + description + ", date=" + submitDate + ", isResolved=" + isResolved + ", apartment="
				+ apartment + "]";
	}
	
	
	
}
