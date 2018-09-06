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
 * Servlet implementation class ShowFirstmessageAction
 */
public class ShowFirstmessageAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IBookController bookController = new BookControllerImpl();  
	private IExpertController expertController = new ExpertControllerImpl();
	private IArticleController articleController = new ArticleControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowFirstmessageAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String expertid = request.getParameter("id");
		Book book = new Book();
		book.setExpertid(expertid);
		
		Book new_book = new Book();
		new_book = bookController.BookShowExpertForStudent(book);
		
		request.getSession().setAttribute("book", new_book);
		
		Expert expert = new Expert();
		expert.setExpertid(expertid);
		Expert new_expert = new Expert();
		new_expert = expertController.ExpertPersonal(expert);
		
		request.getSession().setAttribute("expert", new_expert);
		
		Article article = new Article();
		article.setExpertid(expertid);
		List<Article> articles = new ArrayList<Article>();
		articles = articleController.ArticleListForStudentExpertMessage(article);
		System.out.println(articles);
		
		request.getSession().setAttribute("articles", articles);
		
		response.sendRedirect("First-message.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
