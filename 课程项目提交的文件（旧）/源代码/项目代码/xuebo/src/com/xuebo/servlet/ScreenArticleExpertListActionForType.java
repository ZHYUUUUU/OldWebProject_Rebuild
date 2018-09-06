package com.xuebo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Article;
import com.xuebo.controller.IArticleController;
import com.xuebo.controller.impl.ArticleControllerImpl;

/**
 * Servlet implementation class ScreenArticleExpertListActionForType
 */
public class ScreenArticleExpertListActionForType extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IArticleController articleController = new ArticleControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ScreenArticleExpertListActionForType() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String type = request.getParameter("Type");
		switch(type){
			case "1":
				type = "HTML/CSS";
				break;
			case "2":
				type = "后端开发";
				break;
			case "3":
				type = "服务端";
				break;
			case "4":
				type = "框架";
				break;
		}
		
		Article article = new Article();
		article.setArticletype(type);
		List<Article> articles = new ArrayList<Article>();
		articles = articleController.ArticleScreenTypeListForExpert(article);
		request.getSession().setAttribute("articles", articles);
		
		response.sendRedirect("list_article.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
