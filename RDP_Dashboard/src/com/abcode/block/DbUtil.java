package com.abcode.block;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


public class DbUtil {
private DataSource dataSource;
	
	public DbUtil (DataSource theDataSource) {
		dataSource = theDataSource;
		
	}

	public List<Block> getBlockList(int district_id) throws Exception{
		
	
	
	List<Block> blockList = new ArrayList<>();
	
	Connection conn = null;
	Statement stmt = null;
	ResultSet rs = null;
	
	try {
		// get a Connection
		conn = dataSource.getConnection();
		
		//create sql query
		//String sql = "select * from block order by fk_block_district";
		String sql = "select block.block_id, block.block_name, district.district_name from block,district where block.fk_block_district=district.district_id and district_id="+district_id+" order by district.district_name";
		stmt = conn.createStatement();
		
		//execute query
		rs = stmt.executeQuery(sql);
		
		//process result set
		while (rs.next()) {
			// retrive data from resultset
				int id = rs.getInt("block_id");
				String blockName = rs.getString("block_name");
				//String districtName = rs.getString("fk_block_district").toString();
				String districtName = rs.getString("district_name");
				
				
			// create new block object
			Block tempBlock = new Block(id,blockName, districtName);
			
			// add it to list of blocks
			blockList.add(tempBlock);
		}
		
	return blockList;
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

	public void addBlock(String blockName, int district_id) throws SQLException {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			// get db connection
			conn = dataSource.getConnection();
			
			// create sql for insert
			String sql = "insert into block "
					   + "(block_name, fk_block_district) "
					   + "values (?,?)";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, blockName);
			pstmt.setInt(2, district_id);
			// execute sql insert
			pstmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(conn, pstmt, null);
		}
		
	}

	public boolean deleteBlock(String theBlockId) throws Exception {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			//convert block id to int
			int block_id = Integer.parseInt(theBlockId);
			
			// get db connection
			conn = dataSource.getConnection();
			
			//check for foreign key dependency
			String checkFK = "select * from panchayat where fk_panchayat_block="+block_id;
			stmt = conn.createStatement();
			rs = stmt.executeQuery(checkFK);
			if (rs.next()) {
			return false;
			}
			// create sql for delete
			String sql = "delete from block where block_id = ?";
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, block_id);
			// execute sql insert
			pstmt.execute();
			return true;
		}
		finally {
			// clean up JDBC objects
			close(conn, pstmt, null);
		}
		
	}

	public Block getBlock(String theBlockId) throws Exception {
		
		Block tempBlock = null;
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		int block_id = 0;
		try {
			block_id = Integer.parseInt(theBlockId);
			
			// get a Connection
			conn = dataSource.getConnection();
			
			//create sql query
			String sql = "select * from block where block_id="+ block_id;
			stmt = conn.createStatement();
			
			//execute query
			rs = stmt.executeQuery(sql);
			
			//process result set
			if (rs.next()) {
				// retrive data from resultset
					//int id = rs.getInt("block_id");
					String blockName = rs.getString("block_name");
					
					
				// create new block object
				tempBlock = new Block(block_id,blockName);
				
			}
			else {
				throw new Exception ("Couldn't find block id:"+block_id);
			}
		return tempBlock;
		}
		finally {
			//close jdbc objects
			close(conn,stmt,rs);
		}
	}

	public void updateBlock(Block theBlock) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;

		try {
			// get db connection
			myConn = dataSource.getConnection();
			
			// create SQL update statement
			String sql = "update block "
						+ "set block_name=? "
						+ "where block_id=?";
			
			// prepare statement
			myStmt = myConn.prepareStatement(sql);
			
			// set params
			myStmt.setString(1, theBlock.getblockName());
			myStmt.setInt(2, theBlock.getId());
			
			// execute SQL statement
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
		
	}
}
