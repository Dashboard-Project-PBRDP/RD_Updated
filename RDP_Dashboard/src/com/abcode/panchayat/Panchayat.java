package com.abcode.panchayat;

public class Panchayat {

	private int id;
	private String panchayatName;
	private int block_id;
	private int constituency_id;
	private String constituency_name;
	public Panchayat(int id, String panchayatName, int block_id, int constituency_id) {
		super();
		this.id = id;
		this.panchayatName = panchayatName;
		this.block_id = block_id;
		this.constituency_id = constituency_id;
	}
	public Panchayat(int id, String panchayatName) {
		super();
		this.id = id;
		this.panchayatName = panchayatName;
	}
	
	public Panchayat(int block_id, int constituency_id, String constituency_name) {
		super();
		this.block_id = block_id;
		this.constituency_id = constituency_id;
		this.setConstituency_name(constituency_name);
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPanchayatName() {
		return panchayatName;
	}
	public void setPanchayatName(String panchayatName) {
		this.panchayatName = panchayatName;
	}
	public int getBlock_id() {
		return block_id;
	}
	public void setBlock_id(int block_id) {
		this.block_id = block_id;
	}
	public int getConstituency_id() {
		return constituency_id;
	}
	public void setConstituency_id(int constituency_id) {
		this.constituency_id = constituency_id;
	}
	public String getConstituency_name() {
		return constituency_name;
	}
	public void setConstituency_name(String constituency_name) {
		this.constituency_name = constituency_name;
	}
	@Override
	public String toString() {
		return "Panchayat [id=" + id + ", panchayatName=" + panchayatName + ", block_id=" + block_id
				+ ", constituency_id=" + constituency_id + "]";
	}
	
	
}
