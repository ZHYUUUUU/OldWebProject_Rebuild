<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
    <title>导航-主题论坛</title>
    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
    <link href="images/xuebo.jpg" rel="shortcut icon">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet" type="text/css">
    <link href="css/head.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</head>

<body>
    <div class="container-fluid">
        <div class="row guding" id="cont-acont">
            <div class="cont-a1">
                <!-- 以上这div用于进一步调整导航栏选项的位置 -->
                <div id="cont-a">
                    <ul>
                        <li class="border">
                            <a href="ShowFirstoptionListAction" target="_blank">
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
                        <li style="float:right;">
                            <a href="logout.jsp">
                            退出登录
                        </a>
                        </li>
                        <li style="float:right;">
                            <a href="PersonalActionForStudent?id=${cookie.xueboStudentName.value}">
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
        <!-- 个人信息栏 -->
        <div class="row">
            <div class="col-md-12" style="position: relative;margin-left: -15px;">
                <img alt="Bootstrap Image Preview" src="images/tribune_bg.png" />
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <img alt="Bootstrap Image Preview" class="rounded-circle" src="${student.studentimage }" style="position: relative;margin-left: 230px; margin-top: -70px; width:140px;height:140px;" />
                <div class="row">
                    <div class="col-md-8 c-md-8">
                        <h2 class="card" style="margin-left: 380px; margin-top: -50px;padding: 5px; width: 250px">
                            	${student.studentname }
                        </h2>
                    </div>
                </div>
            </div>
        </div>
        <hr />
        <!-- 功能选择 -->
        <div class="row">
            <div class="col-md-2">
            </div>
            <div class="col-md-8">
                <div class="tabbable" id="tabs-610813">
                    <ul class="nav nav-tabs" style="margin-bottom: 20px">
                        <li class="nav-item">
                            <a class="nav-link active" href="#panel-129757" data-toggle="tab">看帖</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#panel-313255" data-toggle="tab">我的帖子</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active" id="panel-129757">
                        <c:forEach items="${tribunes1 }" var="tribune">
                        	<div class="media" style="border: 1px solid rgba(0, 0, 0, 0.1); border-radius: 15px; padding: 10px" >
                                <img class="mr-3" alt="Bootstrap Media Preview" src="${tribune.creatorimage }" width=64px height=64px/>
                                <div class="media-body">
                                    <div onclick="window.open('ShowDiscussViewAction?tribuneid=${tribune.tribuneid}')" onmouseover="this.style.cursor='pointer'" onmouseout="this.style.cursor='normal'">
                                    <h5 class="mt-0">${tribune.creator }
                                    </h5> ${tribune.tribunetitle }
                                    </div>
                                    <div class="media mt-3">
                                        <a class="btn btn-md" data-toggle="modal" href="#modal-container-${tribune.tribuneid }817139" id="modal-817139" role="button">
                                            评论
                                        </a>
                                        <font style="font-size:14px;position: relative;left:500px;top:10px;">${tribune.createdate }</font>
                                        <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-${tribune.tribuneid }817139" role="dialog">
                                            <div class="modal-dialog" role="document" style="position: relative;margin-top: 80px;">
                                                <!-- 调整弹出小窗口的位置 -->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="myModalLabel">
                                                        评论
                                                        </h5>
                                                        <button class="close" data-dismiss="modal" type="button">
                                                            <span aria-hidden="true">
                                                    ×
                                                </span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <form role="form" action="PublishDiscussAction?id=${cookie.xueboStudentName.value }&tribuneid=${tribune.tribuneid}&type=0&state=2" method="post">                                                            
                                                            <div class="form-group">
                                                                <label for="exampleInputContent1">
                                                                    评论内容
                                                                </label>
                                                                <textarea cols="56" name="exampleInputContent1" id="exampleInputContent1" rows="4" style="font-size: 16px;"></textarea>
                                                            </div>
                                                   	<div class="modal-footer">
                                                        <button class="btn btn-primary" type="submit">
                                                            发布评论
                                                        </button>
                                                        <button class="btn btn-secondary" data-dismiss="modal" type="button">
                                                            关闭
                                                        </button>
                                                    </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </c:forEach>
                        </div>
                        <div class="tab-pane" id="panel-313255">
                            <div style="margin-bottom: 20px">
                                <a class="btn btn-md btn-primary" data-toggle="modal" href="#modal-container-817140" id="modal-817140" role="button">
                                            发布新贴
                                        </a>
                                <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-817140" role="dialog">
                                    <div class="modal-dialog" role="document" style="position: relative;margin-top: 80px;">
                                        <!-- 调整弹出小窗口的位置 -->
                                        <div class="modal-content">
                                            <div class="modal-header">
                                                <h5 class="modal-title" id="myModalLabel">
                                                        发布新贴
                                                        </h5>
                                                <button class="close" data-dismiss="modal" type="button">
                                                    <span aria-hidden="true">
                                                    ×
                                                </span>
                                                </button>
                                            </div>
                                            <div class="modal-body">
                                                <form role="form" action="CreateTribuneActionForStudent?studentid=${cookie.xueboStudentName.value }" method="post">
                                                <div class="form-group">
                                                    <label for="exampleInputname2">
                                                        标题
                                                    </label>
                                                    <input type="text" class="form-control" name="exampleInputname2" id="exampleInputname2" />
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputEmail1">
                                                        主题方向
                                                    </label>
                                                    <input type="text" class="form-control" name="exampleInputEmail1" id="exampleInputEmail1" />
                                                </div>                                                
                                                <div class="form-group">
                                                    <label for="exampleTextarea1">
                                                        内容
                                                    </label>
                                                    <textarea rows="4" cols="56" name="exampleTextarea1" id="exampleTextarea1"></textarea>
                                                </div>
                                           	<div class="modal-footer">
                                                <button class="btn btn-primary" type="submit">
                                                    发布新贴
                                                </button>
                                                <button class="btn btn-secondary" data-dismiss="modal" type="button">
                                                    关闭
                                                </button>
                                            </div>
                                            </form>
                                            </div>

                                        </div>
                                    </div>
                                </div>
                            </div>
                            <c:forEach items="${tribunes2 }" var="tribune">
                            	<div class="media" style="border: 1px solid rgba(0, 0, 0, 0.1); border-radius: 15px; padding: 10px">
                                <img class="mr-3" alt="Bootstrap Media Preview" src="${tribune.creatorimage }" style="width: 64px;height: 64px" />
                                <div class="media-body">
                                    <div onclick="window.open('ShowDiscussViewAction?tribuneid=${tribune.tribuneid}')" onmouseover="this.style.cursor='pointer'" onmouseout="this.style.cursor='normal'">
                                    <h5 class="mt-0">${tribune.creator }
                                    </h5> ${tribune.tribunetitle }
                                    </div>
                                    <div class="media mt-3">
                                        <!-- <a class="pr-3" href="#"><img alt="Bootstrap Media Another Preview" src="images/zhangxiaolong.jpg" style="width: 64px;height: 64px" /></a>
                                        <div class="media-body">
                                            <h5 class="mt-0">
                                                Nested media heading
                                            </h5> Cras sit amet nibh libero, in gravida nulla. Nulla vel metus scelerisque ante sollicitudin commodo. Cras purus odio, vestibulum in vulputate at, tempus viverra turpis.
                                        </div> -->
                                        <a class="btn btn-md" data-toggle="modal" href="#modal-container-${tribune.tribuneid }817141" id="modal-817141" role="button">
                                            删除
                                        </a>
                                        <font style="font-size:14px;position: relative;left:500px;top:10px;">${tribune.createdate }</font>
                                        <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-${tribune.tribuneid }817141" role="dialog">
                                            <div class="modal-dialog" role="document" style="position: relative;margin-top: 80px;">
                                                <!-- 调整弹出小窗口的位置 -->
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="myModalLabel">
                                                        删除
                                                        </h5>
                                                        <button class="close" data-dismiss="modal" type="button">
                                                            <span aria-hidden="true">
                                                    ×
                                                </span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <form role="form" action="DelectTribuneAction?tribuneid=${tribune.tribuneid}&id=${tribune.studentid }&creatorstate=${tribune.creatorstate }" method="post">
                                                            <div class="form-group">
                                                                <label for="exampleInputname1">
                                                                    删除之后无法恢复！是否删除？
                                                                </label>
                                                            </div>
                                                  	<div class="modal-footer">
                                                        <button class="btn btn-primary" type="submit">
                                                            确定删除
                                                        </button>
                                                        <button class="btn btn-secondary" data-dismiss="modal" type="button">
                                                            关闭
                                                        </button>
                                                    </div>
                                                        </form>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </c:forEach>
                        </div>
                    </div>
                </div><br>
            </div>
            <div class="col-md-2">
            </div>
        </div>
    </div>
</body>

</html>