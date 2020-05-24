package com.abcode.panchayat.panch;

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
 * Servlet implementation class PanchControllerServlet
 */
@WebServlet("/PanchControllerServlet")
public class PanchControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
private SarpanchDbUtil panchDbUtil;
	
	@Resource(name = "jdbc/datamgmt")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
	
		super.init();
		
		//create our panch db util
		try {
		panchDbUtil = new SarpanchDbUtil(dataSource);
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}

private HttpSession session;
int panchayat_id = 0;
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		session = request.getSession();
		panchayat_id = (int) session.getAttribute("panchayat_id");
		
		try {
			// read the "command" parameter
 			String theCommand = request.getParameter("command");
			
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listPanch(request, response);
				break;
				
			case "ADD":
				addPanch(request, response);
				break;
				
			case "LOAD":
				loadPanch(request, response);
				break;
				
			case "UPDATE":
				updatePanch(request, response);
				break;
			
			case "DELETE":
				deletePanch(request, response);
				break;
				
			default:
				listPanch(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}

	}



	private void deletePanch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read panch id from form data
				String thePanchId = request.getParameter("detailsId");
				
				// delete panch from database
				panchDbUtil.deletePanch(thePanchId);
				
				// send them back to "list panchs" page
				listPanch(request, response);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/error-panchs.jsp");
				dispatcher.forward(request, response);
				
		
	}



	private void updatePanch(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// read panch info from form data
				int thePanchId = Integer.parseInt(request.getParameter("detailsId"));
				String firstName = request.getParameter("firstName");		
				String middleName = request.getParameter("middleName");
				String lastName = request.getParameter("lastName");
				String designation = request.getParameter("designation");
				int age = Integer.parseInt(request.getParameter("age"));
				String gender = request.getParameter("gender");
				String category = request.getParameter("category");
				String profession = request.getParameter("profession");
				long contact = Long.parseLong(request.getParameter("contact"));
				// create a new panch object
				
				//Panch thePanch = panchDbUtil.getPanch(thePanchId,panchayat_id);
				Panch thePanch = new Panch(thePanchId, firstName, middleName, lastName,designation,age,gender,category,profession,contact,panchayat_id);
				
				// perform update on database
				panchDbUtil.updatePanch(thePanch,panchayat_id);
				
				// send them back to the "list panchs" page
				listPanch(request, response);
		
	}



	private void loadPanch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read panch id from form data
				int thePanchId = Integer.parseInt(request.getParameter("detailsId"));
				 
				 
				// get Panch from database (db util)
				Panch thePanch = panchDbUtil.getPanch(thePanchId,panchayat_id);
				
				// place Panch in the request attribute
				request.setAttribute("The_Panch", thePanch);
				// send to jsp page: update-Panch-form.jsp
				RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/update-panch-form.jsp");
				dispatcher.forward(request, response);
		
	}



	private void addPanch(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		// read panch info from form data
				String firstName = request.getParameter("firstName");		
				String middleName = request.getParameter("middleName");
				String lastName = request.getParameter("lastName");
				String designation = request.getParameter("designation");
				int age = Integer.parseInt(request.getParameter("age"));
				String gender = request.getParameter("gender");
				String category = request.getParameter("category");
				String profession = request.getParameter("profession");
				long contact = Long.parseLong(request.getParameter("contact"));
				
				// add the Panch to the database
				SarpanchDbUtil.addPanch(firstName, middleName, lastName,designation,age,gender,category,profession,contact,panchayat_id);
						
				// send back to main page (the Panch list)
				listPanch(request, response);

		
	}



	private void listPanch(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		
		//get Panch from dbUtil
		List<Panch> Panch = SarpanchDbUtil.getPanchList(panchayat_id);
		
		//add list of sarpanch and panches to request
		request.setAttribute("Panch_List", Panch);
		
		//send back selected panchayat
		
		//send to JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/panch-details.jsp");
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
