package com.xuebo.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Expert;
import com.xuebo.bean.Tribune;
import com.xuebo.controller.IExpertController;
import com.xuebo.controller.ITribuneController;
import com.xuebo.controller.impl.ExpertControllerImpl;
import com.xuebo.controller.impl.TribuneControllerImpl;

/**
 * Servlet implementation class ShowTribuneListActionForExpert
 */
public class ShowTribuneListActionForExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ITribuneController tribuneController = new TribuneControllerImpl();
	private IExpertController expertController = new ExpertControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowTribuneListActionForExpert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String expertid = request.getParameter("expertid");
		
		Expert expert = new Expert();
		expert.setExpertid(expertid);
		Expert new_expert = new Expert();
		new_expert = expertController.ExpertPersonalForTritune(expert);
		
		request.getSession().setAttribute("expert", new_expert);
		
		Tribune tribune = new Tribune();
		tribune.setExpertid(expertid);
		List<Tribune> tribunes_all = new ArrayList<Tribune>();
		tribunes_all = tribuneController.TribuneListForExpert(tribune);
		
		request.getSession().setAttribute("tribunes1", tribunes_all);
		
		List<Tribune> tribunes_personal = new ArrayList<Tribune>();
		tribunes_personal = tribuneController.TribuneListForExpertPersonal(tribune);
		
		request.getSession().setAttribute("tribunes2", tribunes_personal);
		
		response.sendRedirect("expert_theme_tribune.jsp");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
