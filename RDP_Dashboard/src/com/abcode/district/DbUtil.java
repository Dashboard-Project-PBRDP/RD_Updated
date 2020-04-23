package com.abcode.district;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class DbUtil {
private DataSource dataSource;
	
	public DbUtil (DataSource theDataSource) {
		dataSource = theDataSource;
		
	}

	public List<District> getDistrict() throws Exception{
		
	
	
	List<District> districtList = new ArrayList<>();
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		// get a Connection
		conn = dataSource.getConnection();
		
		//create sql query
		String sql = "select * from district order by district_id";
		
		stmt = conn.createStatement();
		
		//execute query
		rs = stmt.executeQuery(sql);
		
		//process result set
		while (rs.next()) {
			// retrive data from resultset
				int id = rs.getInt("district_id");
				String districtName = rs.getString("district_name");
				
				
			// create new district object
			District temp = new District(id, districtName);
			
			// add it to list of districts
			districtList.add(temp);
		}
		
	return districtList;
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
}
