package com.xuebo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Discuss;
import com.xuebo.bean.Tribune;
import com.xuebo.controller.IDiscussController;
import com.xuebo.controller.ITribuneController;
import com.xuebo.controller.impl.DiscussControllerImpl;
import com.xuebo.controller.impl.TribuneControllerImpl;

/**
 * Servlet implementation class ShowDiscussViewAction
 */
public class ShowDiscussViewAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ITribuneController tribuneController = new TribuneControllerImpl();
	private IDiscussController discussController = new DiscussControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowDiscussViewAction() {
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
		
		Tribune tribune = new Tribune();
		tribune.setTribuneid(tribuneid);
		Tribune new_tribune = new Tribune();
		new_tribune = tribuneController.TribuneView(tribune);
		
		request.getSession().setAttribute("tribune", new_tribune);
		
		Discuss discuss = new Discuss();
		discuss.setTribuneid(tribuneid);
		List<Discuss> discusses = new ArrayList<Discuss>();
		discusses = discussController.DiscussShowView(discuss);
		
		System.out.println(discusses);
		request.getSession().setAttribute("discusses", discusses);
		
		response.sendRedirect("theme_tribune_discuss.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
