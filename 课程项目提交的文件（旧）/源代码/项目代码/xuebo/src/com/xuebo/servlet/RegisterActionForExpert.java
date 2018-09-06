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
 * Servlet implementation class RegisterActionForExpert
 */
public class RegisterActionForExpert extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IExpertController expertController = new ExpertControllerImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterActionForExpert() {
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
		String expert_name = request.getParameter("expert_name");
		String expert_email = request.getParameter("expert_email");
		String expert_password = request.getParameter("expert_password");
		String expert_confirm_password = request.getParameter("expert_confirm_password");
		String expert_sex = request.getParameter("expert_sex");
		String expert_phone1 = request.getParameter("expert_phone1");
		String expert_direction = request.getParameter("expert_direction");
		String expert_id_card = request.getParameter("expert_id_card");
		String expert_agreement = request.getParameter("expert_agreement");
		
		System.out.println("user_name:" + expert_name + " user_email:" + expert_email + " user_password:" + expert_password + expert_confirm_password);
		System.out.println("user_sex:" + expert_sex + " user_phone1:" + expert_phone1 + " user_agreement:" + expert_agreement);
		System.out.println("expert_direction:" + expert_direction + " expert_id_card:" + expert_id_card);
		
		//注册信息的字符串匹配（正则表达式）
		String regex_user = "^[0-9A-Za-z]{6,16}$";//用户账号格式：大小写字母和数字，6-16位
		String regex_email = "^([a-z0-9A-Z]+[-|_|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";//邮箱
		String regex_pwd = "^[0-9A-Za-z]{6,16}$";//密码：大小写字母和数字，6-16位
		String regex_phone1 = "^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$";//手机号码格式
		String regex_id_card = "^\\d{17}(\\d|x)$";//身份证：18位
		
		//处理“接受专家约定协议”
		boolean handle_agreement = expert_agreement==null?false:true;
		
		if(handle_agreement){
			
			if(!expert_name.matches(regex_user)){
				PrintWriter out = response.getWriter();
				out.print("<script>alert('用户账号格式错误：6-16位大小写字母和数字！'); window.location='expert_login.jsp' </script>");
				out.flush();
				out.close();
			}else if(!expert_email.matches(regex_email)){
				PrintWriter out = response.getWriter();
				out.print("<script>alert('邮箱格式错误！'); window.location='expert_login.jsp' </script>");
				out.flush();
				out.close();
			}else if(!expert_password.matches(regex_pwd) && !expert_confirm_password.matches(regex_pwd)){
				PrintWriter out = response.getWriter();
				out.print("<script>alert('密码格式错误：6-16位大小写字母和数字！'); window.location='expert_login.jsp' </script>");
				out.flush();
				out.close();
			}else if(!expert_password.equals(expert_confirm_password)){
				PrintWriter out = response.getWriter();
				out.print("<script>alert('密码与确认密码不匹配！'); window.location='expert_login.jsp' </script>");
				out.flush();
				out.close();
			}else if(!expert_phone1.equals("") && !expert_phone1.matches(regex_phone1)){
				PrintWriter out = response.getWriter();
				out.print("<script>alert('手机号码格式错误！'); window.location='expert_login.jsp' </script>");
				out.flush();
				out.close();
			}else if(!expert_id_card.matches(regex_id_card)){
				PrintWriter out = response.getWriter();
				out.print("<script>alert('身份证长度不足18位！'); window.location='expert_login.jsp' </script>");
				out.flush();
				out.close();
			}
			else{
				
				//进入业务层
				Expert expert = new Expert(expert_name,expert_password,expert_sex,expert_id_card,expert_direction,expert_email,expert_phone1);
				int register = expertController.ExpertRegister(expert);
				if(register == -1){
					PrintWriter out = response.getWriter();
					out.print("<script>alert('重复用户名！'); window.location='expert_login.jsp' </script>");
					out.flush();
					out.close();
				}else if(register == -2){
					PrintWriter out = response.getWriter();
					out.print("<script>alert('身份证号已被使用！'); window.location='expert_login.jsp' </script>");
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
			out.print("<script>alert('请接受《专家约定协议》进行注册操作！'); window.location='expert_login.jsp' </script>");
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
