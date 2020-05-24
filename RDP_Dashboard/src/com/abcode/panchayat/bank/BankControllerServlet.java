package com.abcode.panchayat.bank;


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
@WebServlet("/BankControllerServlet")
public class BankControllerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	private BankDBUtil BankDBUtil;
	
	@Resource(name = "jdbc/datamgmt")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
	
		super.init();
		
		//create our property db util
		try {
		BankDBUtil = new BankDBUtil(dataSource);
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
				listBank(request, response);
				break;
				
			case "ADD":
				 addBank(request, response);
				break;
				
			case "LOAD":
				loadBank(request, response);
				break;
				
			case "UPDATE":
				updateBank(request, response);
				break;
			
			case "DELETE":
				deleteBank(request, response);
				break;
				
			default:
				listBank(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
		private void listBank(HttpServletRequest request, HttpServletResponse response) 
				throws Exception {
				
				//get property from dbUtil
				List<Bank> Bank = BankDBUtil.getBankList(panchayat_id);
				//add property to request
				request.setAttribute("Bank_List", Bank);
				//send to JSP
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/bank-details.jsp");
				dispatcher.forward(request, response);
				
			}
		private void updateBank(HttpServletRequest request, HttpServletResponse response) throws Exception {

			// read property info from form data
					int id = Integer.parseInt(request.getParameter("detailsId"));
					String bankName = request.getParameter("bankName");	
					String branch = request.getParameter("branch");	
					String ifscCode = request.getParameter("ifscCode");	
					String accountNumber = request.getParameter("accountNumber");	
					String purpose = request.getParameter("purpose");	
					String currentBalance = request.getParameter("currentBalance");	
					String date = request.getParameter("date");	
					String activeAccount=request.getParameter("activeAccount");
					String openingYear=request.getParameter("openingYear");
					String closingYear = request.getParameter("closingYear");	
					

					 // create a new property object

					Bank theBank =new Bank(id,panchayat_id,bankName,branch,ifscCode,accountNumber,purpose,currentBalance,date,activeAccount,openingYear,closingYear) ;
					// perform update on database
					BankDBUtil.updateBank(theBank,panchayat_id);
					
					// send them back to the "list property" page
					listBank(request, response);
			
		}



		private void loadBank(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
					// read property id from form data
					int theBankId = Integer.parseInt(request.getParameter("detailsId"));					 
					// get property from database
					Bank theBank = BankDBUtil.getBank(theBankId,panchayat_id);
					
					// place property in the request attribute
					request.setAttribute("The_Bank", theBank);
					// send to jsp page: update-property-form.jsp
					RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/update-bank-form.jsp");
					dispatcher.forward(request, response);
			
		}
		private void addBank(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			// read property info from form data
			String bankName = request.getParameter("bankName");	
			String branch = request.getParameter("branch");	
			String ifscCode = request.getParameter("ifscCode");	
			String accountNumber = request.getParameter("accountNumber");	
			String purpose = request.getParameter("purpose");	
			String currentBalance = request.getParameter("currentBalance");	
			String date = request.getParameter("date");	
			String activeAccount=request.getParameter("activeAccount");
			String openingYear=request.getParameter("openingYear");
			String closingYear = request.getParameter("closingYear");	
						// add the bank to the database
					BankDBUtil.addBank(bankName,branch,ifscCode,accountNumber,purpose,currentBalance,date,activeAccount,openingYear,closingYear,panchayat_id);
					
					listBank(request, response);

			
		}
		

		private void deleteBank(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			// read property id from form data
					String theBankId = request.getParameter("detailsId");
					// delete property from database
					BankDBUtil.deleteBank(theBankId);
					
					// send them back to "list property" page
					listBank(request, response);
					
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
