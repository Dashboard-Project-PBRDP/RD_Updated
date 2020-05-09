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
	 HttpSession session=null;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("panchayatId")!= null && panchayat_id==0) {
		//set session object
			 session = request.getSession();
			//get selected panchayat value
			System.out.println("+++++++++++++"+request.getParameter("panchayatId"));
			panchayat_id = Integer.parseInt(request.getParameter("panchayatId"));
			panchayatName = request.getParameter("panchayatName");
			session.setAttribute("panchayat_id", panchayat_id);
			session.setAttribute("panchayatName", panchayatName);
			System.out.println("=========panchayat id do get--"+panchayat_id);
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
				propertyDetails(request, response);
				break;
			
			case "4":
				bankAccountDetails(request, response);
				break;
			
			case "5":
				healthEducationDetails(request, response);
				break;
			
			case "6":
				incomeDetails(request, response);
				break;
			case "7":
				expenditureDetails(request, response);
				break;
			case "8":
				assetDetails(request, response);
				break;
			case "9":
				svcDetails(request, response);
				break;
			case "10":
				courtCasesDetails(request, response);
				break;
			case "11":
				auditParasDetails(request, response);
				break;
			case "12":
				illegalPossessionDetails(request, response);
				break;
			case "13":
				customReport(request, response);
				break;
			default:
				listDetails(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
			
		

	}


	private void customReport(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//send to JSP
				RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/custom-report.jsp");
				dispatcher.forward(request, response);
		
	}


	private void illegalPossessionDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//send to JSP
				RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/illegal-possession-details.jsp");
				dispatcher.forward(request, response);
		
	}


	private void auditParasDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//send to JSP
				RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/audit-paras-details.jsp");
				dispatcher.forward(request, response);
		
	}


	private void courtCasesDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//send to JSP
				RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/court-cases-details.jsp");
				dispatcher.forward(request, response);
		
	}


	private void svcDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//send to JSP
				RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/svc-details.jsp");
				dispatcher.forward(request, response);
		
	}


	private void healthEducationDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//send to JSP
				RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/health-education-details.jsp");
				dispatcher.forward(request, response);
		
	}


	private void bankAccountDetails(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//send to JSP
				RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/bank-account-details.jsp");
				dispatcher.forward(request, response);
		
	}


	private void propertyDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//send to JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/property-details.jsp");
		dispatcher.forward(request, response);
		
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
				RequestDispatcher dispatcher = request.getRequestDispatcher("IncomeControllerServlet");
				dispatcher.forward(request, response);
		
	}


	private void basicDetails(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//add  Details to request
				request.setAttribute("panchayat_id", panchayat_id);
				request.setAttribute("panchayatName", panchayatName);
				System.out.println("=========panchayat id basic--"+panchayat_id);

				//send to JSP
				RequestDispatcher dispatcher = request.getRequestDispatcher("BasicControllerServlet");
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
		PanchayatDetail p3=new PanchayatDetail(panchayat_id,3,"Property Details");
		detailList.add(p3);
		PanchayatDetail p4=new PanchayatDetail(panchayat_id,4,"Bank Account Details");
		detailList.add(p4);
		PanchayatDetail p5=new PanchayatDetail(panchayat_id,5,"Health/Education Facilities");
		detailList.add(p5);
		PanchayatDetail p6=new PanchayatDetail(panchayat_id,6,"Income");
		detailList.add(p6);
		PanchayatDetail p7=new PanchayatDetail(panchayat_id,7,"Expenditure");
		detailList.add(p7);
		PanchayatDetail p8=new PanchayatDetail(panchayat_id,8,"Assets Created");
		detailList.add(p8);
		PanchayatDetail p9=new PanchayatDetail(panchayat_id,9,"Smart Village Campaign");
		detailList.add(p9);
		PanchayatDetail p10=new PanchayatDetail(panchayat_id,10,"Pending Court Cases");
		detailList.add(p10);
		PanchayatDetail p11=new PanchayatDetail(panchayat_id,11,"Pending Audit Paras");
		detailList.add(p11);
		PanchayatDetail p12=new PanchayatDetail(panchayat_id,12,"Illegal Possessions");
		detailList.add(p12);
		PanchayatDetail p13=new PanchayatDetail(panchayat_id,13,"Custom Report");
		detailList.add(p13);
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
