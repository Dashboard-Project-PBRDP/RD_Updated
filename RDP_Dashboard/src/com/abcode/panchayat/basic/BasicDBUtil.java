package com.abcode.panchayat.basic;

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

public class BasicDBUtil {
private static DataSource dataSource;
	
	public BasicDBUtil (DataSource theDataSource) {
		dataSource = theDataSource;
		
	}
	//Get current date
	Date date = Calendar.getInstance().getTime();
	DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
	String strDate = dateFormat.format(date);
	
	public static List<Basic> getBasicList(int panchayat_id) throws Exception{
		
		
		
		List<Basic> BasicList = new ArrayList<>();
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// get a Connection
			conn = dataSource.getConnection();
			
			//create sql query
			String sql = "select * from basic_details where fk_Basic_panchayat="+panchayat_id;
			stmt = conn.createStatement();
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			while (rs.next()) {
				// retrive data from resultset
					int id = rs.getInt("basic_id");
					int population = rs.getInt("population");
					int households = rs.getInt("households");
					int voters = rs.getInt("voters");
					int wards = rs.getInt("wards");
					String topography = rs.getString("topography");
					int ponds = rs.getInt("ponds");
					String areaPonds = rs.getString("areaPonds");
					String pondFisheries = rs.getString("pondFisheries");
					String panchayatghar = rs.getString("panchayatghar");
					String panchayatgharType = rs.getString("panchayatgharType");
					int dharamshalas = rs.getInt("dharamshalas");
					int reservedDharamshalas = rs.getInt("reservedDharamshalas");
					int parks = rs.getInt("parks");
					String areaParks = rs.getString("areaParks");
					int playgrounds = rs.getInt("playgrounds");
					String areaPlaygrounds = rs.getString("areaPlaygrounds");
					String mandiDistance = rs.getString("mandiDistance");
					int banks = rs.getInt("banks");
					String datelastUpdated = rs.getString("datelastUpdated");

				// create new Basic object
				Basic tempBasic = new Basic(id,panchayat_id,population,households,voters
						,wards,topography,ponds,areaPonds,pondFisheries,panchayatghar,panchayatgharType,
						dharamshalas,reservedDharamshalas,parks,areaParks,playgrounds,
						areaPlaygrounds,mandiDistance,banks,datelastUpdated);
				// add it to list of Basic
				BasicList.add(tempBasic);
			}
			
		return BasicList;
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

	public Basic getBasic(int theBasicId,int panchayat_id) throws Exception {
		
		Basic tempBasic = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int Basic_id = 0;
		try {
			Basic_id = theBasicId;
			
			// get a Connection
			conn = dataSource.getConnection();
			
			//create sql query
			String sql = "select * from Basic_details where Basic_id="+ Basic_id;
			stmt = conn.createStatement();
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			if (rs.next()) {
				// retrive data from resultset
				
					int id = rs.getInt("Basic_id");
					int population = rs.getInt("population");
					int households = rs.getInt("households");
					int voters = rs.getInt("voters");
					int wards = rs.getInt("wards");
					String topography = rs.getString("topography");	
					int ponds = rs.getInt("ponds");
					String areaPonds = rs.getString("areaPonds");	
					String pondFisheries = rs.getString("pondFisheries");	
					String panchayatghar = rs.getString("panchayatghar");	
					String panchayatgharType = rs.getString("panchayatgharType");	
					int dharamshalas = rs.getInt("dharamshalas");
					int reservedDharamshalas = rs.getInt("reservedDharamshalas");
					int parks = rs.getInt("parks");
					String areaParks = rs.getString("areaParks");	
					int playgrounds = rs.getInt("playgrounds");
					String areaPlaygrounds = rs.getString("areaPlaygrounds");	
					String mandiDistance = rs.getString("mandiDistance");	
					int banks = rs.getInt("banks");
					String datelastUpdated = rs.getString("datelastUpdated");
				
					
				// create new Basic object
				tempBasic =  new Basic(id,panchayat_id,population,households,voters
						,wards,topography,ponds,areaPonds,pondFisheries,panchayatghar,panchayatgharType,
						dharamshalas,reservedDharamshalas,parks,areaParks,playgrounds,
						areaPlaygrounds,mandiDistance,banks,datelastUpdated);
				
			}
			else {
				throw new Exception ("Couldn't find Basic id:"+Basic_id);
			}
		return tempBasic;
		}
		finally {
			//close jdbc objects
			close(conn,stmt,rs);
		}
	}

	public void updateBasic(Basic theBasic,int panchayat_id) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;
		//Get current date
		Date date = Calendar.getInstance().getTime();
		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss");
		String strDate = dateFormat.format(date);
		
		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update basic_details "
					+ "set population=?,households=?,voters=?,wards=?,topography=?,ponds=?,areaPonds=?,pondFisheries=?,panchayatghar=?,panchayatgharType=?,dharamshalas=?,reservedDharamshalas=?,parks=?,areaParks=?,playgrounds=?,areaPlaygrounds=?,mandiDistance=?,banks=?,datelastUpdated=?,fk_basic_panchayat=? "
						+ "where basic_id=?";
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set parameters
			myStmt.setInt(1, theBasic.getPopulation());
			myStmt.setInt(2, theBasic.getHouseholds());
			myStmt.setInt(3, theBasic.getVoters());
			myStmt.setInt(4, theBasic.getWards());
			myStmt.setString(5, theBasic.getTopography());
			myStmt.setInt(6, theBasic.getPonds());
			myStmt.setString(7, theBasic.getAreaPonds());
			myStmt.setString(8, theBasic.getPondFisheries());
			myStmt.setString(9, theBasic.getPanchayatghar());
			myStmt.setString(10, theBasic.getPanchayatgharType());
			myStmt.setInt(11, theBasic.getDharamshalas());
			myStmt.setInt(12, theBasic.getReservedDharamshalas());
			myStmt.setInt(13, theBasic.getParks());
			myStmt.setString(14, theBasic.getAreaParks());
			myStmt.setInt(15,theBasic.getPlaygrounds());
			myStmt.setString(16, theBasic.getAreaPlaygrounds());
			myStmt.setString(17, theBasic.getMandiDistance());
			myStmt.setInt(18,theBasic.getBanks());
			myStmt.setString(19, strDate);
			myStmt.setInt(20, theBasic.getPanchayat_id());
			myStmt.setInt(21, theBasic.getId());
			System.out.println("==="+myStmt);
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
	}
	public void deleteBasic(String theBasicId) throws Exception {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			//convert Basic id to int
			int Basic_id = Integer.parseInt(theBasicId);
			
			// get db connection
			conn = dataSource.getConnection();
	
			// create sql for delete
			String sql = "delete from basic_details where basic_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, Basic_id);
			// execute sql insert
			pstmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(conn, pstmt, null);
		}
		
	}
	
	public void addBasic(int population, int households, int voters, int wards, String topography, int ponds,
			String areaPonds, String pondFisheries, String panchayatghar, String panchayatgharType, int dharamshalas,
			int reservedDharamshalas, int parks, String areaParks, int playgrounds, String areaPlaygrounds,
			String mandiDistance, int banks, String datelastUpdated,int panchayat_id) throws SQLException{

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// get db connection
			conn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into basic_details "
					   + "(population,households,voters,wards,topography,ponds,\r\n" + 
					   "							areaPonds,pondFisheries,panchayatghar,panchayatgharType,\r\n" + 
					   "							dharamshalas,reservedDharamshalas,parks,areaParks,playgrounds,\r\n" + 
					   "							areaPlaygrounds,mandiDistance,banks,datelastUpdated, fk_basic_panchayat) "
					   + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, population);
			pstmt.setInt(2, households);
			pstmt.setInt(3, voters);
			pstmt.setInt(4, wards);
			pstmt.setString(5, topography);
			pstmt.setInt(6, ponds);
			pstmt.setString(7, areaPonds);
			pstmt.setString(8, pondFisheries);
			pstmt.setString(9, panchayatghar);
			pstmt.setString(10, panchayatgharType);
			pstmt.setInt(11, dharamshalas);
			pstmt.setInt(12, reservedDharamshalas);
			pstmt.setInt(13, parks);
			pstmt.setString(14, areaParks);
			pstmt.setInt(15,playgrounds);
			pstmt.setString(16, areaPlaygrounds);
			pstmt.setString(17, mandiDistance);
			pstmt.setInt(18,banks);
			pstmt.setString(19, strDate);
			pstmt.setInt(20, panchayat_id);
			
			// execute sql insert
			pstmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(conn, pstmt, null);
		}
		
	}
}
