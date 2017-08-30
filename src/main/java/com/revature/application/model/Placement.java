package com.revature.application.model;

import java.sql.Date;

//Create a bean for this by adding a front end.
public class Placement {
	
	private long placementId;
	private long residentId;
	private long apartmentId;
	private long complexId;
	private Date date;
	
	
	public long getPlacementId() {
		return placementId;
	}
	public void setPlacement_id(long placementId) {
		this.placementId = placementId;
	}
	public long getResidentId() {
		return residentId;
	}
	public void setResidentId(long residentId) {
		this.residentId = residentId;
	}
	public long getApartmentId() {
		return apartmentId;
	}
	public void setApartmentId(long apartmentId) {
		this.apartmentId = apartmentId;
	}
	public long getComplexId() {
		return complexId;
	}
	public void setComplexId(long complexId) {
		this.complexId = complexId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return "Placement [placementId=" + placementId + ", residentId=" + residentId + ", apartmentId=" + apartmentId
				+ ", complexId=" + complexId + ", date=" + date + "]";
	}
	
	

}
