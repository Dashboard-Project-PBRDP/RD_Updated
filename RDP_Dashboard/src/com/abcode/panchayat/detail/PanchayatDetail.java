package com.abcode.panchayat.detail;

public class PanchayatDetail {
private int pId;
private int pDetailId;
private String pDetail;
private String panchayatName;

public PanchayatDetail(int pId,String panchayatName, int pDetailId, String pDetail) {
	super();
	this.pId = pId;
	this.panchayatName=panchayatName;
	this.pDetailId = pDetailId;
	this.pDetail = pDetail;
}
public int getpId() {
	return pId;
}
public void setpId(int pId) {
	this.pId = pId;
}
public String getpanchayatName() {
	return panchayatName;
}
public void setpanchayatName(String panchayatName) {
	this.panchayatName = panchayatName;
}
public int getpDetailId() {
	return pDetailId;
}
public void setpDetailId(int pDetailId) {
	this.pDetailId = pDetailId;
}
public String getpDetail() {
	return pDetail;
}
public void setpDetail(String pDetail) {
	this.pDetail = pDetail;
}
@Override
public String toString() {
	return "PanchayatDetail [pId=" + pId + ", pDetailId=" + pDetailId + ", pDetail=" + pDetail + "]";
}


}
