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

import com.xuebo.bean.Book;
import com.xuebo.controller.IBookController;
import com.xuebo.controller.impl.BookControllerImpl;

/**
 * Servlet implementation class BookActionForStudent
 */
public class BookActionForStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IBookController bookController = new BookControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookActionForStudent() {
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
		String studentid = request.getParameter("studentid");
		String meetdate = request.getParameter("exampleInputDate1");
		String meetaddress = request.getParameter("exampleInputAddress1");
		String bookintroduce = request.getParameter("exampleInputContent1");
		
		System.out.println(expertid);
		System.out.println(studentid);
		System.out.println(meetdate);
		System.out.println(meetaddress);
		System.out.println(bookintroduce);
		
		//获取系统时间
		Date systemtime = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");//为了生成预约表的bookid
		String systemtime_str = dateFormat.format(systemtime); 
		String bookid = dateFormat2.format(systemtime);
		System.out.println(systemtime_str); 
		System.out.println(bookid);
		
		if(meetdate.equals("")){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('见面时间不能为空！'); window.location='First-message.jsp' </script>");
			out.flush();
			out.close();
		}else if(!meetdate.equals("")){
			try {
				Date md = dateFormat.parse(meetdate + " 00:00:00");
				if(md.getTime()<systemtime.getTime()){
					PrintWriter out = response.getWriter();
					out.print("<script>alert('预约时间比当前时间早！'); window.location='First-message.jsp' </script>");
					out.flush();
					out.close();
				}
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		if(meetaddress.equals("")){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('见面地点不能为空！'); window.location='First-message.jsp' </script>");
			out.flush();
			out.close();
		}else if(bookintroduce.equals("")){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('上课内容不能为空！'); window.location='First-message.jsp' </script>");
			out.flush();
			out.close();
		}else{
			
			Book book = new Book();
			book.setBookid(bookid);
			book.setExpertid(expertid);
			book.setStudentid(studentid);
			book.setBookdate(systemtime_str);
			book.setMeetdate(meetdate);
			book.setMeetaddress(meetaddress);
			book.setBookstate(2);
			book.setBookintroduce(bookintroduce);
			bookController.BookForStudent(book);
			
			PrintWriter out = response.getWriter();
			out.print("<script>alert('预约成功！'); window.location='ShowFirstmessageAction?id=" + expertid + "' </script>");
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
