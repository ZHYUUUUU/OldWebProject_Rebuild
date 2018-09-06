<%@page import="com.xuebo.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
	Student student = null;
%>
<%
Cookie cookie = null;
Cookie[] cookies = null;
// 获取cookies的数据,是一个数组
cookies = request.getCookies();
if( cookies != null && cookies.length != 1){

}else{
    response.sendRedirect("page.jsp");
}
%>
<title>学员简介</title>
</head>
<body>
<p>————学员用户————</p>
<form action="UpdatePersonalActionForStudent?id=${cookie.xueboStudentName.value}" method="post">
用户名：<input type="text" name="studentid" value="${student.studentid }">
<br>
用户昵称：<input type="text" name="studentname" value="${student.studentname }">
<br>
性别：
<%
	student = (Student)session.getAttribute("student");
	String sex = student.getStudentsex();
	if(sex.equals("男")){
%>
<input checked="" id="male" name="studentsex" type="radio" value="男"/>男
<input id="female" name="studentsex" type="radio" value="女"/>女
<%
	}else{
%>
<input id="male" name="studentsex" type="radio" value="男"/>男
<input checked="" id="female" name="studentsex" type="radio" value="女"/>女
<%
	}
%>
<br>
邮箱：<input type="text" name="studentemail" value="${student.studentemail }">
<br>
手机号码：<input type="text" name="studentphone" value="${student.studentphone }">
<br>
头像路径：<input type="text" name="studentimage" value="${student.studentimage }">
<br>
介绍：<input type="text" name="studentintroduce" value="${student.studentintroduce }">
<br>
<input type="submit" value="修改">
<br>
</form>
<form action="UpdatePasswordActionForStudent?id=${cookie.xueboStudentName.value}" method="post">
原密码：<input type="password" name="studentoldpassword" value="${student.studentpassword }">
<br>
再次确认原密码：<input type="password" name="studentoldpassword_again" >
<br>
新密码：<input type="password" name="studentnewpassword" >
<br>
再次确认新密码：<input type="password" name="studentnewpassword_again" >
<br>
<input type="submit" value="修改">
<br>
</form>

</body>
</html>