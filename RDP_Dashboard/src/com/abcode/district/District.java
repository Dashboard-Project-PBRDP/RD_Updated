package com.abcode.district;

public class District {
	private int id;
	private String districtName;
	
	public District(int id, String districtName) {
		super();
		this.id = id;
		this.districtName = districtName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDistrictName() {
		return districtName;
	}

	public void setDistrictName(String districtName) {
		this.districtName = districtName;
	}

	@Override
	public String toString() {
		return "District [id=" + id + ", districtName=" + districtName + "]";
	}
	
	
	
}
