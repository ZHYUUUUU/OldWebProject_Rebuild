package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Expert;
import com.xuebo.controller.IExpertController;
import com.xuebo.controller.impl.ExpertControllerImpl;

/**
 * Servlet implementation class UpdatePersonalActionForExpert
 */
public class UpdatePersonalActionForExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IExpertController expertController = new ExpertControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePersonalActionForExpert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String expertid = request.getParameter("id");//通过cookie获取用户id
		String expertname = request.getParameter("exampleInputname1");
		String expertintroduce = request.getParameter("exampleTextarea1");
		String expertresearch = request.getParameter("exampleText1");
		String experttype = request.getParameter("experttype");
		int expertprice = Integer.parseInt(request.getParameter("exampleText3"));
		String expertemail = request.getParameter("exampleInputEmail1");
		String expertphone = request.getParameter("exampleInputTel1");
		String expertoccupation = request.getParameter("exampleInputoccupation1");
		String expertaddress = request.getParameter("exampleInputadd1");
		
		expertname = expertname.equals("") ? null : expertname;
		expertintroduce = expertintroduce.equals("") ? null : expertintroduce;
		expertresearch = expertresearch.equals("") ? null : expertresearch;
		expertoccupation = expertoccupation.equals("") ? null : expertoccupation;
		expertaddress = expertaddress.equals("") ? null : expertaddress;
		
		//注册信息的字符串匹配（正则表达式）
		String regex_email = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";//邮箱
		String regex_phone1 = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";//手机号码格式
		
		if(!expertemail.matches(regex_email)){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('邮箱格式错误！请重新按照步骤进入修改信息界面！'); window.location='index.jsp' </script>");
			out.flush();
			out.close();
		}else if(!expertphone.matches(regex_phone1)){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('手机号码格式错误！请重新按照步骤进入修改信息界面！'); window.location='index.jsp' </script>");
			out.flush();
			out.close();
		}else{
			
			Expert expert = new Expert(expertid,expertname,expertintroduce,expertresearch,experttype,expertprice,expertemail,expertphone,expertoccupation,expertaddress);
			expertController.ExpertUpdatePersonal(expert);
			PrintWriter out = response.getWriter();
			out.print("<script>alert('修改成功！'); window.location='PersonalActionForExpert?id=" + expertid +"' </script>");
			out.flush();
			out.close();
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
