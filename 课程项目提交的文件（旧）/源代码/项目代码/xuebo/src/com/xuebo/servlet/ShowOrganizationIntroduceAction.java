package com.xuebo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Organization;
import com.xuebo.controller.IOrganizationController;
import com.xuebo.controller.impl.OrganizationControllerImpl;

/**
 * Servlet implementation class ShowOrganizationIntroduceAction
 */
public class ShowOrganizationIntroduceAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IOrganizationController organizationController = new OrganizationControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowOrganizationIntroduceAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String organizationid = request.getParameter("organizationid");
		
		Organization organ = new Organization();
		organ.setOrganizationid(organizationid);
		Organization new_organ = new Organization();
		new_organ = organizationController.OrganizationShowIntroduce(organ);
		
		request.getSession().setAttribute("organ", new_organ);
		
		response.sendRedirect("education_organization_introduce.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
