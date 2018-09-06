package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Student;
import com.xuebo.controller.IStudentController;
import com.xuebo.controller.impl.StudentControllerImpl;

/**
 * Servlet implementation class UpdatePersonalActionForStudent
 */
public class UpdatePersonalActionForStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IStudentController studentController = new StudentControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePersonalActionForStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String studentid = request.getParameter("id");
		String studentname = request.getParameter("exampleInputname2");
		String studentemail = request.getParameter("exampleInputEmail1");
		String studentphone = request.getParameter("exampleInputTel1");
		String studentintroduce = request.getParameter("exampleTextarea1");
		
		studentname = studentname.equals("") ? null : studentname;
		studentintroduce = studentintroduce.equals("") ? null : studentintroduce;
		
		//修改信息的字符串匹配（正则表达式）
		String regex_email = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";//邮箱
		String regex_phone1 = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";//手机号码格式
		
		if(!studentemail.matches(regex_email)){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('邮箱格式错误！请重新按照步骤进入修改信息界面！'); window.location='student_information.jsp' </script>");
			out.flush();
			out.close();
		}else if(!studentphone.matches(regex_phone1)){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('手机号码格式错误！请重新按照步骤进入修改信息界面！'); window.location='student_information.jsp' </script>");
			out.flush();
			out.close();
		}else{
			Student student = new Student();
			student.setStudentid(studentid);
			student.setStudentname(studentname);
			student.setStudentemail(studentemail);
			student.setStudentphone(studentphone);
			student.setStudentintroduce(studentintroduce);
			
			studentController.StudentUpdatePersonal(student);
			PrintWriter out = response.getWriter();
			out.print("<script>alert('修改成功！'); window.location='PersonalActionForStudent?id=" + studentid +"' </script>");
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
