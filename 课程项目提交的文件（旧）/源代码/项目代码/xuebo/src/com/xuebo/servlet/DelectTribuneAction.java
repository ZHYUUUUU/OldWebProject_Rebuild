package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Tribune;
import com.xuebo.controller.ITribuneController;
import com.xuebo.controller.impl.TribuneControllerImpl;

/**
 * Servlet implementation class DelectTribuneAction
 */
public class DelectTribuneAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ITribuneController tribuneController = new TribuneControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DelectTribuneAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String tribuneid = request.getParameter("tribuneid");
		String id = request.getParameter("id");
		String creatorstate = request.getParameter("creatorstate");
		
		System.out.println(tribuneid);
		System.out.println(id);
		System.out.println(creatorstate);
		
		Tribune tribune = new Tribune();
		tribune.setTribuneid(tribuneid);
		tribuneController.TribuneDelete(tribune);
		
		if(creatorstate.equals("0")){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除论坛成功！'); window.location='ShowTribuneListActionForStudent?studentid=" + id + "' </script>");
			out.flush();
			out.close();
		}else if(creatorstate.equals("1")){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('删除论坛成功！'); window.location='ShowTribuneListActionForExpert?expertid=" + id + "' </script>");
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
