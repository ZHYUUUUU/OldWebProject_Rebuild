package com.xuebo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Article;
import com.xuebo.bean.Book;
import com.xuebo.bean.Expert;
import com.xuebo.controller.IArticleController;
import com.xuebo.controller.IBookController;
import com.xuebo.controller.IExpertController;
import com.xuebo.controller.impl.ArticleControllerImpl;
import com.xuebo.controller.impl.BookControllerImpl;
import com.xuebo.controller.impl.ExpertControllerImpl;

/**
 * Servlet implementation class PersonalActionForExpert
 */
public class PersonalActionForExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IExpertController expertController = new ExpertControllerImpl();
	private IBookController bookController = new BookControllerImpl();
	private IArticleController articleController = new ArticleControllerImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PersonalActionForExpert() {
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
		
		Expert expert = new Expert();
		expert.setExpertid(userid);
		Expert new_expert = expertController.ExpertPersonal(expert);
		
		System.out.println("expertname:" + new_expert.getExpertname());
		
		request.getSession().setAttribute("expert", new_expert);
		
		Book book = new Book();
		book.setExpertid(userid);
		List<Book> books = new ArrayList<Book>();
		books = bookController.BookListForExpert(book);
		request.getSession().setAttribute("books", books);
		
		Article article = new Article();
		article.setExpertid(userid);
		List<Article> articles = new ArrayList<Article>();
		articles = articleController.ArticleListForExpertPersonal(article);
		request.getSession().setAttribute("articles", articles);
		
		response.sendRedirect("index.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
