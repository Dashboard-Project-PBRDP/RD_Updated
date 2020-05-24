package com.abcode.panchayat.facility;


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
@WebServlet("/FacilityControllerServlet")
public class FacilityControllerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	private FacilityDBUtil FacilityDBUtil;
	
	@Resource(name = "jdbc/datamgmt")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
	
		super.init();
		
		//create our property db util
		try {
		FacilityDBUtil = new FacilityDBUtil(dataSource);
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
				listFacility(request, response);
				break;
				
			case "ADD":
				 addFacility(request, response);
				break;
				
			case "LOAD":
				loadFacility(request, response);
				break;
				
			case "UPDATE":
				updateFacility(request, response);
				break;
			
			case "DELETE":
				deleteFacility(request, response);
				break;
				
			default:
				listFacility(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
		private void listFacility(HttpServletRequest request, HttpServletResponse response) 
				throws Exception {
				
				//get property from dbUtil
				List<Facility> Facility = FacilityDBUtil.getFacilityList(panchayat_id);
				//add property to request
				request.setAttribute("Facility_List", Facility);
				//send to JSP
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/health-education-details.jsp");
				dispatcher.forward(request, response);
				
			}
		private void updateFacility(HttpServletRequest request, HttpServletResponse response) throws Exception {

			// read property info from form data
					int id = Integer.parseInt(request.getParameter("detailsId"));
					String facilityType = request.getParameter("facilityType");	
					String facilityName = request.getParameter("facilityName");	
					String facilityLevel = request.getParameter("facilityLevel");	
					String area = request.getParameter("area");	
					String location = request.getParameter("location");	
					String identifier = request.getParameter("identifier");	
					String facilityCondition = request.getParameter("facilityCondition");	
					String lastRepaired=request.getParameter("lastRepaired");
					String facilityNumber=request.getParameter("facilityNumber");
					

					 // create a new property object

					Facility theFacility =new Facility(id,panchayat_id,facilityType,facilityName,facilityLevel,area,location,identifier,facilityCondition,lastRepaired,facilityNumber) ;
					// perform update on database
					FacilityDBUtil.updateFacility(theFacility,panchayat_id);
					
					// send them back to the "list property" page
					listFacility(request, response);
			
		}



		private void loadFacility(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
					// read property id from form data
					int theFacilityId = Integer.parseInt(request.getParameter("detailsId"));					 
					// get property from database
					Facility theFacility = FacilityDBUtil.getFacility(theFacilityId,panchayat_id);
					
					// place property in the request attribute
					request.setAttribute("The_Facility", theFacility);
					// send to jsp page: update-property-form.jsp
					RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/update-facility-form.jsp");
					dispatcher.forward(request, response);
			
		}
		private void addFacility(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			// read property info from form data
			String facilityType = request.getParameter("facilityType");	
			String facilityName = request.getParameter("facilityName");	
			String facilityLevel = request.getParameter("facilityLevel");	
			String area = request.getParameter("area");	
			String location = request.getParameter("location");	
			String identifier = request.getParameter("identifier");	
			String facilityCondition = request.getParameter("facilityCondition");	
			String lastRepaired=request.getParameter("lastRepaired");
			String facilityNumber=request.getParameter("facilityNumber");
						// add the Facility to the database
					FacilityDBUtil.addFacility(facilityType,facilityName,facilityLevel,area,location,identifier,facilityCondition,lastRepaired,facilityNumber,panchayat_id);
					// send back to main page (the Facility list)
					
					listFacility(request, response);

			
		}
		

		private void deleteFacility(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			// read property id from form data
					String theFacilityId = request.getParameter("detailsId");
					// delete property from database
					FacilityDBUtil.deleteFacility(theFacilityId);
					
					// send them back to "list property" page
					listFacility(request, response);
					
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
