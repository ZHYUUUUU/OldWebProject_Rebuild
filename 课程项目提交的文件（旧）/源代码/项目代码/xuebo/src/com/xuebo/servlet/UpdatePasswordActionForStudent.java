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
 * Servlet implementation class UpdatePasswordActionForStudent
 */
public class UpdatePasswordActionForStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IStudentController studentController = new StudentControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordActionForStudent() {
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
		String studentoldpassword = request.getParameter("exampleInputPassword1");
		String studentnewpassword = request.getParameter("exampleInputPassword2");
		String studentnewpassword_again = request.getParameter("exampleInputPassword3");
		
		//密码格式（正则表达式）
		String regex_pwd = "^[0-9A-Za-z]{6,16}$";//密码：大小写字母和数字，6-16位
		
		if(!studentoldpassword.matches(regex_pwd) || !studentnewpassword.matches(regex_pwd) || !studentnewpassword_again.matches(regex_pwd)){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('密码格式错误！（6-16位大小写字母和数字）'); window.location='student_information.jsp' </script>");
			out.flush();
			out.close();
		}else if(!studentnewpassword.equals(studentnewpassword_again)){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('新密码与确认新密码不一致！'); window.location='student_information.jsp' </script>");
			out.flush();
			out.close();
		}else{
			
			Student student = new Student();
			student.setStudentid(studentid);
			student.setStudentpassword(studentoldpassword);
			student.setNewpassword(studentnewpassword);
			int update = studentController.StudentUpdatePassword(student);
			if(update == -1){
				PrintWriter out = response.getWriter();
				out.print("<script>alert('原密码错误！'); window.location='student_information.jsp' </script>");
				out.flush();
				out.close();
			}else{
				PrintWriter out = response.getWriter();
				out.print("<script>alert('修改成功！'); window.location='PersonalActionForStudent?id=" + studentid +"' </script>");
				out.flush();
				out.close();
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
