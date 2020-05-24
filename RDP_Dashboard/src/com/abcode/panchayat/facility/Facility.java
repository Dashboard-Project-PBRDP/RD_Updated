package com.abcode.panchayat.facility;

import java.util.Date;

public class Facility {
	private int id;
	private int panchayat_id;
	private String facilityName;
	private String facilityType;
	private String area;
	private String location;
	private String facilityLevel;
	private String identifier;
	private String facilityCondition;
	private String lastRepaired;
	private String facilityNumber;
	
	
	
	public Facility(int id,int panchayat_id,String facilityType,String facilityName,String facilityLevel,String area,String location,String identifier,String facilityCondition,String lastRepaired,String facilityNumber) {
		super();
		this.id=id;
		this.panchayat_id=panchayat_id;
		this.facilityType=facilityType;
		this.facilityName=facilityName;
		this.facilityLevel=facilityLevel;
		this.area=area;
		this.location=location;
		this.identifier=identifier;
		this.facilityCondition=facilityCondition;
		this.lastRepaired=lastRepaired;
		this.facilityNumber=facilityNumber;

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
	public String getfacilityName() {
		return facilityName;
	}
	public void setfacilityName(String facilityName) {
		this.facilityName = facilityName;
	}
	public String getfacilityType() {
		return facilityType;
	}
	public void setfacilityType(String facilityType) {
		this.facilityType = facilityType;
	}
	public String getfacilityLevel() {
		return facilityLevel;
	}
	public void setfacilityLevel(String facilityLevel) {
		this.facilityLevel = facilityLevel;
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
	public String getfacilityCondition() {
		return facilityCondition;
	}
	public void setfacilityCondition(String facilityCondition) {
		this.facilityCondition = facilityCondition;
	}
	public String getlastRepaired() {
		return lastRepaired;
	}
	public void setlastRepaired(String lastRepaired) {
		this.lastRepaired = lastRepaired;
	}
	public String getfacilityNumber() {
		return facilityNumber;
	}
	public void setfacilityNumber(String facilityNumber) {
		this.facilityNumber = facilityNumber;
	}
	@Override
	public String toString() {
		return "Facility [id=" + id + ", panchayat_id=" + panchayat_id + ", facilityType=" + facilityType + ", facilityName=" + facilityName + ", facilityLevel=" + facilityLevel + ", area=" + area + ", location=" + location + ", identifier=" + identifier + ", facilityCondition=" + facilityCondition + ", lastRepaired=" + lastRepaired + ", facilityNumber=" + facilityNumber + "]";
	}
}
