package com.xuebo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Book;
import com.xuebo.bean.Demand;
import com.xuebo.bean.Student;
import com.xuebo.controller.IBookController;
import com.xuebo.controller.IStudentController;
import com.xuebo.controller.impl.BookControllerImpl;
import com.xuebo.controller.impl.DemandControllerImpl;
import com.xuebo.controller.impl.StudentControllerImpl;
import com.xuebo.controller.IDemandController;;

/**
 * Servlet implementation class PersonalActionForStudent
 */
public class PersonalActionForStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IStudentController studentController = new StudentControllerImpl();
	private IBookController bookController = new BookControllerImpl();
	private IDemandController demandController = new DemandControllerImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalActionForStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String userid = request.getParameter("id");
		
		System.out.println(userid);
		
		Student student = new Student();
		student.setStudentid(userid);
		Student new_student = studentController.StudentPersonal(student);
		
		request.getSession().setAttribute("student", new_student);
		
		Book book = new Book();
		book.setStudentid(userid);
		List<Book> books = new ArrayList<Book>();
		books = bookController.BookListForStudent(book);
		
		request.getSession().setAttribute("books", books);
		
		Demand demand = new Demand();
		demand.setStudentid(userid);
		List<Demand> demands = new ArrayList<Demand>();
		demands = demandController.DemandListForStudent(demand);
		
		request.getSession().setAttribute("demands", demands);
		
		response.sendRedirect("student_information.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
