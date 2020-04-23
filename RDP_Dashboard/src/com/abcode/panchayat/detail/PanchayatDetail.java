package com.abcode.panchayat.detail;

public class PanchayatDetail {
private int pId;
private int pDetailId;
private String pDetail;
public PanchayatDetail(int pId, int pDetailId, String pDetail) {
	super();
	this.pId = pId;
	this.pDetailId = pDetailId;
	this.pDetail = pDetail;
}
public int getpId() {
	return pId;
}
public void setpId(int pId) {
	this.pId = pId;
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
