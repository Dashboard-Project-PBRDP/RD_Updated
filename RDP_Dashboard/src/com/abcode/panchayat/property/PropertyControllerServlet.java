package com.abcode.panchayat.property;


import java.io.IOException;
import java.util.Date;
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

import com.abcode.panchayat.Panchayat;
import com.abcode.panchayat.panch.Panch;
import com.abcode.panchayat.panch.SarpanchDbUtil;

/**
 * Servlet implementation class PanchControllerServlet
 */
@WebServlet("/PropertyControllerServlet")
public class PropertyControllerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	private PropertyDBUtil PropertyDBUtil;
	
	@Resource(name = "jdbc/datamgmt")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
	
		super.init();
		
		//create our property db util
		try {
		PropertyDBUtil = new PropertyDBUtil(dataSource);
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}

private HttpSession session;
int panchayat_id = 0;
String panchayatName="";
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		session  = request.getSession();
		panchayat_id = (int) session.getAttribute("panchayat_id");
		panchayatName =(String) session.getAttribute("panchayatName");

		try {
			// read the "command" parameter
 			String theCommand = request.getParameter("command");
			
			if (theCommand == null) {
				theCommand = "LIST";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "LIST":
				listProperty(request, response);
				break;
				
			case "ADD":
				 addProperty(request, response);
				break;
				
			case "LOAD":
				loadProperty(request, response);
				break;
				
			case "UPDATE":
				updateProperty(request, response);
				break;
			
			case "DELETE":
				deleteProperty(request, response);
				break;
				
			default:
				listProperty(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
		private void listProperty(HttpServletRequest request, HttpServletResponse response) 
				throws Exception {
				
				//get property from dbUtil
				List<Property> Property = PropertyDBUtil.getPropertyList(panchayat_id);
				//add property to request
				request.setAttribute("Property_List", Property);
				//send to JSP
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/property-details.jsp");
				dispatcher.forward(request, response);
				
			}
		private void updateProperty(HttpServletRequest request, HttpServletResponse response) throws Exception {

			// read property info from form data
					int id = Integer.parseInt(request.getParameter("detailsId"));
					String propertyType = request.getParameter("propertyType");	
					String propertyName = request.getParameter("propertyName");	
					String area = request.getParameter("area");	
					String location = request.getParameter("location");	
					String identifier = request.getParameter("identifier");	
					String purpose = request.getParameter("purpose");	
					String leasedOut = request.getParameter("leasedOut");	
					String leasedFrom=request.getParameter("leasedFrom");
					String leasedTo=request.getParameter("leasedTo");
					String leaseAmount = request.getParameter("leaseAmount");	
					String leaseAmountpyear = request.getParameter("leaseAmountpyear");	
					

					 // create a new property object

					Property theProperty =new Property(id,panchayat_id,propertyType,propertyName,area,location,identifier,purpose,leasedOut,
							leasedFrom,leasedTo,leaseAmount,leaseAmountpyear ) ;
					// perform update on database
					PropertyDBUtil.updateProperty(theProperty,panchayat_id);
					
					// send them back to the "list property" page
					listProperty(request, response);
			
		}



		private void loadProperty(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
					// read property id from form data
					int thePropertyId = Integer.parseInt(request.getParameter("detailsId"));					 
					// get property from database
					Property theProperty = PropertyDBUtil.getProperty(thePropertyId,panchayat_id);
					
					// place property in the request attribute
					request.setAttribute("The_Property", theProperty);
					// send to jsp page: update-property-form.jsp
					RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/update-property-form.jsp");
					dispatcher.forward(request, response);
			
		}
		private void addProperty(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			// read property info from form data
			String propertyType = request.getParameter("propertyType");	
			String propertyName = request.getParameter("propertyName");	
			String area = request.getParameter("area");	
			String location = request.getParameter("location");	
			String identifier = request.getParameter("identifier");	
			String purpose = request.getParameter("purpose");	
			String leasedOut = request.getParameter("leasedOut");	
			String leasedFrom=request.getParameter("leasedFrom");
			String leasedTo=request.getParameter("leasedTo");
			String leaseAmount = request.getParameter("leaseAmount");	
			String leaseAmountpyear = request.getParameter("leaseAmountpyear");	
						// add the Property to the database
					PropertyDBUtil.addProperty(propertyType,propertyName,area,location,identifier,purpose,leasedOut,
							leasedFrom,leasedTo,leaseAmount,leaseAmountpyear,panchayat_id);
					// send back to main page (the Property list)
					listProperty(request, response);

			
		}
		

		private void deleteProperty(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			// read property id from form data
					String thePropId = request.getParameter("detailsId");
					System.out.println("===delet"+thePropId);
					// delete property from database
					PropertyDBUtil.deleteProperty(thePropId);
					
					// send them back to "list property" page
					listProperty(request, response);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/error-basic.jsp");
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
