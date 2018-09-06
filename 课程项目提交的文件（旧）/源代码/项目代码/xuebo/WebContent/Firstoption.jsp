<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8">
<%
	Cookie cookie = null;
	Cookie[] cookies = null;
	// 获取cookies的数据,是一个数组
	cookies = request.getCookies();
	if (cookies != null && cookies.length != 1) {

	} else {
		response.sendRedirect("page.jsp");
	}
%>  
            <title>
                导航-专家指路
            </title>
            <link href="images/xuebo.jpg" rel="shortcut icon">
                <link href="css/head.css" rel="stylesheet">
                    <link href="css/bootstrap.min.css" rel="stylesheet">
                     <link href="css/Firstoption.css" rel="stylesheet">             
                     </link>
                </link>
            </link>
           
            </link>
        </meta>
    </head>
    <body>
        <div>
            <div  id="cont-acont">
                <div id="cont-a">
                    <ul>
                        <li class="border">
                            <a href="ShowFirstoptionListAction" >
                                专家指路
                            </a>
                        </li>
                        <li class="border">
                            <a href="ShowTribuneListActionForStudent?studentid=${cookie.xueboStudentName.value}" target="_blank">
                                主题论坛
                            </a>
                        </li>
                        <li class="border">
                            <a href="ShowOrganizationViewAction" target="_blank">
                                教育机构
                            </a>
                        </li>
                        <li class="border"  style="float:right;">
                            <a href="logout.jsp" >
                                退出登录
                            </a>
                        </li>
                        <li  class="border" style="float:right;">
                            <a href="PersonalActionForStudent?id=${cookie.xueboStudentName.value}" target="_blank">
                                个人主页
                            </a>
                        </li>
                    </ul>
                </div>           
            
            <!-- 学博logo -->
            <a href="ShowHomepageAction?type=0" target="_blank">
                <img src="images/log4.png" style="position:fixed; left:125px; top:10px;" width="40px"/>
            </a>
        </div>
        </div>
        <!-- 分类 -->
        <div class="N1">
            <span class="text1">
                <b>
                    指导方向 ＞
                </b>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="ShowFirstoptionListAction" >
                    全部
                </a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="ScreenFirstoptionListActionForType?Type=1" >
                    HTML/CSS
                </a>
                &nbsp;&nbsp;&nbsp;&nbsp;

                <a href="ScreenFirstoptionListActionForType?Type=2">
                    后端开发
                </a>
                &nbsp;&nbsp;&nbsp;&nbsp;

                <a href="ScreenFirstoptionListActionForType?Type=3">
                    服务端
                </a>
                &nbsp;&nbsp;&nbsp;&nbsp;

                <a href="ScreenFirstoptionListActionForType?Type=4">
                	框架
                </a>
            </span>
			<br />
			<br />
			<br />

            <div>
            	<b class="text" >筛选 ＞</b>
            	<div class="text2">
            	<span class="block"><a href="ScreenFirstoptionListActionForSeen">见面最多</a></span>	
            	<span class="block"><a href="ScreenFirstoptionListActionForPoint">评分最高</a></span>	
            	<span class="block"><a href="ScreenFirstoptionListActionForPrice">价格最少</a></span>
            	</div>       
    		</div>
		</div>
    <hr  width=100% style="position: relative; top:-80px;" />
    
<c:forEach items="${books }" var="book">
    <div class="firstchild">
    <a href="ShowFirstmessageAction?id=${book.expertid }">
        <div>
    	<img alt="Bootstrap Image Preview" src="${book.expertimage }" class="rounded-circle"  width="120px;" style="position: relative;left: 20px; top: 30px;" />
    <h5 class="text3" >${book.expertoccupation } &nbsp;&nbsp; ${book.avg_bookassess }分</h5>
    <span class="text3"><b>${book.expertname }</b></span>
    <span style="position: relative;left: 10px;"> </span>
	<span style="position: relative;  left:10px;">${book.count_book }人见过</span>
	<span  style="position: relative; left:600px; font-size: 20px; top: -35px;">${book.expertprice }元/次</span>
    <footer class="blockquote-footer ">${book.expertintroduce }
    </footer>
	</div>
</a>
</div>
</c:forEach>

    </body>
</html>