package com.abcode.panchayat.panch;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class SarpanchDbUtil {

private static DataSource dataSource;
	
	public SarpanchDbUtil (DataSource theDataSource) {
		dataSource = theDataSource;
		
	}

	public static List<Panch> getPanchList(int panchayat_id) throws Exception{
		
	
	
	List<Panch> panchList = new ArrayList<>();
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		// get a Connection
		conn = dataSource.getConnection();
		
		//create sql query
		String sql = "select * from panch_details where fk_panch_panchayat="+panchayat_id;
		stmt = conn.createStatement();
		
		//execute query
		rs = stmt.executeQuery(sql);
		
		//process result set
		while (rs.next()) {
			// retrive data from resultset
				int id = rs.getInt("panch_id");
				String firstName = rs.getString("first_name");
				String middleName = rs.getString("middle_name");
				String lastName = rs.getString("last_name");
				String designation = rs.getString("designation");
				int age = rs.getInt("age");
				String gender = rs.getString("gender");
				String category = rs.getString("category");
				String profession = rs.getString("profession");
				long contact = rs.getLong("contact");

			// create new panch object
			Panch tempPanch = new Panch(id, firstName, middleName, lastName,designation,age,gender,category,profession,contact,panchayat_id);
			
			// add it to list of panchs
			panchList.add(tempPanch);
		}
		
	return panchList;
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

	public static void addPanch(String firstName, String middleName, String lastName, String designation, 
			int age, String gender, String category, String profession, long contact, int panchayat_id) 
			throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// get db connection
			conn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into panch_details "
					   + "(first_name, middle_name,last_name, designation, age, gender, category, profession, contact, fk_panch_panchayat) "
					   + "values (?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, firstName);
			pstmt.setString(2, middleName);
			pstmt.setString(3, lastName);
			pstmt.setString(4, designation);
			pstmt.setInt(5, age);
			pstmt.setString(6, gender);
			pstmt.setString(7, category);
			pstmt.setString(8, profession);
			pstmt.setLong(9, contact);
			pstmt.setInt(10, panchayat_id);
			// execute sql insert
			pstmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(conn, pstmt, null);
		}
		
	}

	

	public void deletePanch(String thePanchId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//convert panch id to int
			int panch_id = Integer.parseInt(thePanchId);
			
			// get db connection
			conn = dataSource.getConnection();
	
			// create sql for delete
			String sql = "delete from panch_details where panch_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, panch_id);
			// execute sql insert
			pstmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(conn, pstmt, null);
		}
		
	}

	public Panch getPanch(int thePanchId,int panchayat_id) throws Exception {
		
		Panch tempPanch = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int panch_id = 0;
		try {
			panch_id = thePanchId;
			
			// get a Connection
			conn = dataSource.getConnection();
			
			//create sql query
			String sql = "select * from panch_details where panch_id="+ panch_id;
			stmt = conn.createStatement();
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			if (rs.next()) {
				// retrive data from resultset
					int id = rs.getInt("panch_id");
					int fk_panch=rs.getInt("fk_panch_panchayat");
					String firstName = rs.getString("first_name");
					String middleName = rs.getString("middle_name");
					String lastName = rs.getString("last_name");
					String designation = rs.getString("designation");
					int age = rs.getInt("age");
					String gender = rs.getString("gender");
					String category = rs.getString("category");
					String profession = rs.getString("profession");
					long contact = rs.getLong("contact");
					
					
				// create new panch object
				tempPanch = new Panch(panch_id,firstName, middleName,lastName, designation, age, gender, category, profession, contact,fk_panch);
				
			}
			else {
				throw new Exception ("Couldn't find panch id:"+panch_id);
			}
		return tempPanch;
		}
		finally {
			//close jdbc objects
			close(conn,stmt,rs);
		}
	}

	public void updatePanch(Panch thePanch,int panchayat_id) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update panch_details "
					+ "set first_name=?,middle_name=?,last_name=?,designation=?,age=?,gender=?,category=?,profession=?,contact=? "
						+ "where panch_id=?";
			/*String sql = "update panch_details "
					+ "set first_name='ish2',middle_name='mid2',last_name='Last2' "
					+  "where panch_id=?";*/
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, thePanch.getFirstName());
			myStmt.setString(2, thePanch.getMiddleName());
			myStmt.setString(3, thePanch.getLastName());
			myStmt.setString(4, thePanch.getDesignation());
			myStmt.setInt(5, thePanch.getAge());
			myStmt.setString(6, thePanch.getGender());
			myStmt.setString(7, thePanch.getCategory());
			myStmt.setString(8, thePanch.getProfession());
			myStmt.setLong(9, thePanch.getContact());
			myStmt.setInt(10, thePanch.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
	}
}
