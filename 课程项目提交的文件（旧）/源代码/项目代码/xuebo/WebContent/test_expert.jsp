<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<%
Cookie cookie = null;
Cookie[] cookies = null;
// 获取cookies的数据,是一个数组
cookies = request.getCookies();
%>
<script type="text/javascript">
function logout(){
	window.location.replace("logout.jsp");
}
function personalExpert(){
	window.location.replace("PersonalActionForExpert?id=${cookie.xueboExpertName.value}");
}
function personalStudent(){
	window.location.replace("PersonalActionForStudent?id=${cookie.xueboStudentName.value}");
}
</script>
<title>获取 Cookie</title>
</head>
<body>
<%
   
   if( cookies != null && cookies.length != 1){
      out.println("<h2> 查找 Cookie 名与值</h2>");
      for (int i = 1; i < cookies.length; i++){
         cookie = cookies[i];
        
         out.print("参数名 : " + cookie.getName());
         out.print("<br>");
         out.print("参数值 : " + cookie.getValue());
         out.print("<br>");
      }
  }else{
      out.println("<h2>没有发现 Cookie</h2>");
      response.sendRedirect("page.jsp");
  }
%>
<input type="button" value="注销" onclick="logout()">
<br>
<input type="button" value="个人简介（专家）" onclick="personalExpert()">
<input type="button" value="个人简介（学员）" onclick="personalStudent()">
</body>
</html>