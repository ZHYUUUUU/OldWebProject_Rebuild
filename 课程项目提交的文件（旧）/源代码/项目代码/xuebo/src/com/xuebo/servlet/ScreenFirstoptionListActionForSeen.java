package com.xuebo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Book;
import com.xuebo.controller.IBookController;
import com.xuebo.controller.impl.BookControllerImpl;

/**
 * Servlet implementation class ScreenFirstoptionListActionForSeen
 */
public class ScreenFirstoptionListActionForSeen extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IBookController bookController = new BookControllerImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScreenFirstoptionListActionForSeen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		List<Book> books = new ArrayList<Book>();
		books = bookController.BookScreenSeenExpertListForStudent();
		
		request.getSession().setAttribute("books", books);
		
		response.sendRedirect("Firstoption.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
