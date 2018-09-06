package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Article;
import com.xuebo.controller.IArticleController;
import com.xuebo.controller.impl.ArticleControllerImpl;

/**
 * Servlet implementation class ArticlePublishActionForExpert
 */
public class ArticlePublishActionForExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IArticleController articleController = new ArticleControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ArticlePublishActionForExpert() {
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
		String articletitle = request.getParameter("exampleInputText1");
		String articletype = request.getParameter("exampleSelectWay2");
		String articlecontent = request.getParameter("exampleInputTextarea1");
		
		//获取系统时间
		Date systemtime = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");//为了生成预约表的bookid
		String systemtime_str = dateFormat.format(systemtime); 
		String articleid = dateFormat2.format(systemtime);
		System.out.println(systemtime_str); 
		System.out.println(articleid);
		System.out.println(expertid);
		System.out.println(articletitle);
		System.out.println(articletype);
		System.out.println(articlecontent);
		
		if(articletitle.equals("")){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('文章标题不能为空！'); window.location='article_write.jsp' </script>");
			out.flush();
			out.close();
		}else if(articlecontent.equals("")){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('文章内容不能为空！'); window.location='article_write.jsp' </script>");
			out.flush();
			out.close();
		}else{
			
			Article article = new Article();
			article.setArticleid(articleid);
			article.setExpertid(expertid);
			article.setPublishdate(systemtime_str);
			article.setArticletitle(articletitle);
			article.setArticletype(articletype);
			article.setArticlecontent(articlecontent);
			articleController.ArticlePublish(article);
			
			PrintWriter out = response.getWriter();
			out.print("<script>alert('文章发布成功！'); window.close(); </script>");
			out.flush();
			out.close();
			
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
