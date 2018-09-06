package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

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
 * Servlet implementation class CreateTribuneActionForExpert
 */
public class CreateTribuneActionForExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private ITribuneController tribuneController = new TribuneControllerImpl();
	private IExpertController expertController = new ExpertControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateTribuneActionForExpert() {
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
		String tribunetitle = request.getParameter("exampleInputname2");
		String tribunetheme = request.getParameter("exampleInputEmail1");
		String tribunecontent = request.getParameter("exampleTextarea1");
		
		//获取系统时间
		Date systemtime = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");//为了生成预约表的bookid
		String systemtime_str = dateFormat.format(systemtime); 
		String tribuneid = dateFormat2.format(systemtime);
		System.out.println(systemtime_str); 
		System.out.println(tribuneid);
		
		if(tribunetitle.equals("")){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('论坛标题不能为空！'); window.location='expert_theme_tribune.jsp' </script>");
			out.flush();
			out.close();
		}else if(tribunetheme.equals("")){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('论坛主题不能为空！'); window.location='expert_theme_tribune.jsp' </script>");
			out.flush();
			out.close();
		}else if(tribunecontent.equals("")){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('论坛内容不能为空！'); window.location='expert_theme_tribune.jsp' </script>");
			out.flush();
			out.close();
		}else{
			Expert expert = new Expert();
			expert.setExpertid(expertid);
			Expert new_expert = new Expert();
			new_expert = expertController.ExpertPersonalForTritune(expert);
			
			Tribune tribune = new Tribune();
			tribune.setTribuneid(tribuneid);
			tribune.setCreator(new_expert.getExpertname());
			tribune.setExpertid(expertid);
			tribune.setCreatedate(systemtime_str);
			tribune.setTribunetitle(tribunetitle);
			tribune.setTribunetheme(tribunetheme);
			tribune.setTribunecontent(tribunecontent);
			tribuneController.TribuneCreateForExpert(tribune);
			
			PrintWriter out = response.getWriter();
			out.print("<script>alert('创建论坛成功！'); window.location='ShowTribuneListActionForExpert?expertid=" + expertid + "' </script>");
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
