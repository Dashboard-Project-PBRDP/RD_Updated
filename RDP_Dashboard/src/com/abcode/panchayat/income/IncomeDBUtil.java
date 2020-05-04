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
					int incomeSource = rs.getInt("income_source");
					String amount = rs.getString("amount");
					String purpose = rs.getString("purpose");
					String bankAccount = rs.getString("bank_account");
					String sanction_letter_no = rs.getString("sanction_letter_no");
					String sanction_letter_date = rs.getString("sanction_letter_date");
					String ucStatus = rs.getString("uc_status");

				// create new panch object
				Income tempIncome = new Income(id,panchayat_id,year,month,openingBalance,incomeType,incomeSource,amount,purpose,bankAccount,sanction_letter_no,sanction_letter_date,ucStatus);
				
				// add it to list of panchs
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
	
	public static void addIncome(String year,String month,String openingBalance,String incomeType,int incomeSource,String amount,String purpose,String bankAccount,String sanction_letter_no,String sanction_letter_date,String ucStatus,int panchayat_id) 
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
			pstmt.setString(9, sanction_letter_no);
			pstmt.setString(10, sanction_letter_date);
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

	

	public void deleteIncome(String theIncomeId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//convert panch id to int
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
