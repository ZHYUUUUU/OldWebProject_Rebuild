package com.xuebo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Organization;
import com.xuebo.controller.IOrganizationController;
import com.xuebo.controller.impl.OrganizationControllerImpl;

/**
 * Servlet implementation class ShowOrganizationViewAction
 */
public class ShowOrganizationViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IOrganizationController organizationController = new OrganizationControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrganizationViewAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		List<Organization> organs = new ArrayList<Organization>();
		organs = organizationController.OrganizationShowView();
		
		request.getSession().setAttribute("organs", organs);
		
		response.sendRedirect("education_organization.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
