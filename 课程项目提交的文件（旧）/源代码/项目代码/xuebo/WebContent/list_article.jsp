<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
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
    <title>专家文章</title>
    <link href="images/xuebo.jpg" rel="shortcut icon">
    <link href="css/head.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/Firstoption.css" rel="stylesheet">
</head>

<body>
    <div>
        <div id="cont-acont">
            <div id="cont-a">
                <ul>
                    <li class="border">
                        <a href="ShowArticleListActionForExpert">
                                专家文章
                            </a>
                    </li>
                    <li class="border">
                        <a href="ShowDemandListActionForExpert" target="_blank">
                                学员需求
                            </a>
                    </li>
                    <li class="border">
                        <a href="ShowTribuneListActionForExpert?expertid=${cookie.xueboExpertName.value}" target="_blank">
                                主题论坛
                            </a>
                    </li>
                    <li class="border">
                        <a href="#" target="_blank">
                                业内行情
                            </a>
                    </li>
                    <li class="border" style="float:right;">
                        <a href="logout.jsp">
                                退出登录
                            </a>
                    </li>
                    <li class="border" style="float:right;">
                        <a href="PersonalActionForExpert?id=${cookie.xueboExpertName.value}" target="_blank">
                                个人主页
                            </a>
                    </li>
                </ul>
            </div>
            <!-- 学博logo -->
            <a href="ShowHomepageAction?type=1" target="_blank">
                <img src="images/log4.png" style="position:fixed; left:125px; top:10px;" width="40px"/>
            </a>
        </div>
    </div>
    <!-- 分类 -->
    <div class="N1">
        <span class="text1">
                <b>
                    话题方向 ＞
                </b>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="ShowArticleListActionForExpert" >
                    全部
                </a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="ScreenArticleExpertListActionForType?Type=1" >
                    HTML/CSS
                </a>
                &nbsp;&nbsp;&nbsp;&nbsp;

                <a href="ScreenArticleExpertListActionForType?Type=2">
                    后端开发
                </a>
                &nbsp;&nbsp;&nbsp;&nbsp;

                <a href="ScreenArticleExpertListActionForType?Type=3">
                    服务端
                </a>
                &nbsp;&nbsp;&nbsp;&nbsp;

                <a href="ScreenArticleExpertListActionForType?Type=4">
                    框架
                </a>
            </span>
        <br />
        <br />
        <br />
        <div>
            <b class="text">筛选 ＞</b>
            <div class="text2">
                <span class="block"><a href="#">见面最多</a></span>
                <span class="block"><a href="#">评分最高</a></span>
                <span class="block"><a href="#">发布时间</a></span>
                <span class="block"><a href="#">价格最少</a></span>
            </div>
        </div>
    </div>
    <hr width=100% style="position: relative; top:-80px;" />
    <c:forEach items="${articles }" var="article">
    <div class="firstchild">
        <a href="ShowArticleReadAction?articleid=${article.articleid }" target="_blank">
            <div>
                <img alt="Bootstrap Image Preview" src="${article.expertimage }" class="rounded-circle" width="120px;" style="position: relative;left: 20px; top: 30px;" />
                <h5 class="text3">${article.articletitle } </h5>
                <span class="text3"><b>${article.expertname }</b></span><br>
                <span class="text3"><font style="line-height:200%;">【${article.articletype }方向】</font></span>
                <span style="position: relative; left:570px; font-size: 18px; top: -61px;line-height:30%;"><font style="font-size:16px">${article.publishdate }</font></span>
                <footer class="blockquote-footer " style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;margin-top: 10px;">${article.articlecontent }
                </footer>
            </div>
        </a>
    </div>
    </c:forEach>
</body>

</html>