package com.xuebo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Demand;
import com.xuebo.controller.IDemandController;
import com.xuebo.controller.impl.DemandControllerImpl;

/**
 * Servlet implementation class ShowStudentDemandReadAction
 */
public class ShowStudentDemandReadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IDemandController demandController = new DemandControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudentDemandReadAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String demandid = request.getParameter("demandid");
		System.out.println(demandid);
		
		Demand demand = new Demand();
		demand.setDemandid(demandid);
		Demand new_demand = new Demand();
		new_demand = demandController.DemandRead(demand);
		
		request.getSession().setAttribute("demand", new_demand);
		
		response.sendRedirect("student_demand_read.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
