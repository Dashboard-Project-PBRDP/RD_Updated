package com.abcode.panchayat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class PanchayatDbUtil {

private DataSource dataSource;
	
	public PanchayatDbUtil (DataSource theDataSource) {
		dataSource = theDataSource;
		
	}

	public List<Panchayat> getPanchayatList(int block_id) throws Exception{
		
	
	
	List<Panchayat> panchayatList = new ArrayList<>();
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		// get a Connection
		conn = dataSource.getConnection();
		
		//create sql query
		String sql = "select * from panchayat where fk_panchayat_block="+block_id+" order by panchayat_name";
		stmt = conn.createStatement();
		
		//execute query
		rs = stmt.executeQuery(sql);
		
		//process result set
		while (rs.next()) {
			// retrive data from resultset
				int id = rs.getInt("panchayat_id");
				String panchayatName = rs.getString("panchayat_name");
				int blockId = rs.getInt("fk_panchayat_block");
				int constituency_id = rs.getInt("fk_panchayat_constituency");
				
			// create new panchayat object
			Panchayat tempPanchayat = new Panchayat(id,panchayatName, blockId, constituency_id);
			
			// add it to list of panchayats
			panchayatList.add(tempPanchayat);
		}
		
	return panchayatList;
	}
	finally {
		//close jdbc objects
		close(conn,stmt,rs);
	}
	
	}
	private void close (Connection conn, Statement stmt, ResultSet rs) {
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

	public void addPanchayat(String panchayatName, int block_id, int constituency_id) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// get db connection
			conn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into panchayat "
					   + "(panchayat_name, fk_panchayat_block, fk_panchayat_constituency) "
					   + "values (?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, panchayatName);
			pstmt.setInt(2, block_id);
			pstmt.setInt(3, constituency_id);
			// execute sql insert
			pstmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(conn, pstmt, null);
		}
		
	}

	public void deletePanchayat(String thePanchayatId) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//convert panchayat id to int
			int panchayat_id = Integer.parseInt(thePanchayatId);
			
			// get db connection
			conn = dataSource.getConnection();
			
			// create sql for delete
			String sql = "delete from panchayat where panchayat_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, panchayat_id);
			// execute sql insert
			pstmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(conn, pstmt, null);
		}
		
	}

	public Panchayat getPanchayat(String thePanchayatId) throws Exception {
		
		Panchayat tempPanchayat = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int panchayat_id = 0;
		try {
			panchayat_id = Integer.parseInt(thePanchayatId);
			
			// get a Connection
			conn = dataSource.getConnection();
			
			//create sql query
			String sql = "select * from panchayat where panchayat_id="+ panchayat_id;
			stmt = conn.createStatement();
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			if (rs.next()) {
				// retrive data from resultset
					//int id = rs.getInt("panchayat_id");
					String panchayatName = rs.getString("panchayat_name");
					
					
				// create new panchayat object
				tempPanchayat = new Panchayat(panchayat_id,panchayatName);
				
			}
			else {
				throw new Exception ("Couldn't find panchayat id:"+panchayat_id);
			}
		return tempPanchayat;
		}
		finally {
			//close jdbc objects
			close(conn,stmt,rs);
		}
	}

	public void updatePanchayat(Panchayat thePanchayat) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update panchayat "
						+ "set panchayat_name=? "
						+ "where panchayat_id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, thePanchayat.getPanchayatName());
			myStmt.setInt(2, thePanchayat.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
	}

	public List<Panchayat> getConst(int theBlockId) throws Exception {
		
		List<Panchayat> panchayatList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int block_id = 0;
		try {
			block_id = theBlockId;
			
			// get a Connection
			conn = dataSource.getConnection();
			
			//create sql query
			//String sql = "select distinct constituency.constituency_id, constituency_name from panchayat,constituency where panchayat.fk_panchayat_constituency=constituency.constituency_id and panchayat.fk_panchayat_block="+ block_id;
			String sql="select * from constituency";
			stmt = conn.createStatement();
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			/*if(!rs.first()) {
				stmt.close();
				rs.close();
				sql="select * from constituency";
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sql);
			}
			rs.beforeFirst();*/
			
			//process result set
			while (rs.next()) {
				// retrive data from resultset
					int constituency_id = rs.getInt("constituency_id");
					String constituency_name = rs.getString("constituency_name");
					
				// create new panchayat object
				Panchayat tempPanchayat = new Panchayat(block_id, constituency_id, constituency_name);
				
				// add it to list of panchayats
				panchayatList.add(tempPanchayat);
			}
			
		return panchayatList;
		}
		finally {
			//close jdbc objects
			close(conn,stmt,rs);
		}
		
	}
}
