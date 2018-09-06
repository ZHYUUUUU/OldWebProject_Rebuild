package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Article;
import com.xuebo.controller.IArticleController;
import com.xuebo.controller.impl.ArticleControllerImpl;

/**
 * Servlet implementation class DeleteArticleActionForExpert
 */
public class DeleteArticleActionForExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IArticleController articleController = new ArticleControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteArticleActionForExpert() {
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
		System.out.println(articleid);
		
		Article article = new Article();
		article.setArticleid(articleid);
		articleController.ArticleDelete(article);
		
		PrintWriter out = response.getWriter();
		out.print("<script>alert('删除成功！'); window.close(); </script>");
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
