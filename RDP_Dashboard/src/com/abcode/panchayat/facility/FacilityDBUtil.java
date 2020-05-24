package com.abcode.panchayat.facility;

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

public class FacilityDBUtil {
private static DataSource dataSource;
	
	public FacilityDBUtil (DataSource theDataSource) {
		dataSource = theDataSource;
		
	}

	
	public static List<Facility> getFacilityList(int panchayat_id) throws Exception{
		
		
		
		List<Facility>FacilityList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// get a Connection
			conn = dataSource.getConnection();
			
			//create sql query
			String sql = "select * from facility_details where fk_facility_panchayat="+panchayat_id;
			stmt = conn.createStatement();
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			while (rs.next()) {
				// retrive data from resultset
					int id = rs.getInt("facility_id");
					String facilityType = rs.getString("facilityType");	
					String facilityName = rs.getString("facilityName");	
					String facilityLevel = rs.getString("facilityLevel");	
					String area = rs.getString("area");	
					String location =rs.getString("location");	
					String identifier = rs.getString("identifier");	
					String facilityCondition = rs.getString("facilityCondition");	
					String lastRepaired=rs.getString("lastRepaired");
					String facilityNumber=rs.getString("facilityNumber");
					

				// create new Facility object
				Facility tempFacility = new Facility(id,panchayat_id,facilityType,facilityName,facilityLevel,area,location,identifier,facilityCondition,lastRepaired,facilityNumber);
				// add it to list of Facility
				FacilityList.add(tempFacility);
			}
		return FacilityList;
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

	public Facility getFacility(int theFacilityId,int panchayat_id) throws Exception {
		
		Facility tempFacility = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int Facility_id = 0;
		try {
			Facility_id = theFacilityId;
			
			// get a Connection
			conn = dataSource.getConnection();
			
			//create sql query
			String sql = "select * from facility_details where facility_id="+Facility_id;
			stmt = conn.createStatement();
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			if (rs.next()) {
				// retrive data from resultset
				
				int id = rs.getInt("facility_id");
				String facilityType = rs.getString("facilityType");	
				String facilityName = rs.getString("facilityName");	
				String facilityLevel = rs.getString("facilityLevel");	
				String area = rs.getString("area");	
				String location =rs.getString("location");	
				String identifier = rs.getString("identifier");	
				String facilityCondition = rs.getString("facilityCondition");	
				String lastRepaired=rs.getString("lastRepaired");
				String facilityNumber=rs.getString("facilityNumber");
				
					
				// create new Facility object
				tempFacility = new Facility(id,panchayat_id,facilityType,facilityName,facilityLevel,area,location,identifier,facilityCondition,lastRepaired,facilityNumber);
				
			}
			else {
				throw new Exception ("Couldn't find Facility id:"+Facility_id);
			}
		return tempFacility;
		}
		finally {
			//close jdbc objects
			close(conn,stmt,rs);
		}
	}

	public void updateFacility(Facility theFacility,int panchayat_id) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		//Get current date
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update facility_details "
					+ "set facilityType=?,facilityName=?,facilityLevel=?,area=?,location=?,identifier=?,facilityCondition=?,lastRepaired=?,facilityNumber=?,fk_facility_panchayat=? "
						+ "where facility_id=?";
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set parameters
			myStmt.setString(1, theFacility.getfacilityType());
			myStmt.setString(2, theFacility.getfacilityName());
			myStmt.setString(3,theFacility.getfacilityLevel());
			myStmt.setString(4,theFacility.getarea());
			myStmt.setString(5,theFacility.getlocation());
			myStmt.setString(6,theFacility.getidentifier());
			myStmt.setString(7,theFacility.getfacilityCondition());
			myStmt.setString(8,theFacility.getlastRepaired());
			myStmt.setString(9,theFacility.getfacilityNumber());
			myStmt.setInt(10,panchayat_id);
			myStmt.setInt(11,theFacility.getId());


			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
	}
	public void deleteFacility(String theFacilityId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//convert Facility id to int
			int Facility_id = Integer.parseInt(theFacilityId);
			
			// get db connection
			conn = dataSource.getConnection();
	
			// create sql for delete
			String sql = "delete from facility_details where facility_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,Facility_id);
			// execute sql insert
			pstmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(conn, pstmt, null);
		}
		
	}
	
	public void addFacility(String facilityType,String facilityName,String facilityLevel,String area,String location,String identifier,String facilityCondition,String lastRepaired,String facilityNumber,int panchayat_id) throws SQLException{

		Connection conn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			conn = dataSource.getConnection();
			
			// create sql for insert

			
			String sql = "insert into facility_details "
					   + "(facilityType,facilityName,facilityLevel,area,location,identifier,facilityCondition,lastRepaired,facilityNumber,fk_facility_panchayat ) "
					   + "values (?,?,?,?,?,?,?,?,?,?)";
			
			myStmt = conn.prepareStatement(sql);
			myStmt.setString(1,facilityType);
			myStmt.setString(2,facilityName);
			myStmt.setString(3,facilityLevel);
			myStmt.setString(4,area);
			myStmt.setString(5,location);
			myStmt.setString(6,identifier);
			myStmt.setString(7,facilityCondition);
			myStmt.setString(8,lastRepaired);
			myStmt.setString(9,facilityNumber);
			myStmt.setInt(10,panchayat_id);
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(conn, myStmt, null);
		}
		
	}
}
