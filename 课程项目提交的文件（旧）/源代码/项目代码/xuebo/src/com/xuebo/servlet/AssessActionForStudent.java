package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Book;
import com.xuebo.controller.IBookController;
import com.xuebo.controller.impl.BookControllerImpl;

/**
 * Servlet implementation class AssessActionForStudent
 */
public class AssessActionForStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IBookController bookController = new BookControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssessActionForStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String bookid = request.getParameter("bookid");
		String studentid = request.getParameter("studentid");
		String bookassess = request.getParameter("student_option");
		
		System.out.println(bookid);
		System.out.println(studentid);
		System.out.println(bookassess);
		
		Book book = new Book();
		book.setBookid(bookid);
		book.setBookassess(Integer.parseInt(bookassess));
		bookController.BookAssessForStudent(book);
		
		PrintWriter out = response.getWriter();
		out.print("<script>alert('评分成功！'); window.location='PersonalActionForStudent?id=" + studentid +"' </script>");
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
