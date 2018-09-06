package com.xuebo.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Article;
import com.xuebo.controller.IArticleController;
import com.xuebo.controller.impl.ArticleControllerImpl;

/**
 * Servlet implementation class ShowArticleReadAction
 */
public class ShowArticleReadAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IArticleController articleController = new ArticleControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowArticleReadAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String articleid = request.getParameter("articleid");
		
		Article article = new Article();
		article.setArticleid(articleid);
		Article new_article = new Article();
		new_article = articleController.ArticleReadForExpert(article);
		
		request.getSession().setAttribute("article", new_article);
		
		response.sendRedirect("article_read.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
