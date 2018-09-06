<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en" xml:lang="en" xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta content="text/html;charset=utf-8" http-equiv="Content-type"/>
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
            学博教育
        </title>
        <link href="images/xuebo.jpg" rel="shortcut icon">
            <link href="css/head.css" rel="stylesheet">
                <link href="css/homepage.css" rel="stylesheet">
                    <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css">
                        <link href="css/bootstrap1.min.css" rel="stylesheet" type="text/css">
                            <link href="css/search.css" rel="stylesheet" type="text/css">
                            </link>
                        </link>
                    </link>
                </link>
            </link>
        </link>
    </head>
    <body>
        <div class="guding" id="cont-acont">
        <div id="cont-a">
            <ul>
                <li class="border">
                    <a href="ShowArticleListActionForExpert" target="_blank">
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
                    <a href="it_information.jsp" target="_blank">
                        业内行情
                    </a>
                </li>
                <!-- <div>
                        <li class="border">
                            <a href="#" target="_blank">
                                更多     ∨
                            </a>
                            <ul >
                                <li class="top">
                                    <a href="#" target="_blank">
                                        教育机构
                                    </a>
                                </li>
                                <li class="top">
                                    <a href="#" target="_blank">
                                        业内行情
                                    </a>
                                </li>
                                <li class="top">
                                    <a href="#" target="_blank">
                                        其他
                                    </a>
                                </li>
                            </ul>
                        </li>
                    </div> -->
                <!--  <li style="float:right;">
                        <a href="login.html" target="_blank">
                            注册
                        </a>        
                    </li> -->
                <li style="float:right;">
                    <a href="logout.jsp">
                        退出登录
                    </a>
                </li>
                <li style="float:right;">
                    <a href="PersonalActionForExpert?id=${cookie.xueboExpertName.value}" >
                        个人主页
                    </a>
                </li>
            </ul>
        </div>
        <!-- 学博logo -->
        <a href="ShowHomepageAction?type=1" target="_blank">
            <img src="images/log4.png" style="position:relative; left:125px; top:-52px;" width="40px"/>
        </a>
    </div>


    <!-- 背景图片 -->
    <div class="bg ">
    </div>


    <!-- 搜索栏 -->
    <nav class="navbar navbar-default search">
        <div class="container-fluid">
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <!-- <ul class="nav navbar-nav dropsetting">
                    <li class="dropdown">
                        <a aria-expanded="false" aria-haspopup="true" class="dropdown-toggle" data-toggle="dropdown" href="#" role="button">
                            机构
                        </a>
                        <ul class="dropdown-menu">
                            <li>
                                <a href="#">
                                    专家
                                </a>
                            </li>
                        </ul>
                    </li>
                </ul> -->
                           
                <form class="navbar-form navbar-left" action="ResearchActionInHomepage?type=1" method="post">
                    <div class="form-group"> 
                        <select class="btn" name="researchHomepage" style=" padding :5px; margin-right: 10px; background-color: rgba(0,0,0,0);" >   <!-- select为下拉菜单标签， 比select好的有datalist标签-->
                            <option value="专家"> 专家 </option>  <!-- 默认选项为第一个选项 -->
                            <option value="机构"> 机构 </option>
                            </select>
                        <input class="form-control" name="researchText" placeholder="搜专家、机构" type="text">
                        </input>
                    </div>
                    <button class="btn btn-default" type="submit">
                        搜索
                    </button>
                </form>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
    <!-- 中间三个guide说明 -->
    <div class="indexguide">
        <div class="guide ">
            <img src="images/icon/renqun.png" style=" position:relative; width:40px ; top: 28px;"/>
            <h3 class="text1">
                海量专家
            </h3>
            <p class="text1">
                严选超过千位达人专属服务
            </p>
            <img src="images/icon/guwen.png" style=" position:relative; width:32px ; top: -50px;left:280px;"/>
            <h3 class="text2">
                万能顾问
            </h3>
            <span class="text2" style="position:relative;  top: -10px;">
                求教专家解惑或与达人切磋
            </span>
            <img src="images/icon/fuwu.png" style=" position:relative; width:40px ; top: -27px;left:70px;"/>
            <h3 class="text3">
                按需服务
            </h3>
            <span class="text3">
                根据个人所需线上线下灵活沟通
            </span>
        </div>
    </div>

    <!-- 主页专家栏 -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-9" style="position: relative;margin: auto;">
                <!-- 专家栏居中 -->
                <div class="row">
                <c:forEach items="${books }" var="book">
                	<div class="col-md-3">
                        <div class="card " style="width: 220px;">
                            <img alt="Bootstrap Thumbnail First" class="card-img-top" src="${book.expertimage }" width="215px" height="215px"/>
                            <div class="card-block">
                                <h5 class="card-title">${book.expertname }
                                </h5>
                                <p class="card-text">${book.expertoccupation }
                                </p>
                                <p>
                                    <a class="btn btn-primary" href="ShowFirstmessageAction?id=${book.expertid }">
                                        前往了解
                                    </a>
                                    <span style="position: relative; margin-left: 10px; color:blue ">
                                        ${book.count_book }人见过
                                    </span>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                </div>
            </div>
        </div>
    </div>



    <!-- 下载客户端 -->
    <div class="into-loadclient">
        <div class="saoma">
            <img src="images/saoma.jpg" style="position:relative; width: 110px; left: 15px;top:10px; "/>
            <p class="text">
                手机扫码下载
            </p>
        </div>
        <div class="loadclient-text">
            <h2>
                下载客户端
            </h2>
            <p>
                服务更方便
            </p>
            <p>
                需求更到位
            </p>
            <p>
                更多知心功能
            </p>
            <a href="#">
                <img src="images/icon/jiantou.png" style="position:relative; width: 60px; left: 155px; top: -160px;"/>
            </a>
        </div>
    </div>
    <!-- 页面底部 -->
    <div class="footer footer-fixed-bottom">
        <div class="footer-l">
            <a href="#">
                <img src="images/xueboChar.png" style="position:relative; left:150px; top:-40px;" width="100px"/>
            </a>
            <span style="color:white; position:relative; left:150px ; top:-30px;">
                网络教育平台
            </span>
            <div>
                <p class="kuai-l">
                    <a href="#">
                        首页
                    </a>
                </p>
                <p class="kuai-l">
                    <a href="#">
                        下载APP
                    </a>
                </p>
                <p class="kuai-l">
                    <a href="#">
                        关于我们
                    </a>
                </p>
                <p class="kuai-l">
                    <a href="#">
                        帮助
                    </a>
                </p>
            </div>
            <div class="company">
                <p>
                    广州市学博教育信息技术有限公司
                </p>
                <p>
                    京ICP证030294号/
                    <img src="images/jinggong.png" style="position:relative;  " width="10px"/>
                    京公网安备11000002000150号
                </p>
            </div>
        </div>
        <div class="footer-r">
            <p style=" font-size: 30px">
                4000-956-451
            </p>
            <p>
                工作时段 09：00-21：00
            </p>
            <a href="#">
                <img src="images/kefu.png" style="position: relative; 
                    left:-5px ; top:20px;" width="75px"/>
                <span style="position: relative; left: -74px; top:20px;">
                    在线客服
                </span>
            </a>
            <br/>
            <br/>
            <p>
                官方微信号：cql18822536402
            </p>
            <p>
                官方QQ：3057894562
            </p>
            <br/>
            <p>
                住址：广东省深圳市龙岗区布吉新区上雪科技园(北区)
            </p>
            <p>
                电话：18244993589
            </p>
        </div>
    </div>
    </body>
</html>