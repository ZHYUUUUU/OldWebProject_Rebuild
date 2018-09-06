package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Demand;
import com.xuebo.controller.IDemandController;
import com.xuebo.controller.impl.DemandControllerImpl;

/**
 * Servlet implementation class DeleteDemandActionForStudent
 */
public class DeleteDemandActionForStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private IDemandController demandController = new DemandControllerImpl();   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDemandActionForStudent() {
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
		String studentid = request.getParameter("studentid");
		
		System.out.println(demandid);
		System.out.println(studentid);
		
		Demand demand = new Demand();
		demand.setDemandid(demandid);
		demandController.DemandDeleteForStudent(demand);
		
		PrintWriter out = response.getWriter();
		out.print("<script>alert('删除预约成功！'); window.location='PersonalActionForStudent?id=" + studentid + "' </script>");
		out.flush();
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
