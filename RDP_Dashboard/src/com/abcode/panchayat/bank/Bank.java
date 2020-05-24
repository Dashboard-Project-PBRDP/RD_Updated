package com.abcode.panchayat.bank;

import java.util.Date;

public class Bank {
	private int id;
	private int panchayat_id;
	private String bankName;
	private String branch;
	private String ifscCode;
	private String accountNumber;
	private String purpose;
	private String currentBalance;
	private String date;
	private String activeAccount;
	private String openingYear;
	private String closingYear;
	
	
	
	public Bank(int id,int panchayat_id,String bankName,String branch,String ifscCode,String accountNumber,String purpose,String currentBalance,String date,String activeAccount,String openingYear,String closingYear) {
		super();
		this.id=id;
		this.panchayat_id=panchayat_id;
		this.bankName=bankName;
		this.branch=branch;
		this.ifscCode=ifscCode;
		this.accountNumber=accountNumber;
		this.purpose=purpose;
		this.currentBalance=currentBalance;
		this.date=date;
		this.activeAccount=activeAccount;
		this.openingYear=openingYear;
		this.closingYear=closingYear;
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
	public String getbankName() {
		return bankName;
	}
	public void setbankName(String bankName) {
		this.bankName = bankName;
	}
	public String getbranch() {
		return branch;
	}
	public void setbranch(String branch) {
		this.branch = branch;
	}
	public String getifscCode() {
		return ifscCode;
	}
	public void setifscCode(String ifscCode) {
		this.ifscCode = ifscCode;
	}
	public String getaccountNumber() {
		return accountNumber;
	}
	public void setaccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getpurpose() {
		return purpose;
	}
	public void setpurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getcurrentBalance() {
		return currentBalance;
	}
	public void setcurrentBalance(String currentBalance) {
		this.currentBalance = currentBalance;
	}
	public String getdate() {
		return date;
	}
	public void setdate(String date) {
		this.date = date;
	}
	public String getactiveAccount() {
		return activeAccount;
	}
	public void setactiveAccount(String activeAccount) {
		this.activeAccount = activeAccount;
	}
	public String getopeningYear() {
		return openingYear;
	}
	public void setopeningYear(String openingYear) {
		this.openingYear = openingYear;
	}
	public String getclosingYear() {
		return closingYear;
	}
	public void setclosingYear(String closingYear) {
		this.closingYear = closingYear;
	}
	@Override
	public String toString() {
		return "Bank [id=" + id + ", panchayat_id=" + panchayat_id + ", bankName=" + bankName + ", branch=" + branch + ", ifscCode=" + ifscCode + ", accountNumber=" + accountNumber + ", purpose=" + purpose + ", currentBalance=" + currentBalance + ", date=" + date + ""
				+ ", activeAccount=" + activeAccount + ", openingYear=" + openingYear + ", closingYear=" + closingYear + "]";
	}
}
