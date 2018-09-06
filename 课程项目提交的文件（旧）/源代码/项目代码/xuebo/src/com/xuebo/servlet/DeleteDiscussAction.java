package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Discuss;
import com.xuebo.controller.IDiscussController;
import com.xuebo.controller.impl.DiscussControllerImpl;

/**
 * Servlet implementation class DeleteDiscussAction
 */
public class DeleteDiscussAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IDiscussController discussController = new DiscussControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteDiscussAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String discussid = request.getParameter("discussid");
		String tribuneid = request.getParameter("tribuneid");
		
		Discuss discuss = new Discuss();
		discuss.setDiscussid(discussid);
		discussController.DiscussDelete(discuss);
		
		PrintWriter out = response.getWriter();
		out.print("<script>alert('删除评论成功！'); window.location='ShowDiscussViewAction?tribuneid=" + tribuneid + "' </script>");
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
