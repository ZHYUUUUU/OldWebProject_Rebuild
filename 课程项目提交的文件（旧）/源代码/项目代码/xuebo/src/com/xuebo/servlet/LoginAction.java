package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Expert;
import com.xuebo.bean.Student;
import com.xuebo.controller.IExpertController;
import com.xuebo.controller.IStudentController;
import com.xuebo.controller.impl.ExpertControllerImpl;
import com.xuebo.controller.impl.StudentControllerImpl;

/**
 * Servlet implementation class LoginAction
 */
public class LoginAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IExpertController expertController = new ExpertControllerImpl();
	private IStudentController studentController = new StudentControllerImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String check_id_card = request.getParameter("check_id_card");
		
		System.out.println("name:" + name + " pwd:" + pwd + " check_id_card:" + check_id_card);
		
		boolean isStudent = check_id_card==null;//区分专家与学员的标志，true为专家，否则为学员
		
		//登录信息的字符串匹配（正则表达式）
		String regex_user = "^[0-9A-Za-z]{6,16}$";//用户账号格式：大小写字母和数字，6-16位
		String regex_pwd = "^[0-9A-Za-z]{6,16}$";//密码：大小写字母和数字，6-16位
		String regex_id_card = "^\\d{17}(\\d|x)$";//身份证：18位
		
		if(!name.matches(regex_user)){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('用户账号格式错误：6-16位大小写字母和数字！'); window.location='page.jsp' </script>");
			out.flush();
			out.close();
		}else if(!pwd.matches(regex_pwd)){
			PrintWriter out = response.getWriter();
			out.print("<script>alert('密码格式错误：6-16位大小写字母和数字！'); window.location='page.jsp' </script>");
			out.flush();
			out.close();
		}
		else{
			
			if(!isStudent){
				
				if(!check_id_card.matches(regex_id_card)){
					PrintWriter out = response.getWriter();
					out.print("<script>alert('身份证长度不足18位！'); window.location='page.jsp' </script>");
					out.flush();
					out.close();
				}else{
					
					//业务层代码-进入匹配阶段（专家用户）
					Expert expert = new Expert(name,pwd,check_id_card);
					Expert new_expert = expertController.ExpertLogin(expert);
					int login = new_expert.getStatecode();
					
					if(login == -1){
						PrintWriter out = response.getWriter();
						out.print("<script>alert('没有此用户名！'); window.location='page.jsp' </script>");
						out.flush();
						out.close();
					}else if(login == -2){
						PrintWriter out = response.getWriter();
						out.print("<script>alert('密码错误！'); window.location='page.jsp' </script>");
						out.flush();
						out.close();
					}else if(login == -3){
						PrintWriter out = response.getWriter();
						out.print("<script>alert('身份证与本用户不匹配！'); window.location='page.jsp' </script>");
						out.flush();
						out.close();
					}else{
						//设置cookie（取用户账号）
						Cookie cookie1 = new Cookie("xueboExpertName",new_expert.getExpertid());
						Cookie cookie2 = new Cookie("xueboStudentName",null);
						cookie1.setPath("/");
						cookie1.setMaxAge(60*60);//1小时
						response.addCookie(cookie1);
						cookie2.setPath("/");
						cookie2.setMaxAge(60*60);
						response.addCookie(cookie2);
						response.sendRedirect("ShowHomepageAction?type=1");
					}
				}
				
			}else{
				
				//业务层代码-进入匹配阶段（学员用户）
				Student student = new Student(name,pwd);
				Student new_student = studentController.StudentLogin(student);
				int login = new_student.getStatecode();
				
				if(login == -1){
					PrintWriter out = response.getWriter();
					out.print("<script>alert('没有此用户名！'); window.location='page.jsp' </script>");
					out.flush();
					out.close();
				}else if(login == -2){
					PrintWriter out = response.getWriter();
					out.print("<script>alert('密码错误！'); window.location='page.jsp' </script>");
					out.flush();
					out.close();
				}else{
					//设置cookie（取用户账号）
					Cookie cookie1 = new Cookie("xueboExpertName",null);
					Cookie cookie2 = new Cookie("xueboStudentName",new_student.getStudentid());
					cookie1.setPath("/");
					cookie1.setMaxAge(60*60);//1小时
					response.addCookie(cookie1);
					cookie2.setPath("/");
					cookie2.setMaxAge(60*60);
					response.addCookie(cookie2);
					response.sendRedirect("ShowHomepageAction?type=0");
				}
				
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
