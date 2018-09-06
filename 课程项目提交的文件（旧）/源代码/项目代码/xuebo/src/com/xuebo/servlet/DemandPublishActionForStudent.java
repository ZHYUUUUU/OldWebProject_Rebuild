package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Demand;
import com.xuebo.controller.IDemandController;
import com.xuebo.controller.impl.DemandControllerImpl;

/**
 * Servlet implementation class DemandPublishActionForStudent
 */
public class DemandPublishActionForStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IDemandController demandController = new DemandControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DemandPublishActionForStudent() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String studentid = request.getParameter("studentid");
		String demandmeetdate = request.getParameter("exampleInputTime1");
		String demandmeetaddress = request.getParameter("exampleText_1");
		String demandtype = request.getParameter("exampleSelectWay2");
		String demandcontent = request.getParameter("exampleTextarea2");
		
		System.out.println(studentid);
		System.out.println(demandmeetdate);
		System.out.println(demandmeetaddress);
		System.out.println(demandtype);
		System.out.println(demandcontent);
		
		//获取系统时间
		Date systemtime = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");//为了生成预约表的bookid
		String systemtime_str = dateFormat.format(systemtime); 
		String demandid = dateFormat2.format(systemtime);
		System.out.println(systemtime_str); 
		System.out.println(demandid);
		
		if(demandmeetdate.equals("")){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('见面时间不能为空！'); window.location='student_information.jsp' </script>");
			out.flush();
			out.close();
		}else if(!demandmeetdate.equals("")){
			try {
				Date md = dateFormat.parse(demandmeetdate + " 00:00:00");
				if(md.getTime()<systemtime.getTime()){
					PrintWriter out = response.getWriter();
					out.print("<script>alert('预约时间比当前时间早！'); window.location='student_information.jsp' </script>");
					out.flush();
					out.close();
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(demandmeetaddress.equals("")){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('见面地点不能为空！'); window.location='student_information.jsp' </script>");
			out.flush();
			out.close();
		}else if(demandcontent.equals("")){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('需求内容不能为空！'); window.location='student_information.jsp' </script>");
			out.flush();
			out.close();
		}else{
			
			Demand demand = new Demand();
			demand.setDemandid(demandid);
			demand.setStudentid(studentid);
			demand.setDemanddate(systemtime_str);
			demand.setDemandmeetdate(demandmeetdate);
			demand.setDemandmeetaddress(demandmeetaddress);
			demand.setDemandtype(demandtype);
			demand.setDemandcontent(demandcontent);
			demandController.DemandPublishForStudent(demand);
			
			PrintWriter out = response.getWriter();
			out.print("<script>alert('预约成功！'); window.location='PersonalActionForStudent?id=" + studentid + "' </script>");
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
