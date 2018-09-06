<%@page import="com.xuebo.bean.Expert"%>
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
if( cookies != null && cookies.length != 1){

}else{
    response.sendRedirect("page.jsp");
}
%>
<%
	Expert expert = null;
%>
<script>
function gethidden(id){
	document.getElementById("demo").innerHTML = document.getElementById(id).value;
}
</script>
<title>专家简介</title>
</head>
<body>
<p>————专家用户————</p>
<form action="UpdatePersonalActionForExpert?id=${cookie.xueboExpertName.value}" method="post">
用户名：<input type="text" name="expertid" value="${expert.expertid }">
<br>
用户昵称：<input type="text" name="expertname" value="${expert.expertname }">
<br>
性别：
<%
	expert = (Expert)session.getAttribute("expert");
	String sex = expert.getExpertsex();
	if(sex.equals("男")){
%>
<input checked="" id="male" name="expertsex" type="radio" value="男"/>男
<input id="female" name="expertsex" type="radio" value="女"/>女
<%
	}else{
%>
<input id="male" name="expertsex" type="radio" value="男"/>男
<input checked="" id="female" name="expertsex" type="radio" value="女"/>女
<%
	}
%>
<br>
身份证：<input type="text" name="expertidcard" value="${expert.expertidcard }">
<br>
介绍：<input type="text" name="expertintroduce" value="${expert.expertintroduce }">
<br>
研究成果：<input type="text" name="expertresearch" value="${expert.expertresearch }">
<br>
主研方向：
<%
	expert = (Expert)session.getAttribute("expert");
	String type = expert.getExperttype();
	if(type.equals("HTML/CSS")){
%>
<select name="experttype">
	<option value="HTML/CSS" selected="selected"> HTML/CSS </option>
	<option value="后端开发"> 后端开发 </option>
	<option value="服务端"> 服务端 </option>  
	<option value="框架"> 框架 </option>
</select>
<%
	}else if(type.equals("后端开发")){
%>
<select name="experttype">
	<option value="HTML/CSS" > HTML/CSS </option>
	<option value="后端开发" selected="selected"> 后端开发 </option>
	<option value="服务端"> 服务端 </option>  
	<option value="框架"> 框架 </option>
</select>
<%
	}else if(type.equals("服务端")){
%>
<select name="experttype">
	<option value="HTML/CSS" > HTML/CSS </option>
	<option value="后端开发" > 后端开发 </option>
	<option value="服务端" selected="selected"> 服务端 </option>  
	<option value="框架"> 框架 </option>
</select>
<%
	}else if(type.equals("框架")){
%>
<select name="experttype">
	<option value="HTML/CSS" > HTML/CSS </option>
	<option value="后端开发" > 后端开发 </option>
	<option value="服务端" > 服务端 </option>  
	<option value="框架" selected="selected"> 框架 </option>
</select>
<%
	}
%>

<br>
预约价格：<input type="text" name="expertprice" value="${expert.expertprice }">
<br>
邮箱：<input type="text" name="expertemail" value="${expert.expertemail }">
<br>
手机号码：<input type="text" name="expertphone" value="${expert.expertphone }">
<br>
职业：<input type="text" name="expertoccupation" value="${expert.expertoccupation }">
<br>
地址：<input type="text" name="expertaddress" value="${expert.expertaddress }">
<br>
头像路径：<input type="text" name="expertimage" value="${expert.expertimage }">
<br>
<input type="submit" value="修改">
<br>
</form>
<form action="UpdatePasswordActionForExpert?id=${cookie.xueboExpertName.value}" method="post">
原密码：<input type="password" name="expertoldpassword" value="${expert.expertpassword }">
<br>
再次输入原密码：<input type="password" name="expertoldpassword_again" >
<br>
新密码：<input type="password" name="expertnewpassword" >
<br>
确认新密码：<input type="password" name="expertnewpassword_again" >
<br>
<input type="submit" value="修改">
<br>
</form>
<form>
<input type="hidden" id="1" name="1" value="1">
<input type="hidden" id="2" name="2" value="2">
<input type="hidden" id="3" name="3" value="3">
<input type="hidden" id="4" name="4" value="4">
<input type="hidden" id="5" name="5" value="5">
<input type="button" value="获取隐藏标签的值(1)" onclick="gethidden('1')">
<br>
<input type="button" value="获取隐藏标签的值(2)" onclick="gethidden('2')">
<br>
<input type="button" value="获取隐藏标签的值(3)" onclick="gethidden('3')">
<br>
<input type="button" value="获取隐藏标签的值(4)" onclick="gethidden('4')">
<br>
<input type="button" value="获取隐藏标签的值(5)" onclick="gethidden('5')">
<br>
<p id="demo">显示隐藏的标签值
</form>
</body>
</html>