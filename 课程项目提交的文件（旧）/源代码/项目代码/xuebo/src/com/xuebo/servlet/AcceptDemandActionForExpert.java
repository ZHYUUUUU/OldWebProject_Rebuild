package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Book;
import com.xuebo.bean.Demand;
import com.xuebo.controller.IDemandController;
import com.xuebo.controller.IBookController;
import com.xuebo.controller.impl.BookControllerImpl;
import com.xuebo.controller.impl.DemandControllerImpl;

/**
 * Servlet implementation class AcceptDemandActionForExpert
 */
public class AcceptDemandActionForExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IDemandController demandController = new DemandControllerImpl();
	private IBookController bookController = new BookControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptDemandActionForExpert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String demandid = request.getParameter("demandid");
		String expertid = request.getParameter("expertid");
		String studentid = request.getParameter("studentid");
		String demanddate = request.getParameter("demanddate");
		String demandmeetdate = request.getParameter("demandmeetdate");
		String demandmeetaddress = request.getParameter("demandmeetaddress");
		String demandcontent = request.getParameter("demandcontent");
		
		//获取系统时间
		Date systemtime = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");//为了生成预约表的bookid
		String systemtime_str = dateFormat.format(systemtime); 
		String bookid = dateFormat2.format(systemtime);
		System.out.println(systemtime_str); 
		System.out.println(bookid);
		System.out.println(demandid);
		System.out.println(expertid);
		System.out.println(studentid);
		System.out.println(demandmeetdate);
		System.out.println(demandmeetaddress);
		System.out.println(demandcontent);
		
		//将需求表状态位改为已接受（0->1）
		Demand demand = new Demand();
		demand.setBookid(bookid);
		demand.setDemandid(demandid);
		demandController.DemandAccept(demand);
		
		//添加一条预约
		Book book = new Book();
		book.setBookid(bookid);
		book.setExpertid(expertid);
		book.setStudentid(studentid);
		book.setBookdate(systemtime_str);
		book.setMeetdate(demandmeetdate);
		book.setMeetaddress(demandmeetaddress);
		book.setBookstate(1);//置为已接受
		book.setBookintroduce("【需求发布时间：" + demanddate + "】" + demandcontent);
		bookController.BookForStudent(book);
		
		PrintWriter out = response.getWriter();
		out.print("<script>alert('预约成功！'); window.close(); </script>");
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
