package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Book;
import com.xuebo.controller.IBookController;
import com.xuebo.controller.impl.BookControllerImpl;

/**
 * Servlet implementation class AcceptBookActionForExpert
 */
public class AcceptBookActionForExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IBookController bookController = new BookControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AcceptBookActionForExpert() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String bookid = request.getParameter("bookid");
		String expertid = request.getParameter("expertid");
		String bookintroduce = request.getParameter("exampleInputContent1");
		String not_accept = request.getParameter("_ipAddress");
		String accept_option = request.getParameter("expert_option");
		
		String accept_str = null;
		Book book = new Book();
		
		System.out.println(bookid);
		System.out.println(expertid);
		System.out.println(bookintroduce);
		System.out.println(not_accept);
		System.out.println(accept_option);
		
		if(accept_option.equals("1")){//接受预约时
			
			accept_str = "接受";
			book.setBookid(bookid);
			book.setBookintroduce(bookintroduce);
			book.setBookstate(1);
			
		}else if(accept_option.equals("2")){//拒绝预约时
			
			accept_str = "拒绝";
			book.setBookid(bookid);
			book.setBookintroduce(bookintroduce + "（" + not_accept + "）");//上课内容框内格式：上课内容（拒绝预约理由）
			book.setBookstate(0);
			
		}
		
		bookController.BookAcceptForExpert(book);
		
		PrintWriter out = response.getWriter();
		out.print("<script>alert('接受预约操作成功！（状态：" + accept_str + "）'); window.location='PersonalActionForExpert?id=" + expertid + "' </script>");
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
