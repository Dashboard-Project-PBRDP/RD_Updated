package com.abcode.panchayat.property;

import java.util.Date;

public class Property {
	private int id;
	private int panchayat_id;
	private String propertyType;
	private String propertyName;
	private String area;
	private String location;
	private String identifier;
	private String purpose;
	private String leasedOut;
	private String leasedFrom;
	private String leasedTo;
	private String leaseAmount;
	private String leaseAmountpyear;
	
	
	
	public Property(int id,int panchayat_id,String propertyType,String propertyName,String area,String location,String identifier,String purpose,String leasedOut,
			String leasedFrom,String leasedTo,String leaseAmount,String leaseAmountpyear ) {
		super();
		this.id=id;
		this.panchayat_id=panchayat_id;
		this.propertyType=propertyType;
		this.propertyName=propertyName;
		this.area=area;
		this.location=location;
		this.identifier=identifier;
		this.purpose=purpose;
		this.leasedOut=leasedOut;
		this.leasedFrom=leasedFrom;
		this.leasedTo=leasedTo;
		this.leaseAmount=leaseAmount;
		this.leaseAmountpyear=leaseAmountpyear;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPanchayat_id() {
		return panchayat_id;
	}
	public void setPanchayat_id(int panchayat_id) {
		this.panchayat_id = panchayat_id;
	}
	public String getpropertyType() {
		return propertyType;
	}
	public void setpropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
	public String getpropertyName() {
		return propertyName;
	}
	public void setpropertyName(String propertyName) {
		this.propertyName = propertyName;
	}
	public String getarea() {
		return area;
	}
	public void setarea(String area) {
		this.area = area;
	}
	public String getlocation() {
		return location;
	}
	public void setlocation(String location) {
		this.location = location;
	}
	public String getidentifier() {
		return identifier;
	}
	public void setidentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getpurpose() {
		return purpose;
	}
	public void setpurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getleasedOut() {
		return leasedOut;
	}
	public void setleasedOut(String leasedOut) {
		this.leasedOut = leasedOut;
	}
	public String getleasedFrom() {
		return leasedFrom;
	}
	public void setleasedFrom(String leasedFrom) {
		this.leasedFrom = leasedFrom;
	}
	public String getleasedTo() {
		return leasedTo;
	}
	public void setleasedTo(String leasedTo) {
		this.leasedTo = leasedTo;
	}
	public String getleaseAmount() {
		return leaseAmount;
	}
	public void setleaseAmount(String leaseAmount) {
		this.leaseAmount = leaseAmount;
	}
	public String getleaseAmountpyear() {
		return leaseAmountpyear;
	}
	public void setleaseAmountpyear(String leaseAmountpyear) {
		this.leaseAmountpyear = leaseAmountpyear;
	}
	@Override
	public String toString() {
		return "Property [id=" + id + ", panchayat_id=" + panchayat_id + ", propertyType=" + propertyType + ", propertyName=" + propertyName + ", area=" + area + ", location=" + location + ", identifier=" + identifier + ", purpose=" + purpose + ", leasedOut=" + leasedOut + ""
				+ ", leasedFrom=" + leasedFrom + ", leasedTo=" + leasedTo + ", leaseAmount=" + leaseAmount + ", leaseAmountpyear=" + leaseAmountpyear + "]";
	}
}
