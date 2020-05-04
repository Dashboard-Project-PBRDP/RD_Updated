package com.abcode.panchayat;

import java.io.IOException;
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
 * Servlet implementation class PanchayatControllerServlet
 */
@WebServlet("/PanchayatControllerServlet")
public class PanchayatControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private PanchayatDbUtil DbUtil;
	
	@Resource(name = "jdbc/datamgmt")
	private DataSource dataSource;
	int block_id=0;
	String blockName="";
	HttpSession session = null;
	@Override
	public void init() throws ServletException {
	
		super.init();
		
		//create our Panchayat db util
		try {
		DbUtil = new PanchayatDbUtil(dataSource);
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}



	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("blockId")!= null) {
		//set session object
			 session = request.getSession();
			//get selected block value
			
			block_id = Integer.parseInt(request.getParameter("blockId"));
			blockName = request.getParameter("blockName");
			session.setAttribute("block_id", block_id);
			session.setAttribute("blockName", blockName);
			}
		
			
		try {
			// read the "command" parameter
 			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing panchayats
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listPanchayats(request, response);
				break;
				
			case "ADD":
				addPanchayat(request, response);
				break;
				
			case "LOAD":
				loadPanchayat(request, response);
				break;
				
			case "UPDATE":
				updatePanchayat(request, response);
				break;
			
			case "DELETE":
				deletePanchayat(request, response);
				break;
			
			case "CONST":
				getConstituency(request, response);
				break;
			default:
				listPanchayats(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}

	}



	private void getConstituency(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//get block_id from prevailing session
		int theBlockId =   (int) session.getAttribute("block_id");
		
		//call dbutil to obtain all constituencies for this block
		List<Panchayat> constituency = DbUtil.getConst(theBlockId);
				
				//add constituency to request
				request.setAttribute("Constituency", constituency);
				
				//send back selected add form
				
				//send to JSP
				RequestDispatcher dispatcher = request.getRequestDispatcher("/add-panchayat-form.jsp");
				dispatcher.forward(request, response);
	}



	private void deletePanchayat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read panchayat id from form data
				String thePanchayatId = request.getParameter("panchayatId");
				
				// delete panchayat from database
				DbUtil.deletePanchayat(thePanchayatId);
				
				// send them back to "list panchayats" page
				listPanchayats(request, response);
		
	}



	private void updatePanchayat(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read panchayat info from form data
				int id = Integer.parseInt(request.getParameter("panchayatId"));
				String panchayatName = request.getParameter("panchayatName");
				
				// create a new panchayat object
				Panchayat thePanchayat = new Panchayat(id, panchayatName);
				
				// perform update on database
				DbUtil.updatePanchayat(thePanchayat);
				
				// send them back to the "list panchayats" page
				listPanchayats(request, response);
		
	}



	private void loadPanchayat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read panchayat id from form data
				String thePanchayatId = request.getParameter("panchayatId");
				 
				 
				// get Panchayat from database (db util)
				Panchayat thePanchayat = DbUtil.getPanchayat(thePanchayatId);
				
				// place Panchayat in the request attribute
				request.setAttribute("The_Panchayat", thePanchayat);
				
				// send to jsp page: update-Panchayat-form.jsp
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("/update-panchayat-form.jsp");
				dispatcher.forward(request, response);
		
	}



	private void addPanchayat(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read panchayat info from form data
				String panchayatName = request.getParameter("panchayatName");		
				int constituency_id = Integer.parseInt(request.getParameter("constituency"));
				// add the Panchayat to the database
				DbUtil.addPanchayat(panchayatName, block_id, constituency_id);
						
				// send back to main page (the Panchayat list)
				listPanchayats(request, response);

	}



	private void listPanchayats(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		
		//get Panchayats from dbUtil
		List<Panchayat> Panchayat = DbUtil.getPanchayatList(block_id);
		
		//add Panchayats to request
		request.setAttribute("Panchayat_List", Panchayat);
		
		//send back selected district
		
		//send to JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-Panchayats.jsp");
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
