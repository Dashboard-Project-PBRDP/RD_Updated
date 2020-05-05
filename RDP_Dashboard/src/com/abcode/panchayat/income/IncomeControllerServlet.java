package com.abcode.panchayat.income;

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
@WebServlet("/IncomeControllerServlet")
public class IncomeControllerServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
    
	private IncomeDBUtil IncomeDBUtil;
	
	@Resource(name = "jdbc/datamgmt")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
	
		super.init();
		
		//create our income db util
		try {
		IncomeDBUtil = new IncomeDBUtil(dataSource);
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
				listIncome(request, response);
				break;
				
			case "ADD":
				addIncome(request, response);
				break;
				
			case "LOAD":
				loadIncome(request, response);
				break;
				
			case "UPDATE":
				updateIncome(request, response);
				break;
			
			case "DELETE":
				deleteIncome(request, response);
				break;
			case "INCSOURCE":
				getIncomeSource(request, response);
				break;
				
			default:
				listIncome(request, response);
			}
				
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
		private void listIncome(HttpServletRequest request, HttpServletResponse response) 
				throws Exception {
				
				//get income from dbUtil
				List<Income> Income = IncomeDBUtil.getIncomeList(panchayat_id);
				
				//add list of income to request
				request.setAttribute("Income_List", Income);
				
				//send back selected income
				
				//send to JSP
				RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/income-details.jsp");
				dispatcher.forward(request, response);
				
			}
		private void updateIncome(HttpServletRequest request, HttpServletResponse response) throws Exception {

			// read income info from form data
					int theIncomeId = Integer.parseInt(request.getParameter("detailsId"));
					String year = request.getParameter("year");		
					String month = request.getParameter("month");
					String openingBalance = request.getParameter("openingBalance");
					String incomeType = request.getParameter("incomeType");
					String incomeSource = request.getParameter("incomeSource");
					String amount = request.getParameter("amount");
					String purpose = request.getParameter("purpose");
					String bankAccount = request.getParameter("bankAccount");
					String sanctionno = request.getParameter("sanctionno");
					String sanctiondate = request.getParameter("sanctiondate");
					String ucStatus = request.getParameter("ucStatus");
					 // create a new income object

					Income theIncome =new Income(theIncomeId,year,month,openingBalance,incomeType,incomeSource,amount,purpose,bankAccount,sanctionno,sanctiondate,ucStatus);
					// perform update on database
					IncomeDBUtil.updateIncome(theIncome,panchayat_id);
					
					// send them back to the "list income" page
					listIncome(request, response);
			
		}



		private void loadIncome(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			// read income id from form data
					int theIncomeId = Integer.parseInt(request.getParameter("detailsId"));
					 
					 
					// get income from database (db util)
					Income theIncome = IncomeDBUtil.getIncome(theIncomeId,panchayat_id);
					
					// place income in the request attribute
					request.setAttribute("The_Income", theIncome);
					// send to jsp page: update-income-form.jsp
					RequestDispatcher dispatcher = request.getRequestDispatcher("/panchayat/update-income-form.jsp");
					dispatcher.forward(request, response);
			
		}
		private void getIncomeSource(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
			
			//call dbutil to obtain all income sources
			List<Income> incomeSources = IncomeDBUtil.getIncomeSource();
					
					//add income source to request
					request.setAttribute("IncomeSource", incomeSources);
					
					//send back selected add form
					
					//send to JSP
					RequestDispatcher dispatcher = request.getRequestDispatcher("/add-income-form.jsp");
					dispatcher.forward(request, response);
		}
		private void addIncome(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			// read income info from form data
					String year = request.getParameter("year");		
					String month = request.getParameter("month");
					String openingBalance = request.getParameter("openingBalance");
					String incomeType = request.getParameter("incomeType");
					int incomeSource = Integer.parseInt(request.getParameter("incomeSource"));
					String amount = request.getParameter("amount");
					String purpose = request.getParameter("purpose");
					String bankAccount = request.getParameter("bankAccount");
					String sanctionno = request.getParameter("sanctionno");
					String sanctiondate = request.getParameter("sanctiondate");
					String ucStatus = request.getParameter("ucStatus");
						// add the Panch to the database
					IncomeDBUtil.addIncome(year,month,openingBalance,incomeType,incomeSource,amount,purpose,bankAccount,sanctionno,sanctiondate,ucStatus,panchayat_id);
							
					// send back to main page (the Panch list)
					listIncome(request, response);

			
		}
		

		private void deleteIncome(HttpServletRequest request, HttpServletResponse response) throws Exception {
			
			// read income id from form data
					String theIncomeId = request.getParameter("detailsId");
					
					// delete income from database
					IncomeDBUtil.deleteIncome(theIncomeId);
					
					// send them back to "list income" page
					listIncome(request, response);
					
					RequestDispatcher dispatcher = request.getRequestDispatcher("/error-income.jsp");
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
