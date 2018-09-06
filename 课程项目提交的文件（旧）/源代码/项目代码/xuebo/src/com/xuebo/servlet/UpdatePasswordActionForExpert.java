package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Expert;
import com.xuebo.controller.IExpertController;
import com.xuebo.controller.impl.ExpertControllerImpl;

/**
 * Servlet implementation class UpdatePasswordActionForExpert
 */
public class UpdatePasswordActionForExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IExpertController expertController = new ExpertControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePasswordActionForExpert() {
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
		String expertoldpassword = request.getParameter("exampleInputPassword1");
		String expertnewpassword = request.getParameter("exampleInputPassword2");
		String expertnewpassword_again = request.getParameter("exampleInputPassword3");
		
		//密码格式（正则表达式）
		String regex_pwd = "^[0-9A-Za-z]{6,16}$";//密码：大小写字母和数字，6-16位
		
		if(!expertoldpassword.matches(regex_pwd) || !expertnewpassword.matches(regex_pwd) || !expertnewpassword_again.matches(regex_pwd)){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('密码格式错误！（6-16位大小写字母和数字）'); window.location='index.jsp' </script>");
			out.flush();
			out.close();
		}else if(!expertnewpassword.equals(expertnewpassword_again)){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('新密码与确认新密码不一致！'); window.location='index.jsp' </script>");
			out.flush();
			out.close();
		}else{
			
			Expert expert = new Expert();
			expert.setExpertid(expertid);
			expert.setExpertpassword(expertoldpassword);
			expert.setNewpassword(expertnewpassword);
			int update = expertController.ExpertUpdatePassword(expert);
			if(update == -1){
				PrintWriter out = response.getWriter();
				out.print("<script>alert('原密码错误！'); window.location='index.jsp' </script>");
				out.flush();
				out.close();
			}else{
				PrintWriter out = response.getWriter();
				out.print("<script>alert('修改成功！'); window.location='PersonalActionForExpert?id=" + expertid +"' </script>");
				out.flush();
				out.close();
			}
			
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
