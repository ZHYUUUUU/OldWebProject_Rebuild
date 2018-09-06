package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Expert;
import com.xuebo.bean.Organization;
import com.xuebo.controller.IExpertController;
import com.xuebo.controller.IOrganizationController;
import com.xuebo.controller.impl.ExpertControllerImpl;
import com.xuebo.controller.impl.OrganizationControllerImpl;

/**
 * Servlet implementation class ResearchActionInHomepage
 */
public class ResearchActionInHomepage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IExpertController expertController = new ExpertControllerImpl();
	private IOrganizationController organizationController = new OrganizationControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResearchActionInHomepage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String researchText = request.getParameter("researchText");
		String researchType = request.getParameter("researchHomepage");
		String type = request.getParameter("type");
		int type_int = Integer.parseInt(type);
		
		System.out.println(researchText);
		System.out.println(researchType);
		System.out.println(type);
		System.out.println(type_int);
		
		if(type_int == 0){//在学员主页操作时（homepage.jsp）
			
			if(researchType.equals("专家")){
				
				Expert expert = new Expert();
				expert.setExpertname(researchText);
				Expert new_expert = expertController.ExpertResearch(expert);
				System.out.println(new_expert);
				int success = new_expert.getStatecode();
				if(success == -1){
					PrintWriter out = response.getWriter();
					out.print("<script>alert('查无此专家！（注意：请输入专家的全名，否则有可能匹配出错~）'); window.location='homepage.jsp' </script>");
					out.flush();
					out.close();
				}else{
					String id = new_expert.getExpertid();
					response.sendRedirect("ShowFirstmessageAction?id=" + id);
				}
				
			}else if(researchType.equals("机构")){
				
				Organization organ = new Organization();
				organ.setOrganizationname(researchText);
				Organization new_organ = organizationController.OrganizationResearch(organ);
				int success = new_organ.getStatecode();
				System.out.println(success);
				if(success == -1){
					PrintWriter out = response.getWriter();
					out.print("<script>alert('查无此机构！（注意：请输入机构的全名或简名，否则有可能匹配出错~）'); window.location='homepage.jsp' </script>");
					out.flush();
					out.close();
				}else{
					String id = new_organ.getOrganizationid();
					response.sendRedirect("ShowOrganizationIntroduceAction?organizationid=" + id);
				}
				
			}
			
		}else if(type_int == 1){//在专家主页操作时（expert_homepage.jsp）
			
			if(researchType.equals("专家")){
				
				Expert expert = new Expert();
				expert.setExpertname(researchText);
				Expert new_expert = expertController.ExpertResearch(expert);
				System.out.println(new_expert);
				int success = new_expert.getStatecode();
				if(success == -1){
					PrintWriter out = response.getWriter();
					out.print("<script>alert('查无此专家！（注意：请输入专家的全名，否则有可能匹配出错~）'); window.location='expert_homepage.jsp' </script>");
					out.flush();
					out.close();
				}else{
					String id = new_expert.getExpertid();
					response.sendRedirect("ShowFirstmessageAction?id=" + id);
				}
				
			}else if(researchType.equals("机构")){
				
				Organization organ = new Organization();
				organ.setOrganizationname(researchText);
				Organization new_organ = organizationController.OrganizationResearch(organ);
				int success = new_organ.getStatecode();
				System.out.println(success);
				if(success == -1){
					PrintWriter out = response.getWriter();
					out.print("<script>alert('查无此机构！（注意：请输入机构的全名或简名，否则有可能匹配出错~）'); window.location='expert_homepage.jsp' </script>");
					out.flush();
					out.close();
				}else{
					String id = new_organ.getOrganizationid();
					response.sendRedirect("ShowOrganizationIntroduceAction?organizationid=" + id);
				}
				
			}
			
		}
		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
