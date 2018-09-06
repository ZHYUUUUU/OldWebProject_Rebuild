package com.xuebo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Demand;
import com.xuebo.controller.IDemandController;
import com.xuebo.controller.impl.DemandControllerImpl;

/**
 * Servlet implementation class ShowDemandListActionForExpert
 */
public class ShowDemandListActionForExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IDemandController demandController = new DemandControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDemandListActionForExpert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		List<Demand> demands = new ArrayList<Demand>();
		demands = demandController.DemandListForExpert();
		
		request.getSession().setAttribute("demands", demands);
		
		response.sendRedirect("student_demand.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
