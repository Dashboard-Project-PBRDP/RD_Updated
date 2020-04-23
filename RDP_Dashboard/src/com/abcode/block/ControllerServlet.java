package com.abcode.block;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.sql.DataSource;


/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/ControllerServlet")
public class ControllerServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

	
	private DbUtil DbUtil;
	
	@Resource(name = "jdbc/RDP_Dashboard")
	private DataSource dataSource;
	int district_id=0;
	String districtName="";
	
	@Override
	public void init() throws ServletException {
	
		super.init();
		
		//create our Block db util
		try {
		DbUtil = new DbUtil(dataSource);
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("district_id")!= null) {
		//set session object
			HttpSession session = request.getSession();
			//get selected district value
			district_id = Integer.parseInt(request.getParameter("district_id"));
			districtName = request.getParameter("districtName");
			session.setAttribute("district_id", district_id);
			session.setAttribute("districtName", districtName);
			}
		
			
		try {
			// read the "command" parameter
 			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing blocks
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listBlocks(request, response);
				break;
				
			case "ADD":
				addBlock(request, response);
				break;
				
			case "LOAD":
				loadBlock(request, response);
				break;
				
			case "UPDATE":
				updateBlock(request, response);
				break;
			
			case "DELETE":
				deleteBlock(request, response);
				break;
				
			default:
				listBlocks(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}

	}



	private void deleteBlock(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read block id from form data
				String theBlockId = request.getParameter("blockId");
				
				// delete block from database
				if(DbUtil.deleteBlock(theBlockId)) {
				
				// send them back to "list blocks" page
				listBlocks(request, response);
				} else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/error-blocks.jsp");
				dispatcher.forward(request, response);
				}
		
	}



	private void updateBlock(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read block info from form data
				int id = Integer.parseInt(request.getParameter("blockId"));
				String blockName = request.getParameter("blockName");
				
				// create a new block object
				Block theBlock = new Block(id, blockName);
				
				// perform update on database
				DbUtil.updateBlock(theBlock);
				
				// send them back to the "list blocks" page
				listBlocks(request, response);
		
	}



	private void loadBlock(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read block id from form data
				String theBlockId = request.getParameter("blockId");
				 
				 
				// get Block from database (db util)
				Block theBlock = DbUtil.getBlock(theBlockId);
				
				// place Block in the request attribute
				request.setAttribute("The_Block", theBlock);
				
				// send to jsp page: update-Block-form.jsp
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/update-block-form.jsp");
				dispatcher.forward(request, response);
		
	}



	private void addBlock(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read block info from form data
				String blockName = request.getParameter("blockName");		
				
				//int district_id = (int) session.getAttribute("district_id");
				
				// add the Block to the database
				DbUtil.addBlock(blockName, district_id);
						
				// send back to main page (the Block list)
				listBlocks(request, response);

		
	}



	private void listBlocks(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		
		//get Blocks from dbUtil
		List<Block> Block = DbUtil.getBlockList(district_id);
		
		//add Blocks to request
		request.setAttribute("Block_List", Block);
		
		//send back selected district
		
		//send to JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-Blocks.jsp");
		dispatcher.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
