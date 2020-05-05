package com.abcode.panchayat.income;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.abcode.panchayat.Panchayat;
import com.abcode.panchayat.panch.Panch;

public class IncomeDBUtil {
private static DataSource dataSource;
	
	public IncomeDBUtil (DataSource theDataSource) {
		dataSource = theDataSource;
		
	}
	public static List<Income> getIncomeList(int panchayat_id) throws Exception{
		
		
		
		List<Income> IncomeList = new ArrayList<>();
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// get a Connection
			conn = dataSource.getConnection();
			
			//create sql query
			String sql = "select * from income_details where fk_income_panchayat="+panchayat_id;
			stmt = conn.createStatement();
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			while (rs.next()) {
				// retrive data from resultset
					int id = rs.getInt("income_id");
					String year = rs.getString("year");
					String month = rs.getString("month");
					String openingBalance = rs.getString("opening_balance");
					String incomeType = rs.getString("income_type");
					String incomeSource = rs.getString("income_source");
					String amount = rs.getString("amount");
					String purpose = rs.getString("purpose");
					String bankAccount = rs.getString("bank_account");
					String sanctionno = rs.getString("sanction_letter_no");
					String sanctiondate = rs.getString("sanction_letter_date");
					String ucStatus = rs.getString("uc_status");

				// create new income object
				Income tempIncome = new Income(id,panchayat_id,year,month,openingBalance,incomeType,incomeSource,amount,purpose,bankAccount,sanctionno,sanctiondate,ucStatus);
				// add it to list of income
				IncomeList.add(tempIncome);
			}
			
		return IncomeList;
		}
		finally {
			//close jdbc objects
			close(conn,stmt,rs);
		}
		
		}
	private static void close (Connection conn, Statement stmt, ResultSet rs) {
	try {
		if(rs!= null) {
			rs.close();
		}
		if(rs!= null) {
			stmt.close();
		}
		if(rs!= null) {
			conn.close();
		}
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	}
	
	public static void addIncome(String year,String month,String openingBalance,String incomeType,int incomeSource,String amount,String purpose,String bankAccount,String sanctionno,String sanctiondate,String ucStatus,int panchayat_id) 
			throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// get db connection
			conn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into income_details "
					   + "(year,month,opening_balance,income_type,income_source,amount,purpose,bank_account,sanction_letter_no,sanction_letter_date,uc_status, fk_income_panchayat) "
					   + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, year);
			pstmt.setString(2, month);
			pstmt.setString(3, openingBalance);
			pstmt.setString(4, incomeType);
			pstmt.setInt(5, incomeSource);
			pstmt.setString(6, amount);
			pstmt.setString(7, purpose);
			pstmt.setString(8, bankAccount);
			pstmt.setString(9, sanctionno);
			pstmt.setString(10, sanctiondate);
			pstmt.setString(11, ucStatus);
			pstmt.setInt(12, panchayat_id);
			// execute sql insert
			pstmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(conn, pstmt, null);
		}
		
	}

	public Income getIncome(int theIncomeId,int panchayat_id) throws Exception {
		
		Income tempIncome = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int income_id = 0;
		try {
			income_id = theIncomeId;
			
			// get a Connection
			conn = dataSource.getConnection();
			
			//create sql query
			String sql = "select * from income_details where income_id="+ income_id;
			stmt = conn.createStatement();
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			if (rs.next()) {
				// retrive data from resultset
					int id = rs.getInt("income_id");
				//	int fk_income=rs.getInt("fk_income_panchayat");
					String year = rs.getString("year");
					String month = rs.getString("month");
					String opening_balance = rs.getString("opening_balance");
					String income_type = rs.getString("income_type");
					String income_source = rs.getString("income_source");
					String amount = rs.getString("amount");
					String purpose = rs.getString("purpose");
					String bank_account = rs.getString("bank_account");
					String sanctionno = rs.getString("sanction_letter_no");
					String sanctiondate = rs.getString("sanction_letter_date");
					String uc_status = rs.getString("uc_status");
				
					
				// create new income object
				tempIncome = new Income(income_id,year,month,opening_balance,income_type,income_source,amount,purpose,bank_account,sanctionno,sanctiondate,uc_status);
				
			}
			else {
				throw new Exception ("Couldn't find income id:"+income_id);
			}
		return tempIncome;
		}
		finally {
			//close jdbc objects
			close(conn,stmt,rs);
		}
	}

	public void updateIncome(Income theIncome,int panchayat_id) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update income_details "
					+ "set year=?,month=?,opening_balance=?,income_type=?,income_source=?,amount=?,purpose=?,bank_account=?,sanction_letter_no=?,sanction_letter_date=?,uc_status=? "
						+ "where income_id=?";
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set parameters
			myStmt.setString(1, theIncome.getyear());
			myStmt.setString(2, theIncome.getmonth());
			myStmt.setString(3, theIncome.getopeningBalance());
			myStmt.setString(4, theIncome.getincomeType());
			myStmt.setString(5, theIncome.getincomeSource());
			myStmt.setString(6, theIncome.getamount());
			myStmt.setString(7, theIncome.getpurpose());
			myStmt.setString(8, theIncome.getbankAccount());
			myStmt.setString(9, theIncome.getsanctionno());
			myStmt.setString(10, theIncome.getsanctiondate());
			myStmt.setString(11, theIncome.getucStatus());
			myStmt.setInt(12, theIncome.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
	}
	public void deleteIncome(String theIncomeId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//convert income id to int
			int income_id = Integer.parseInt(theIncomeId);
			
			// get db connection
			conn = dataSource.getConnection();
	
			// create sql for delete
			String sql = "delete from income_details where income_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, income_id);
			// execute sql insert
			pstmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(conn, pstmt, null);
		}
		
	}
	public List<Income> getIncomeSource() throws Exception {
		
		List<Income> sourceList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			
			// get a Connection
			conn = dataSource.getConnection();
			String sql="select * from grant_source";
			stmt = conn.createStatement();
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			while (rs.next()) {
				// retrive data from resultset
				String source_of_income = rs.getString("title_of_scheme");
				int scheme_id = rs.getInt("scheme_id");	
				// create new panchayat object
				Income tempIncome = new Income(scheme_id,source_of_income);
				
				// add it to list of panchayats
				sourceList.add(tempIncome);
			}
			
		return sourceList;
		}
		finally {
			//close jdbc objects
			close(conn,stmt,rs);
		}
		
	}
}
