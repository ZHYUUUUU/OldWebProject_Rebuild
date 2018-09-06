package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Student;
import com.xuebo.controller.IStudentController;
import com.xuebo.controller.impl.StudentControllerImpl;

/**
 * Servlet implementation class RegisterAction
 */
public class RegisterActionForUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IStudentController studentController = new StudentControllerImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterActionForUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//注册界面所有信息的反馈
		String user_name = request.getParameter("user_name");
		String user_email = request.getParameter("user_email");
		String user_password = request.getParameter("user_password");
		String user_confirm_password = request.getParameter("user_confirm_password");
		String user_sex = request.getParameter("user_sex");
		String user_phone1 = request.getParameter("user_phone1");
		String user_agreement = request.getParameter("user_agreement");
		
		System.out.println("user_name:" + user_name + " user_email:" + user_email + " user_password:" + user_password + user_confirm_password);
		System.out.println("user_sex:" + user_sex + " user_phone1:" + user_phone1 + " user_agreement:" + user_agreement);
		
		//注册信息的字符串匹配（正则表达式）
		String regex_user = "^[0-9A-Za-z]{6,16}$";//用户账号格式：大小写字母和数字，6-16位
		String regex_email = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";//邮箱
		String regex_pwd = "^[0-9A-Za-z]{6,16}$";//密码：大小写字母和数字，6-16位
		String regex_phone1 = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";//手机号码格式
		
		//处理“接受用户协议”
		boolean handle_agreement = user_agreement==null?false:true;
		
		if(handle_agreement){
			
			if(!user_name.matches(regex_user)){
				PrintWriter out = response.getWriter();
				out.print("<script>alert('用户账号格式错误：6-16位大小写字母和数字！'); window.location='login.jsp' </script>");
				out.flush();
				out.close();
			}else if(!user_email.matches(regex_email)){
				PrintWriter out = response.getWriter();
				out.print("<script>alert('邮箱格式错误！'); window.location='login.jsp' </script>");
				out.flush();
				out.close();
			}else if(!user_password.matches(regex_pwd) && !user_confirm_password.matches(regex_pwd)){
				PrintWriter out = response.getWriter();
				out.print("<script>alert('密码格式错误：6-16位大小写字母和数字！'); window.location='login.jsp' </script>");
				out.flush();
				out.close();
			}else if(!user_password.equals(user_confirm_password)){
				PrintWriter out = response.getWriter();
				out.print("<script>alert('密码与确认密码不匹配！'); window.location='login.jsp' </script>");
				out.flush();
				out.close();
			}else if(!user_phone1.equals("") && !user_phone1.matches(regex_phone1)){
				PrintWriter out = response.getWriter();
				out.print("<script>alert('手机号码格式错误！'); window.location='login.jsp' </script>");
				out.flush();
				out.close();
			}else{
				
				//进入业务层
				Student student = new Student(user_name,user_password,user_sex,user_email,user_phone1);
				int register = studentController.StudentRegister(student);
				if(register == -1){
					PrintWriter out = response.getWriter();
					out.print("<script>alert('重复用户名！'); window.location='login.jsp' </script>");
					out.flush();
					out.close();
				}else{
					PrintWriter out = response.getWriter();
					out.print("<script>alert('注册成功！（即将返回登录界面）'); window.location='page.jsp' </script>");
					out.flush();
					out.close();
				}
				
			}
			
		}else{
			PrintWriter out = response.getWriter();
			out.print("<script>alert('请接受《用户协议》进行注册操作！'); window.location='login.jsp' </script>");
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
