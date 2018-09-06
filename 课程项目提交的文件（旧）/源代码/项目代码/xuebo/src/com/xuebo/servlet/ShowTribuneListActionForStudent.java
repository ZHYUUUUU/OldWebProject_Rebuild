package com.xuebo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Student;
import com.xuebo.bean.Tribune;
import com.xuebo.controller.IStudentController;
import com.xuebo.controller.ITribuneController;
import com.xuebo.controller.impl.StudentControllerImpl;
import com.xuebo.controller.impl.TribuneControllerImpl;

/**
 * Servlet implementation class ShowTribuneListActionForStudent
 */
public class ShowTribuneListActionForStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ITribuneController tribuneController = new TribuneControllerImpl();
	private IStudentController studentController = new StudentControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTribuneListActionForStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String studentid = request.getParameter("studentid");
		
		Student student = new Student();
		student.setStudentid(studentid);
		Student new_student = new Student();
		new_student = studentController.StudentPersonalForTribune(student);
		
		request.getSession().setAttribute("student", new_student);
		
		Tribune tribune = new Tribune();
		tribune.setStudentid(studentid);
		List<Tribune> tribunes_all = new ArrayList<Tribune>();
		tribunes_all = tribuneController.TribuneListForStudent(tribune);
		
		request.getSession().setAttribute("tribunes1", tribunes_all);
		
		List<Tribune> tribunes_personal = new ArrayList<Tribune>();
		tribunes_personal = tribuneController.TribuneListForStudentPersonal(tribune);
		
		request.getSession().setAttribute("tribunes2", tribunes_personal);
		
		response.sendRedirect("student_theme_tribune.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
