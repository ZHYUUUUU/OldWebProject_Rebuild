<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%
Cookie cookie = null;
Cookie[] cookies = null;
// 获取cookies的数据,是一个数组
cookies = request.getCookies();
%>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登出</title>
</head>
<body>
<%

		for (int i = 0; i < cookies.length; i++){
		    cookie = cookies[i];
		    cookie.setPath("/");
		    cookie.setMaxAge(0);
		    response.addCookie(cookie);
		}
		response.sendRedirect("page.jsp");

		%>
</body>
</html>