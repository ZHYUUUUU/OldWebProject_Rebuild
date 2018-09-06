package com.xuebo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xuebo.bean.Discuss;
import com.xuebo.bean.Expert;
import com.xuebo.bean.Student;
import com.xuebo.controller.IDiscussController;
import com.xuebo.controller.IExpertController;
import com.xuebo.controller.IStudentController;
import com.xuebo.controller.impl.DiscussControllerImpl;
import com.xuebo.controller.impl.ExpertControllerImpl;
import com.xuebo.controller.impl.StudentControllerImpl;

/**
 * Servlet implementation class PublishDiscussAction
 */
public class PublishDiscussAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private IDiscussController discussController = new DiscussControllerImpl();
	private IExpertController expertController = new ExpertControllerImpl();
	private IStudentController studentController = new StudentControllerImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PublishDiscussAction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String id = request.getParameter("id");
		String type = request.getParameter("type");
		String state = request.getParameter("state");
		String tribuneid = request.getParameter("tribuneid");
		String discusscontent = request.getParameter("exampleInputContent1");
		
		int type_int = Integer.parseInt(type);
		
		//获取系统时间
		Date systemtime = new Date(); 
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//可以方便地修改日期格式
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");//为了生成预约表的bookid
		String systemtime_str = dateFormat.format(systemtime); 
		String discussid = dateFormat2.format(systemtime);
		System.out.println(systemtime_str); 
		System.out.println(discussid);
		
		if(state.equals("1")){//从评论页面点击的评论
			if(discusscontent.equals("")){
				PrintWriter out = response.getWriter();
				out.print("<script>alert('评论内容不能为空！'); window.location='theme_tribune_discuss.jsp' </script>");
				out.flush();
				out.close();
			}else{
				if(type_int == 0){
					
					Student student = new Student();
					student.setStudentid(id);
					Student new_student = new Student();
					new_student = studentController.StudentPersonalForTribune(student);
					
					Discuss discuss = new Discuss();
					discuss.setTribuneid(tribuneid);
					discuss.setStudentid(id);
					discuss.setDiscussname(new_student.getStudentname());
					discuss.setDiscussid(discussid);
					discuss.setDiscussdate(systemtime_str);
					discuss.setNametype(0);
					discuss.setDiscusscontent(discusscontent);
					discussController.DiscussPublish(discuss);
					
					PrintWriter out = response.getWriter();
					out.print("<script>alert('评论成功！'); window.location='ShowDiscussViewAction?tribuneid=" + tribuneid + "' </script>");
					out.flush();
					out.close();

				}else if(type_int == 1){
					
					Expert expert = new Expert();
					expert.setExpertid(id);
					Expert new_expert = new Expert();
					new_expert = expertController.ExpertPersonalForTritune(expert);
					
					Discuss discuss = new Discuss();
					discuss.setTribuneid(tribuneid);
					discuss.setExpertid(id);
					discuss.setDiscussname(new_expert.getExpertname());
					discuss.setDiscussid(discussid);
					discuss.setDiscussdate(systemtime_str);
					discuss.setNametype(1);
					discuss.setDiscusscontent(discusscontent);
					discussController.DiscussPublish(discuss);
					
					PrintWriter out = response.getWriter();
					out.print("<script>alert('评论成功！'); window.location='ShowDiscussViewAction?tribuneid=" + tribuneid + "' </script>");
					out.flush();
					out.close();

				}
			}
		}else if(state.equals("2")){//从论坛主页点击的评论
			if(type_int == 0){
				if(discusscontent.equals("")){
					PrintWriter out = response.getWriter();
					out.print("<script>alert('评论内容不能为空！'); window.location='student_theme_tribune.jsp' </script>");
					out.flush();
					out.close();
				}else{
					
					Student student = new Student();
					student.setStudentid(id);
					Student new_student = new Student();
					new_student = studentController.StudentPersonalForTribune(student);
					
					Discuss discuss = new Discuss();
					discuss.setTribuneid(tribuneid);
					discuss.setStudentid(id);
					discuss.setDiscussname(new_student.getStudentname());
					discuss.setDiscussid(discussid);
					discuss.setDiscussdate(systemtime_str);
					discuss.setNametype(0);
					discuss.setDiscusscontent(discusscontent);
					discussController.DiscussPublish(discuss);
					
					PrintWriter out = response.getWriter();
					out.print("<script>alert('评论成功！'); window.location='ShowTribuneListActionForStudent?studentid=" + id +"' </script>");
					out.flush();
					out.close();
					
				}
			}else if(type_int == 1){
				if(discusscontent.equals("")){
					PrintWriter out = response.getWriter();
					out.print("<script>alert('评论内容不能为空！'); window.location='expert_theme_tribune.jsp' </script>");
					out.flush();
					out.close();
				}else{
					
					Expert expert = new Expert();
					expert.setExpertid(id);
					Expert new_expert = new Expert();
					new_expert = expertController.ExpertPersonalForTritune(expert);
					
					Discuss discuss = new Discuss();
					discuss.setTribuneid(tribuneid);
					discuss.setExpertid(id);
					discuss.setDiscussname(new_expert.getExpertname());
					discuss.setDiscussid(discussid);
					discuss.setDiscussdate(systemtime_str);
					discuss.setNametype(1);
					discuss.setDiscusscontent(discusscontent);
					discussController.DiscussPublish(discuss);
					
					PrintWriter out = response.getWriter();
					out.print("<script>alert('评论成功！'); window.location='ShowTribuneListActionForExpert?expertid=" + id +"' </script>");
					out.flush();
					out.close();
					
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
