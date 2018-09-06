<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>导航-学员需求</title>
</head>
<link href="images/xuebo.jpg" rel="shortcut icon">
<link href="css/head.css" rel="stylesheet">
<link href="css/bootstrap.min.css" rel="stylesheet">
<link href="css/Firstoption.css" rel="stylesheet">

<body>
    <div>
        <div id="cont-acont">
            <div id="cont-a">
                <ul>
                    <li class="border">
                        <a href="ShowArticleListActionForExpert" target="_blank">
                                专家文章
                            </a>
                    </li>
                    <li class="border">
                        <a href="ShowDemandListActionForExpert">
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
                    需求方向 ＞
                </b>
                &nbsp;&nbsp;&nbsp;&nbsp;

                <a href="ShowDemandListActionForExpert">
                    全部
                </a>
                &nbsp;&nbsp;&nbsp;&nbsp;
                <a href="ScreenDemandExpertListActionForType?Type=1" >
                    HTML/CSS
                </a>

                &nbsp;&nbsp;&nbsp;&nbsp;

                <a href="ScreenDemandExpertListActionForType?Type=2">
                    后端开发
                </a>
                &nbsp;&nbsp;&nbsp;&nbsp;

                <a href="ScreenDemandExpertListActionForType?Type=3">
                    服务端
                </a>
                &nbsp;&nbsp;&nbsp;&nbsp;

                <a href="ScreenDemandExpertListActionForType?Type=4">
                    框架
                </a>
            </span>
        <br />
        <br />
        <br /><!--
        <div>
            <b class="text">筛选 ＞</b>
              <div class="text2">
                <span class="block"><a href="#">发布时间</a></span>               
            </div>
        </div>-->
    </div>
    <hr width=100% style="position: relative; top:-130px;" />
    <c:forEach items="${demands }" var="demand">
    <div class="firstchild">
        <a href="ShowStudentDemandReadAction?demandid=${demand.demandid }" target="_blank">
            <div>
                <img alt="Bootstrap Image Preview" src="${demand.studentimage }" class="rounded-circle" width="120px;" style="position: relative;left: 20px; top: 30px;" />
                <h5 class="text3" style="width: 250px; overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">${demand.demandcontent }</h5>
                <span class="text3"><b>${demand.studentname }</b></span>
                <span style="position: relative; left:600px; font-size: 18px; top: -35px;">${demand.demanddate }</span>
                <br><br>
                <span class="text3">【${demand.demandtype }方向】</span>
            </div>
        </a>
    </div>
    </c:forEach>
</body>

</html>