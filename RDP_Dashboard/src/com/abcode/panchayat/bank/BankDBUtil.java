package com.abcode.panchayat.bank;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.sql.DataSource;

import com.abcode.panchayat.Panchayat;
import com.abcode.panchayat.panch.Panch;

public class BankDBUtil {
private static DataSource dataSource;
	
	public BankDBUtil (DataSource theDataSource) {
		dataSource = theDataSource;
		
	}

	
	public static List<Bank> getBankList(int panchayat_id) throws Exception{
		
		
		
		List<Bank> BankList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// get a Connection
			conn = dataSource.getConnection();
			
			//create sql query
			String sql = "select * from bank_details where fk_bank_panchayat="+panchayat_id;
			stmt = conn.createStatement();
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			while (rs.next()) {
				// retrive data from resultset
					int id = rs.getInt("bank_id");
					String bankName = rs.getString("bankName");	
					String branch = rs.getString("branch");	
					String ifscCode = rs.getString("ifscCode");	
					String accountNumber = rs.getString("accountNumber");	
					String purpose = rs.getString("purpose");	
					String currentBalance = rs.getString("currentBalance");	
					String date = rs.getString("date");	
					String activeAccount=rs.getString("activeAccount");
					String openingYear=rs.getString("openingYear");
					String closingYear = rs.getString("closingYear");	
					

				// create new Bank object
				Bank tempBank = new Bank(id,panchayat_id,bankName,branch,ifscCode,accountNumber,purpose,currentBalance,date,activeAccount,openingYear,closingYear);
				// add it to list of 
				BankList.add(tempBank);
			}
			
		return BankList;
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

	public Bank getBank(int theBankId,int panchayat_id) throws Exception {
		
		Bank tempBank = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int Bank_id = 0;
		try {
			Bank_id = theBankId;
			
			// get a Connection
			conn = dataSource.getConnection();
			
			//create sql query
			String sql = "select * from bank_details where bank_id="+ Bank_id;
			stmt = conn.createStatement();
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			if (rs.next()) {
				// retrive data from resultset
				
				int id = rs.getInt("bank_id");
				String bankName = rs.getString("bankName");	
				String branch = rs.getString("branch");	
				String ifscCode = rs.getString("ifscCode");	
				String accountNumber = rs.getString("accountNumber");	
				String purpose = rs.getString("purpose");	
				String currentBalance = rs.getString("currentBalance");	
				String date = rs.getString("date");	
				String activeAccount=rs.getString("activeAccount");
				String openingYear=rs.getString("openingYear");
				String closingYear = rs.getString("closingYear");
				
					
				// create new  object
				tempBank = new Bank(id,panchayat_id,bankName,branch,ifscCode,accountNumber,purpose,currentBalance,date,activeAccount,openingYear,closingYear);
				
			}
			else {
				throw new Exception ("Couldn't find Bank id:"+Bank_id);
			}
		return tempBank;
		}
		finally {
			//close jdbc objects
			close(conn,stmt,rs);
		}
	}

	public void updateBank(Bank theBank,int panchayat_id) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		//Get current date
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update bank_details "
					+ "set bankName=?,branch=?,ifscCode=?,accountNumber=?,purpose=?,currentBalance=?,date=?,activeAccount=?,openingYear=?,closingYear=?,fk_bank_panchayat=? "
						+ "where bank_id=?";
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set parameters
			myStmt.setString(1, theBank.getbankName());
			myStmt.setString(2, theBank.getbranch());
			myStmt.setString(3,theBank.getifscCode());
			myStmt.setString(4,theBank.getaccountNumber());
			myStmt.setString(5,theBank.getpurpose());
			myStmt.setString(6,theBank.getcurrentBalance());
			myStmt.setString(7,theBank.getdate());
			myStmt.setString(8,theBank.getactiveAccount());
			myStmt.setString(9,theBank.getopeningYear());
			myStmt.setString(10,theBank.getclosingYear());
			myStmt.setInt(11,panchayat_id);
			myStmt.setInt(12,theBank.getId());


			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
	}
	public void deleteBank(String theBankId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//convert Bank id to int
			int Bank_id = Integer.parseInt(theBankId);
			
			// get db connection
			conn = dataSource.getConnection();
	
			// create sql for delete
			String sql = "delete from bank_details where bank_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Bank_id);
			// execute sql insert
			pstmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(conn, pstmt, null);
		}
		
	}
	
	public void addBank(String bankName,String branch,String ifscCode,String accountNumber,String purpose,String currentBalance,String date,String activeAccount,String openingYear,String closingYear,int panchayat_id) throws SQLException{

		Connection conn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			conn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into bank_details "
					   + "(bankName,branch,ifscCode,accountNumber,purpose,currentBalance,date,activeAccount,openingYear,closingYear,fk_bank_panchayat) "
					   + "values (?,?,?,?,?,?,?,?,?,?,?)";
			
			myStmt = conn.prepareStatement(sql);
			myStmt.setString(1,bankName);
			myStmt.setString(2,branch);
			myStmt.setString(3,ifscCode);
			myStmt.setString(4,accountNumber);
			myStmt.setString(5,purpose);
			myStmt.setString(6,currentBalance);
			myStmt.setString(7,date);
			myStmt.setString(8,activeAccount);
			myStmt.setString(9,openingYear);
			myStmt.setString(10,closingYear);
			myStmt.setInt(11,panchayat_id);
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(conn, myStmt, null);
		}
		
	}
}
