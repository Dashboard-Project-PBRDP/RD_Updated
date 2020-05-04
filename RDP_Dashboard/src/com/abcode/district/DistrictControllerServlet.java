package com.abcode.district;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/DistrictControllerServlet")
public class DistrictControllerServlet extends HttpServlet {
private static final long serialVersionUID = 1L;

	
	private DbUtil DbUtil;
	
	@Resource(name = "jdbc/datamgmt")
	private DataSource dataSource;
	
	
	@Override
	public void init() throws ServletException {
	
		super.init();
		
		//create our District db util
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
		try {
	
		listDistricts(request, response);
		}
		catch (Exception e) {
			throw new ServletException(e);
		}
	}



	private void listDistricts(HttpServletRequest request, HttpServletResponse response) 
		throws Exception {
		
		List<District> District = DbUtil.getDistrict();
		
		//add Districts to request
		request.setAttribute("District_List", District);
		
		//send to JSP
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-Districts.jsp");
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
