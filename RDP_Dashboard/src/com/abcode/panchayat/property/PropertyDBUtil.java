package com.abcode.panchayat.property;

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

public class PropertyDBUtil {
private static DataSource dataSource;
	
	public PropertyDBUtil (DataSource theDataSource) {
		dataSource = theDataSource;
		
	}

	
	public static List<Property> getPropertyList(int panchayat_id) throws Exception{
		
		
		
		List<Property> PropertyList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// get a Connection
			conn = dataSource.getConnection();
			
			//create sql query
			String sql = "select * from property_details where fk_property_panchayat="+panchayat_id;
			stmt = conn.createStatement();
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			while (rs.next()) {
				// retrive data from resultset
					int id = rs.getInt("property_id");
					String propertyType = rs.getString("propertyType");
					String propertyName = rs.getString("propertyName");
					String area = rs.getString("area");
					String location = rs.getString("location");
					String identifier = rs.getString("identifier");
					String purpose = rs.getString("purpose");
					String leasedOut = rs.getString("leasedOut");
					String leasedFrom=rs.getString("leasedFrom");
					String leasedTo=rs.getString("leasedTo");
					String leaseAmount = rs.getString("leaseAmount");
					String leaseAmountpyear = rs.getString("leaseAmountpyear");

				// create new Property object
				Property tempProperty = new Property(id,panchayat_id,propertyType,propertyName,area,location,identifier,purpose,leasedOut,
						leasedFrom,leasedTo,leaseAmount,leaseAmountpyear);
				// add it to list of Property
				PropertyList.add(tempProperty);
			}
			
		return PropertyList;
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

	public Property getProperty(int thePropertyId,int panchayat_id) throws Exception {
		
		Property tempProperty = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int Property_id = 0;
		try {
			Property_id = thePropertyId;
			
			// get a Connection
			conn = dataSource.getConnection();
			
			//create sql query
			String sql = "select * from property_details where property_id="+ Property_id;
			stmt = conn.createStatement();
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			if (rs.next()) {
				// retrive data from resultset
				
				int id = rs.getInt("property_id");
				String propertyType = rs.getString("propertyType");
				String propertyName = rs.getString("propertyName");
				String area = rs.getString("area");
				String location = rs.getString("location");
				String identifier = rs.getString("identifier");
				String purpose = rs.getString("purpose");
				String leasedOut = rs.getString("leasedOut");
				String leasedFrom=rs.getString("leasedFrom");
				String leasedTo=rs.getString("leasedTo");
				String leaseAmount = rs.getString("leaseAmount");
				String leaseAmountpyear = rs.getString("leaseAmountpyear");
				
					
				// create new Property object
				tempProperty = new Property(id,panchayat_id,propertyType,propertyName,area,location,identifier,purpose,leasedOut,
						leasedFrom,leasedTo,leaseAmount,leaseAmountpyear);
				
			}
			else {
				throw new Exception ("Couldn't find Property id:"+Property_id);
			}
		return tempProperty;
		}
		finally {
			//close jdbc objects
			close(conn,stmt,rs);
		}
	}

	public void updateProperty(Property theProperty,int panchayat_id) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		//Get current date
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update property_details "
					+ "set propertyType=?,propertyName=?,area=?,location=?,identifier=?,purpose=?,leasedOut=?,\r\n" + 
					"							leasedFrom=?,leasedTo=?,leaseAmount=?,leaseAmountpyear=?,fk_property_panchayat=? "
						+ "where property_id=?";
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set parameters
			myStmt.setString(1, theProperty.getpropertyType());
			myStmt.setString(2,theProperty.getpropertyName());
			myStmt.setString(3,theProperty.getarea());
			myStmt.setString(4,theProperty.getlocation());
			myStmt.setString(5,theProperty.getidentifier());
			myStmt.setString(6,theProperty.getpurpose());
			myStmt.setString(7,theProperty.getleasedOut());
			myStmt.setString(8,theProperty.getleasedFrom());
			myStmt.setString(9,theProperty.getleasedTo());
			myStmt.setString(10,theProperty.getleaseAmount());
			myStmt.setString(11,theProperty.getleaseAmountpyear());
			myStmt.setInt(12,panchayat_id);
			myStmt.setInt(13,theProperty.getId());


			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
	}
	public void deleteProperty(String thePropertyId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//convert Property id to int
			int Property_id = Integer.parseInt(thePropertyId);
			
			// get db connection
			conn = dataSource.getConnection();
	
			// create sql for delete
			String sql = "delete from property_details where property_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Property_id);
			// execute sql insert
			pstmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(conn, pstmt, null);
		}
		
	}
	
	public void addProperty(String propertyType,String propertyName,String area,String location,String identifier,String purpose,String leasedOut,
			String leasedFrom,String leasedTo,String leaseAmount,String leaseAmountpyear,int panchayat_id) throws SQLException{

		Connection conn = null;
		PreparedStatement myStmt = null;
		
		try {
			// get db connection
			conn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into property_details "
					   + "(propertyType,propertyName,area,location,identifier,purpose,leasedOut,\r\n" + 
					   "							leasedFrom,leasedTo,leaseAmount,leaseAmountpyear,fk_property_panchayat) "
					   + "values (?,?,?,?,?,?,?,?,?,?,?,?)";
			
			myStmt = conn.prepareStatement(sql);
			myStmt.setString(1,propertyType);
			myStmt.setString(2,propertyName);
			myStmt.setString(3,area);
			myStmt.setString(4,location);
			myStmt.setString(5,identifier);
			myStmt.setString(6,purpose);
			myStmt.setString(7,leasedOut);
			myStmt.setString(8,leasedFrom);
			myStmt.setString(9,leasedTo);
			myStmt.setString(10,leaseAmount);
			myStmt.setString(11,leaseAmountpyear);
			myStmt.setInt(12,panchayat_id);
			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(conn, myStmt, null);
		}
		
	}
}
