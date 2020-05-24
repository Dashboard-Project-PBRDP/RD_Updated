package com.abcode.panchayat.basic;

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

import com.abcode.panchayat.Panchayat;
import com.abcode.panchayat.panch.Panch;
import com.abcode.panchayat.panch.SarpanchDbUtil;

/**
 * Servlet implementation class PanchControllerServlet
 */
@WebServlet("/BasicControllerServlet")
public class BasicControllerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	private BasicDBUtil BasicDBUtil;
	
	@Resource(name = "jdbc/datamgmt")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
	
		super.init();
		
		//create our income db util
		try {
		BasicDBUtil = new BasicDBUtil(dataSource);
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
				listBasic(request, response);
				break;
				
			case "ADD":
				 addBasic(request, response);
				break;
				
			case "LOAD":
				loadBasic(request, response);
				break;
				
			case "UPDATE":
				updateBasic(request, response);
				break;
			
			case "DELETE":
				deleteBasic(request, response);
				break;
				
			default:
				listBasic(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
		private void listBasic(HttpServletRequest request, HttpServletResponse response) 
				throws Exception {
				
				//get income from dbUtil
				List<Basic> Basic = BasicDBUtil.getBasicList(panchayat_id);
				RequestDispatcher dispatcher=null;
				//add income to request
				request.setAttribute("Basic_List", Basic);
				
				//send back selected income
				//send to JSP
				if(Basic.isEmpty())
				{
					dispatcher = request.getRequestDispatcher("/panchayat/add-basic-details.jsp");
				}
				else
				{
				dispatcher = request.getRequestDispatcher("/panchayat/basic-details.jsp");

				}
				dispatcher.forward(request, response);
				
			}
		private void updateBasic(HttpServletRequest request, HttpServletResponse response) throws Exception {

			// read income info from form data
					int theBasicId = Integer.parseInt(request.getParameter("detailsId"));
					int population = Integer.parseInt(request.getParameter("population"));
					int households = Integer.parseInt(request.getParameter("households"));
					int voters = Integer.parseInt(request.getParameter("voters"));
					int wards = Integer.parseInt(request.getParameter("wards"));
					String topography = request.getParameter("topography");	
					int ponds = Integer.parseInt(request.getParameter("ponds"));
					String areaPonds = request.getParameter("areaPonds");	
					String pondFisheries = request.getParameter("pondFisheries");	
					String panchayatghar = request.getParameter("panchayatghar");	
					String panchayatgharType = request.getParameter("panchayatgharType");	
					int dharamshalas = Integer.parseInt(request.getParameter("dharamshalas"));
					int reservedDharamshalas = Integer.parseInt(request.getParameter("reservedDharamshalas"));
					int parks = Integer.parseInt(request.getParameter("parks"));
					String areaParks = request.getParameter("areaParks");	
					int playgrounds = Integer.parseInt(request.getParameter("playgrounds"));
					String areaPlaygrounds = request.getParameter("areaPlaygrounds");	
					String mandiDistance = request.getParameter("mandiDistance");	
					int banks = Integer.parseInt(request.getParameter("banks"));
					String datelastUpdated = request.getParameter("datelastUpdated");	
					 // create a new income object

					Basic theBasic =new Basic(theBasicId,panchayat_id,population,households,voters,wards,topography,ponds,
							areaPonds,pondFisheries,panchayatghar,panchayatgharType,
							dharamshalas,reservedDharamshalas,parks,areaParks,playgrounds,
							areaPlaygrounds,mandiDistance,banks,datelastUpdated);
					// perform update on database
					BasicDBUtil.updateBasic(theBasic,panchayat_id);
					
					// send them back to the "list income" page
					listBasic(request, response);
			
		}



		private void loadBasic(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			// read income id from form data
					int theBasicId = Integer.parseInt(request.getParameter("detailsId"));
					 
					 
					// get income from database (db util)
					Basic theBasic = BasicDBUtil.getBasic(theBasicId,panchayat_id);
					
					// place income in the request attribute
					request.setAttribute("The_Basic", theBasic);
					// send to jsp page: update-income-form.jsp
					RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/update-basic-form.jsp");
					dispatcher.forward(request, response);
			
		}
		private void addBasic(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			// read income info from form data
			int population = Integer.parseInt(request.getParameter("population"));
			int households = Integer.parseInt(request.getParameter("households"));
			int voters = Integer.parseInt(request.getParameter("voters"));
			int wards = Integer.parseInt(request.getParameter("wards"));
			String topography = request.getParameter("topography");	
			int ponds = Integer.parseInt(request.getParameter("ponds"));
			String areaPonds = request.getParameter("areaPonds");	
			String pondFisheries = request.getParameter("pondFisheries");	
			String panchayatghar = request.getParameter("panchayatghar");	
			String panchayatgharType = request.getParameter("panchayatgharType");	
			int dharamshalas = Integer.parseInt(request.getParameter("dharamshalas"));
			int reservedDharamshalas = Integer.parseInt(request.getParameter("reservedDharamshalas"));
			int parks = Integer.parseInt(request.getParameter("parks"));
			String areaParks = request.getParameter("areaParks");	
			int playgrounds = Integer.parseInt(request.getParameter("playgrounds"));
			String areaPlaygrounds = request.getParameter("areaPlaygrounds");	
			String mandiDistance = request.getParameter("mandiDistance");	
			int banks = Integer.parseInt(request.getParameter("banks"));
			String datelastUpdated = request.getParameter("datelastUpdated");	
						// add the Basic to the database
					BasicDBUtil.addBasic(population,households,voters,wards,topography,ponds,
							areaPonds,pondFisheries,panchayatghar,panchayatgharType,
							dharamshalas,reservedDharamshalas,parks,areaParks,playgrounds,
							areaPlaygrounds,mandiDistance,banks,datelastUpdated,panchayat_id);
							
					// send back to main page (the Panch list)
					listBasic(request, response);

			
		}
		

		private void deleteBasic(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			// read income id from form data
					String theIncomeId = request.getParameter("detailsId");
					
					// delete income from database
					BasicDBUtil.deleteBasic(theIncomeId);
					
					// send them back to "list income" page
					listBasic(request, response);
					
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
