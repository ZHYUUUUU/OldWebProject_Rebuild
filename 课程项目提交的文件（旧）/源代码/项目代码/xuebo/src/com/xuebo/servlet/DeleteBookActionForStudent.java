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
 * Servlet implementation class DeleteBookActionForStudent
 */
public class DeleteBookActionForStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IBookController bookController = new BookControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteBookActionForStudent() {
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
		System.out.println(bookid);
		
		Book book = new Book();
		book.setBookid(bookid);
		bookController.BookCancelForStudent(book);
		
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
