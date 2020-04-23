package com.abcode.panchayat.detail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class PDetailControllerServlet
 */
@WebServlet("/PDetailControllerServlet")
public class PDetailControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	int panchayat_id=0;
	String panchayatName="";
	HttpSession session = null;
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("panchayatId")!= null && panchayat_id==0) {
		//set session object
			 session = request.getSession();
			//get selected panchayat value
			
			panchayat_id = Integer.parseInt(request.getParameter("panchayatId"));
			panchayatName = request.getParameter("panchayatName");
			session.setAttribute("panchayat_id", panchayat_id);
			session.setAttribute("panchayatName", panchayatName);
			}
		try {
			// read the "command" parameter
 			String theCommand = request.getParameter("command");
			
			// if the command is missing, then default to listing panchayats details
			if (theCommand == null) {
				theCommand = "0";
			}
			
			// route to the appropriate method
			switch (theCommand) {
			
			case "0":
				listDetails(request, response);
				break;
				
			case "1":
				panchDetails(request, response);
				break;
				
			case "2":
				basicDetails(request, response);
				break;
				
			case "3":
				incomeDetails(request, response);
				break;
			
			case "4":
				expenditureDetails(request, response);
				break;
			
			case "5":
				assetDetails(request, response);
				break;
			default:
				listDetails(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
			
		

	}


	private void assetDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//add  Details to request
				request.setAttribute("panchayat_id", panchayat_id);
				request.setAttribute("panchayatName", panchayatName);
						
				//send to JSP
				RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/asset-details.jsp");
				dispatcher.forward(request, response);
		
	}


	private void expenditureDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//add  Details to request
				request.setAttribute("panchayat_id", panchayat_id);
				request.setAttribute("panchayatName", panchayatName);
						
				//send to JSP
				RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/expenditure-details.jsp");
				dispatcher.forward(request, response);
		
	}


	private void incomeDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
		
		//add  Details to request
				request.setAttribute("panchayat_id", panchayat_id);
				request.setAttribute("panchayatName", panchayatName);
						
				//send to JSP
				RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/income-details.jsp");
				dispatcher.forward(request, response);
		
	}


	private void basicDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//add  Details to request
				request.setAttribute("panchayat_id", panchayat_id);
				request.setAttribute("panchayatName", panchayatName);
						
				//send to JSP
				RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/basic-details.jsp");
				dispatcher.forward(request, response);
		
	}


	private void panchDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//add  Details to request
		request.setAttribute("panchayat_id", panchayat_id);
		request.setAttribute("panchayatName", panchayatName);
				
		//send to JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("PanchControllerServlet");
		dispatcher.forward(request, response);
		
	}


	private void listDetails(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		
		List<PanchayatDetail> detailList = new ArrayList<>();
		PanchayatDetail p1=new PanchayatDetail(panchayat_id,1,"Info of Sarpanch and Members");
		detailList.add(p1);
		PanchayatDetail p2=new PanchayatDetail(panchayat_id,2,"Basic Details");
		detailList.add(p2);
		PanchayatDetail p3=new PanchayatDetail(panchayat_id,3,"Income");
		detailList.add(p3);
		PanchayatDetail p4=new PanchayatDetail(panchayat_id,4,"Expenditure");
		detailList.add(p4);
		PanchayatDetail p5=new PanchayatDetail(panchayat_id,5,"Assets Created");
		detailList.add(p5);
		//add  Details to request
		request.setAttribute("Detail_List", detailList);
		request.setAttribute("panchayat_id", panchayat_id);
		request.setAttribute("panchayatName", panchayatName);
		//send to JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat-details.jsp");
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
