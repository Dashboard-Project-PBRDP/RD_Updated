package com.abcode.panchayat.income;

public class Income {
	private int id;
	private int panchayat_id;
	private int sourceId;
	private String year;
	private String month;
	private String openingBalance;
	private String incomeType;
	private String incomeSource;
	private String amount;
	private String purpose;
	private String bankAccount;
	private String sanctionno;
	private String sanctiondate;
	private String ucStatus;
	
	public Income(int id,int panchayat_id,String year,String month,String openingBalance,String incomeType,String incomeSource,String amount,String purpose,String bankAccount,String sanctionno,String sanctiondate,String ucStatus) {
		super();
		this.id = id;
		this.panchayat_id = panchayat_id;
		this.year=year;
		this.month=month;
		this.openingBalance=openingBalance;
		this.incomeType=incomeType;
		this.incomeSource=incomeSource;
		this.amount=amount;
		this.purpose=purpose;
		this.bankAccount=bankAccount;
		this.sanctionno=sanctionno;
		this.sanctiondate=sanctiondate;
		this.ucStatus=ucStatus;
	}
	public Income(int id,String year,String month,String openingBalance,String incomeType,String incomeSource,String amount,String purpose,String bankAccount,String sanctionno,String sanctiondate,String ucStatus) {
		super();
		this.id = id;
		this.year=year;
		this.month=month;
		this.openingBalance=openingBalance;
		this.incomeType=incomeType;
		this.incomeSource=incomeSource;
		this.amount=amount;
		this.purpose=purpose;
		this.bankAccount=bankAccount;
		this.sanctionno=sanctionno;
		this.sanctiondate=sanctiondate;
		this.ucStatus=ucStatus;
	}
	
	public Income(int scheme_id,String source_of_income) {
		super();
		this.setincomeSource(source_of_income);
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
	public String getyear() {
		return year;
	}
	public void setyear(String year) {
		this.year = year;
	}
	public String getmonth() {
		return month;
	}
	public void setmonth(String month) {
		this.month = month;
	}
	public String getopeningBalance() {
		return openingBalance;
	}
	public void setopeningBalance(String openingBalance) {
		this.openingBalance = openingBalance;
	}
	public String getincomeType() {
		return incomeType;
	}
	public void setincomeType(String incomeType) {
		this.incomeType = incomeType;
	}
	public int getschemeId() {
		return sourceId;
	}
	public void setschemeId(int sourceId) {
		this.sourceId = sourceId;
	}
	public String getincomeSource() {
		return incomeSource;
	}
	public void setincomeSource(String incomeSource) {
		this.incomeSource = incomeSource;
	}
	public String getamount() {
		return amount;
	}
	public void setamount(String amount) {
		this.amount = amount;
	}
	public String getpurpose() {
		return purpose;
	}
	public void setpurpose(String purpose) {
		this.purpose = purpose;
	}
	public String getbankAccount() {
		return bankAccount;
	}
	public void setbankAccount(String bankAccount) {
		this.bankAccount = bankAccount;
	}
	public String getsanctionno() {
		return sanctionno;
	}
	public void setsanctionno(String sanctionno) {
		this.sanctionno=sanctionno;
	}
	public String getsanctiondate() {
		return sanctiondate;
	}
	public void setsanctiondate(String sanctiondate) {
		this.sanctiondate=sanctiondate;
	}
	public String getucStatus() {
		return ucStatus;
	}
	public void setucStatus(String ucStatus) {
		this.ucStatus = ucStatus;
	}

	@Override
	public String toString() {
		return "Income [id=" + id + ", panchayat_id=" + panchayat_id + ", year="+year+",month="+month+",openingBalance="+openingBalance+",incomeType="+incomeType+",incomeSource="+incomeSource+",amount="+amount+",purpose="+purpose+",bankAccount="+bankAccount+",sanctionno="+sanctionno+",sanctiondate="+sanctiondate+",ucStatus="+ucStatus+"]";
	}
}
