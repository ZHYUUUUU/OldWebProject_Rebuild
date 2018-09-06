<%@page import="com.xuebo.bean.Expert"%>
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
	Expert expert = null;
	%>
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
    <title>个人主页</title>
    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
    <link href="images/xuebo.jpg" rel="shortcut icon">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/student_information.css" rel="stylesheet" type="text/css">
    <link href="css/head.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    <script>
    function delete_book(bookid){
    	var r=confirm("是否删除该预约记录？（此操作不可恢复）");
    	if(r==true){
    		window.location = "DeleteBookActionForStudent?bookid=" + bookid;
    	}
    }
    function delete_demand(id){
    	var r=confirm("是否删除该需求？（此操作不可恢复）");
    	if(r==true){
    		window.location = "DeleteDemandActionForStudent?" + id;
    	}
    }
    </script>
    <script>
    // 显示预览图片
    function changepic() {
        var reads = new FileReader();
        f = document.getElementById('file').files[0];
        reads.readAsDataURL(f);
        reads.onload = function(e) {
            document.getElementById('show').src = this.result;
        };
    }

    // 限制图片尺寸
    var width, height;
    function handleConLogo(files) {

        for (var i = 0; i < files.length; i++) {
            var file = files[i];
            var reader = new FileReader();
            var ret = [];
            reader.onload = function(theFile) {
                var image = new Image();
                image.onload = function() {
                    width = this.width;
                    height = this.height;
                    if (width - height == 0) {
                        alert("图片格式符合要求！")
                    } else {
                        fill = false;
                        alert("图片比例应该为1:1，建议重新上传!");                        
                    }
                };
                image.src = theFile.target.result;
            }
            reader.readAsDataURL(file);
        }
    }
    </script>
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
        <div class="row">
            <!-- 左边栏为学员个人信息栏 -->
            <div class="col-md-3 personer-imformation" style="z-index: 1300;">
                <div class="row" style="margin-top: 150px">
                    <div class="img-center">
                        <!-- 点击上传界面 -->
                        <a class="btn btn-md" data-toggle="modal" href="#modal-container-1923721" id="modal-1923721" role="button">                        
                            <img alt="Bootstrap Image Preview" class="rounded-circle" src="${student.studentimage }" width="140px" height="140px"/>
                        </a>
                    </div>
                    <!-- 上传新头像弹出框-->
                    <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-1923721" role="dialog" style="padding-top: 150px">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <h5 class="modal-title" id="myModalLabel">
                                        修改头像
                                    </h5>
                                    <button class="close" data-dismiss="modal" type="button">
                                        <span aria-hidden="true">
                                            ×
                                        </span>
                                    </button>
                                </div>
                                <div class="modal-body">
                                    <form role="form" method="post" action="UploadAction?id=${cookie.xueboStudentName.value }&type=0" enctype="multipart/form-data">
                                        <div class="form-group">
                                            <label for="file">
                                                上传新头像
                                            </label>
                                            <input class="form-control" type="file" id="file" name="uploadFile" accept="image/*" onchange="changepic(this);handleConLogo(files)" />
                                            <br>
                                            <img src="" id="show" width="200">
                                        </div>
                                        <button class="btn btn-primary" type="submit">
                                            确定修改
                                        </button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <h4 class="text-center text-white">${student.studentname }</h4>
                <div class="card" style="padding-top: 10px; margin-top: 170px">
                    <h6 class="text-center text-white">账号：${cookie.xueboStudentName.value}</h6>
                    <h6 class="text-center text-white">密码：*********</h6>
                    <a id="modal-192372" href="#modal-container-192372" role="button" class="btn btn-md" data-toggle="modal">修改密码</a>
                </div>
                <!-- 修改密码弹出框 -->
                <div class="modal fade" id="modal-container-192372" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="padding-top: 150px">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <h5 class="modal-title" id="myModalLabel">修改密码</h5>
                                <button type="button" class="close" data-dismiss="modal">
                                    <span aria-hidden="true">×</span>
                                </button>
                            </div>
                            <div class="modal-body">
                                <form role="form" action="UpdatePasswordActionForStudent?id=${cookie.xueboStudentName.value}" method="post">
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">
                                            原密码
                                        </label>
                                        <input type="password" class="form-control" name="exampleInputPassword1" id="exampleInputPassword1" />
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword2">
                                            新密码
                                        </label>
                                        <input type="password" class="form-control" name="exampleInputPassword2" id="exampleInputPassword2" />
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword3">
                                            确认新密码
                                        </label>
                                        <input type="password" class="form-control" name="exampleInputPassword3" id="exampleInputPassword3" />
                                    </div>
                                    <button type="submit" class="btn btn-primary">
                                        确定修改
                                    </button>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 右边栏为学员的功能栏 -->
            <div class="col-md-8" style="margin-top: 100px; z-index: 1200;">
                <div class="tabbable" id="tabs-244684">
                    <ul class="nav nav-tabs">
                        <li class="nav-item">
                            <a class="nav-link active show" href="#panel-564201" data-toggle="tab">简介</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#panel-557746" data-toggle="tab">需求历史</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#panel-557747" data-toggle="tab">预约单</a>
                        </li>
                    </ul>
                    <!-- 简介查看修改功能 -->
                    <div class="tab-content">
                        <div class="tab-pane active show" id="panel-564201">
                            <br />
                            <dl>
                                <dt>
                                    个人简介
                                </dt>
                                <dd class="card">${student.studentintroduce }
                                </dd>
                                <dt style="padding-top: 20px">
                                    手机号码
                                </dt>
                                <dd class="card">${student.studentphone }
                                </dd>
                                <dt style="padding-top: 20px">
                                    个人邮箱
                                </dt>
                                <dd class="card">${student.studentemail }
                                </dd>
                            </dl>
                            <a id="modal-192373" href="#modal-container-192373" role="button" class="btn btn-primary btn-md" data-toggle="modal">修改个人信息</a>
                            <!-- 修改个人信息弹出框 -->
                            <div class="modal fade" id="modal-container-192373" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="padding-top: 90px">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="myModalLabel">修改个人信息</h5>
                                            <button type="button" class="close" data-dismiss="modal">
                                                <span aria-hidden="true">×</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <form role="form" action="UpdatePersonalActionForStudent?id=${cookie.xueboStudentName.value}" method="post">
                                                <div class="form-group">
                                                    <label for="exampleInputname2">
                                                        用户昵称
                                                    </label>
                                                    <input type="text" class="form-control" name="exampleInputname2" id="exampleInputname2" value="${student.studentname }"/>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputEmail1">
                                                        邮箱
                                                    </label>
                                                    <input type="email" class="form-control" name="exampleInputEmail1" id="exampleInputEmail1" value="${student.studentemail }"/>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputTel1">
                                                        手机号码
                                                    </label>
                                                    <input type="tel" class="form-control" name="exampleInputTel1" id="exampleInputTel1" value="${student.studentphone }"/>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleTextarea1">
                                                        个人简介
                                                    </label>
                                                    <textarea rows="4" cols="56" name="exampleTextarea1" id="exampleTextarea1">${student.studentintroduce }</textarea>
                                                </div>
                                                <button type="submit" class="btn btn-primary">
                                                    提交修改
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- 需求发布查看功能 -->
                        <div class="tab-pane" id="panel-557746">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>
                                        </th>
                                        <th>
                                            需求内容
                                        </th>
                                        <th>
                                            学习方向
                                        </th>
                                        <th>
                                            发布时间
                                        </th>
                                        <th>
                                            需求状态
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${demands }" var="demand">
                                	<tr>
                                        <td>${demand.order }
                                        </td>
                                        <td>
                                            <div class="line-limit-length" style="width: 200px">
                                                <p><a id="modal-181818" href="#modal-container-${demand.demandid }1818181" data-toggle="modal" style="color: black">${demand.demandcontent }</a>
                                                </p>
                                                <div class="modal fade" id="modal-container-${demand.demandid }1818181" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="padding-top: 150px">
                                                    <div class="modal-dialog" role="document">
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="myModalLabel">需求详细信息</h5>
                                                                <button type="button" class="close" data-dismiss="modal">
                                                                    <span aria-hidden="true">×</span>
                                                                </button>
                                                            </div>
                                                            <div class="modal-body">
                                            					<form role="form">
                                            						<div class="form-group">
                                                                   <label for="exampleInputTime1">
                                                                            见面时间:
                                                                        </label>
                                                                        <input class="form-control" id="exampleInputTime1" readonly="readonly" style="font-size: 16px;" type="text" value="${demand.demandmeetdate }"/>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="exampleInputadd1">
                                                                            见面地点:
                                                                        </label>
                                                                        <input class="form-control" id="exampleInputadd1" readonly="readonly" type="text" value="${demand.demandmeetaddress }"/>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="exampleTextarea2">
                                                                需求内容
                                                                </label>
                                                                <br>
                                                                <textarea cols="56" rows="4" id="exampleTextarea2" readonly="readonly">${demand.demandcontent }</textarea>
                                                            </div>
                                                            <c:if test="${demand.demandstate == 0 }">
                                                            	<div>
                                                            	<button class="btn btn-primary " type="button" onclick="delete_demand('demandid=${demand.demandid}&studentid=${demand.studentid }')">
                                                                    删除该需求
                                                                </button>
                                                            	</div>
                                                            </c:if>
                                                            <c:if test="${demand.demandstate == 1 }">
                                                            	
                                                            	<div class="form-group">
                                                                   <label for="exampleInputTime1">
                                                                            需求被专家接受的时间:
                                                                        </label>
                                                                        <input class="form-control" id="exampleInputTime2" readonly="readonly" style="font-size: 16px;" type="text" value="${demand.bookdate }"/>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="exampleInputadd1">
                                                                            需求预约专家姓名:
                                                                        </label>
                                                                        <input class="form-control" id="exampleInputExpert1" readonly="readonly" type="text" value="${demand.expertname }"/>
                                                            </div>
                                                            </c:if>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
                                        </td>
                                        <td>${demand.demandtype }
                                        </td>
                                        <td>${demand.demanddate }
                                        </td>
                                        <td>
                                            <c:if test="${demand.demandstate == 0 }">
                                            <strong><font style="color:orange">等待接受</font></strong>
                                            </c:if>
                                            <c:if test="${demand.demandstate == 1 }">
                                            <font style="color:green">已接受</font>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <a id="modal-192373" href="#modal-container-192375" role="button" class="btn btn-primary btn-md" data-toggle="modal">发布需求</a>
                            <!-- 发布需求弹出框 -->
                            <div class="modal fade" id="modal-container-192375" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true" style="padding-top: 90px">
                                <div class="modal-dialog" role="document">
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="myModalLabel">发布需求</h5>
                                            <button type="button" class="close" data-dismiss="modal">
                                                <span aria-hidden="true">×</span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                            <form role="form" action="DemandPublishActionForStudent?studentid=${cookie.xueboStudentName.value}" method="post">
                                                <div class="form-group">
                                                    <label for="exampleTextTime1">
                                                        见面时间
                                                    </label>
                                                    <input type="date" class="form-control" name="exampleInputTime1" id="exampleInputTime1"  />
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleText_1">
                                                        见面地点
                                                    </label>
                                                    <input type="text" class="form-control" name="exampleText_1" id="exampleText_1"  />
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleSelectWay2">
                                                        学习方向
                                                    </label>
													<select class="form-control" id="exampleSelectWay2" name="exampleSelectWay2">
														<option value="HTML/CSS" selected="selected">
															HTML/CSS</option>
														<option value="后端开发">后端开发</option>
														<option value="服务端">服务端</option>
														<option value="框架">框架</option>
													</select>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleTextarea2">
                                                        需求内容
                                                    </label>
                                                    <textarea rows="4" cols="56" name="exampleTextarea2" id="exampleTextarea2"></textarea>
                                                </div>
                                                <button type="submit" class="btn btn-primary">
                                                    发布
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <!-- 预约查看功能 -->
                        <div class="tab-pane" id="panel-557747">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>
                                        </th>
                                        <th>
                                            预约导师
                                        </th>
                                        <th>
                                            预约时间
                                        </th>
                                        <th>
                                            评价（0-5分）
                                        </th>
                                        <th>
                                            预约状态
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                
                                <c:forEach items="${books }" var="book">
                                    <tr>
                                        <td>${book.order }
                                        </td>
                                        <td>${book.expertname }
                                        </td>
                                        <td>${book.bookdate }
                                        </td>
                                        <td>
                                        	<c:if test="${book.bookstate == 4 }">
                                        		${book.bookassess }
                                        	</c:if>
                                        </td>
                                        <td>
											<c:choose>
												<c:when test="${book.bookstate == 0 }">
												<font style="color:red">预约失败</font>
												</c:when>
												<c:when test="${book.bookstate == 1 }">
												<font style="color:green">预约成功</font>
												</c:when>
												<c:when test="${book.bookstate == 2 }">
												<strong><font style="color:orange">预约中</font></strong>
												</c:when>
												<c:when test="${book.bookstate == 3 }">
												<strong><font style="color:blue">未评价</font></strong>
												</c:when>
												<c:when test="${book.bookstate == 4 }">
												已评分
												</c:when>
											</c:choose>
                                        </td>
                                        <td>
                                        	<c:if test="${book.bookstate == 2 }">
                                        		<a class="btn " data-toggle="modal" href="#modal-container-${book.bookid }812" id="modal-812" role="button" style="color: white; background-color: #0275d8 ;padding:5px ;font-size: 15px;">
                                                    查看预约
                                                </a>
                                                <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-${book.bookid }812" role="dialog">
                                                    <div class="modal-dialog" role="document" style="position: relative;margin-top: 80px;">
                                                        <!-- 调整弹出小窗口的位置 -->
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="myModalLabel">
                                                                    查看预约
                                                                </h5>
                                                                <button class="close" data-dismiss="modal" type="button">
                                                                    <span aria-hidden="true">
                                                                        ×
                                                                    </span>
                                                                </button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <form role="form">
                                                                    <div class="form-group">
                                                                        <label for="exampleInputTime1">
                                                                            见面时间:
                                                                        </label>
                                                                        <input class="form-control" id="exampleInputTime1" readonly="readonly" style="font-size: 16px;" type="text" value="${book.meetdate }"/>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="exampleInputadd1">
                                                                            见面地点:
                                                                        </label>
                                                                        <input class="form-control" id="exampleInputadd1" readonly="readonly" type="text" value="${book.meetaddress }"/>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="exampleInputContent1">
                                                                            上课内容:
                                                                        </label>
                                                                        <textarea cols="56" id="exampleInputContent1" readonly="readonly" rows="4" style="font-size: 16px;">${book.bookintroduce }</textarea>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button class="btn btn-primary" type="button" onclick="delete_book('${book.bookid}&studentid=${book.studentid }')">
                                                                    删除该预约
                                                                </button>
                                                                <button class="btn btn-secondary" data-dismiss="modal" type="submit">
                                                                    关闭
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                        	</c:if>
                                        	<c:if test="${book.bookstate ==0 }">
                                        	   <a class="btn " data-toggle="modal" href="#modal-container-${book.bookid }8121" id="modal-812" role="button" style="color: white; background-color: #0275d8 ;padding:5px ;font-size: 15px;">
                                                    查看预约
                                                </a>
                                                <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-${book.bookid }8121" role="dialog">
                                                    <div class="modal-dialog" role="document" style="position: relative;margin-top: 80px;">
                                                        <!-- 调整弹出小窗口的位置 -->
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="myModalLabel">
                                                                    查看预约
                                                                </h5>
                                                                <button class="close" data-dismiss="modal" type="button">
                                                                    <span aria-hidden="true">
                                                                        ×
                                                                    </span>
                                                                </button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <form role="form">
                                                                    <div class="form-group">
                                                                        <label for="exampleInputTime1">
                                                                            见面时间:
                                                                        </label>
                                                                        <input class="form-control" id="exampleInputTime1" readonly="readonly" style="font-size: 16px;" type="text" value="${book.meetdate }"/>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="exampleInputadd1">
                                                                            见面地点:
                                                                        </label>
                                                                        <input class="form-control" id="exampleInputadd1" readonly="readonly" type="text" value="${book.meetaddress }"/>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="exampleInputContent1">
                                                                            上课内容:（拒绝预约理由）
                                                                        </label>
                                                                        <textarea cols="56" id="exampleInputContent1" readonly="readonly" rows="4" style="font-size: 16px;">${book.bookintroduce }</textarea>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button class="btn btn-secondary" data-dismiss="modal" type="submit">
                                                                    关闭
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                        	</c:if>
                                        	<c:if test="${book.bookstate ==1 || book.bookstate ==3 || book.bookstate ==4}">
                                        	   <a class="btn " data-toggle="modal" href="#modal-container-${book.bookid }8122" id="modal-812" role="button" style="color: white; background-color: #0275d8 ;padding:5px ;font-size: 15px;">
                                                    查看预约
                                                </a>
                                                <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-${book.bookid }8122" role="dialog">
                                                    <div class="modal-dialog" role="document" style="position: relative;margin-top: 80px;">
                                                        <!-- 调整弹出小窗口的位置 -->
                                                        <div class="modal-content">
                                                            <div class="modal-header">
                                                                <h5 class="modal-title" id="myModalLabel">
                                                                    查看预约
                                                                </h5>
                                                                <button class="close" data-dismiss="modal" type="button">
                                                                    <span aria-hidden="true">
                                                                        ×
                                                                    </span>
                                                                </button>
                                                            </div>
                                                            <div class="modal-body">
                                                                <form role="form">
                                                                    <div class="form-group">
                                                                        <label for="exampleInputTime1">
                                                                            见面时间:
                                                                        </label>
                                                                        <input class="form-control" id="exampleInputTime1" readonly="readonly" style="font-size: 16px;" type="text" value="${book.meetdate }"/>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="exampleInputadd1">
                                                                            见面地点:
                                                                        </label>
                                                                        <input class="form-control" id="exampleInputadd1" readonly="readonly" type="text" value="${book.meetaddress }"/>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label for="exampleInputContent1">
                                                                            上课内容:
                                                                        </label>
                                                                        <textarea cols="56" id="exampleInputContent1" readonly="readonly" rows="4" style="font-size: 16px;">${book.bookintroduce }</textarea>
                                                                    </div>
                                                                </form>
                                                            </div>
                                                            <div class="modal-footer">
                                                                <button class="btn btn-secondary" data-dismiss="modal" type="submit">
                                                                    关闭
                                                                </button>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                        	</c:if>
                                        </td>
                                        <td>
                                        	<c:if test="${book.bookstate == 3 }">
                                        		<a class="btn " data-toggle="modal" href="#modal-container-${book.bookid }817139" id="modal-817139" role="button" style="color: white; background-color: #0275d8 ;padding:5px ;font-size: 15px;">
                                                    去评价
                                                </a>
                                            <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-${book.bookid }817139" role="dialog">
                                                <div class="modal-dialog" role="document" style="position: relative;margin-top: 80px;">
                                                    <!-- 调整弹出小窗口的位置 -->
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="myModalLabel">
                                                                    评价
                                                                </h5>
                                                            <button class="close" data-dismiss="modal" type="button">
                                                                <span aria-hidden="true">
                                                                        ×
                                                                    </span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <form role="form" action="AssessActionForStudent?bookid=${book.bookid }&studentid=${book.studentid }" method="post">
                                                                <div class="form-group">
                                                                    <label for="exampleInputContent1">
                                                                        评分：
                                                                    </label>
                                                                    <input id="zero" name="student_option" type="radio" value="0"/> 0
                                                                    <input id="one" name="student_option" type="radio" value="1"/>
                                                                        1
                                                                        <input id="two" name="student_option" type="radio" value="2"/>
                                                                        2
                                                                        <input id="three" name="student_option" type="radio" value="3"/>
                                                                        3
                                                                        <input id="four" name="student_option" type="radio" value="4"/>
                                                                        4
                                                                        <input id="five" name="student_option" type="radio" value="5"/>
                                                                        5
                                                                        <input id="six" name="student_option" type="radio" value="6"/>
                                                                        6
                                                                        <input id="seven" name="student_option" type="radio" value="7"/>
                                                                        7
                                                                        <input id="eight" name="student_option" type="radio" value="8"/>
                                                                        8
                                                                        <input id="nine" name="student_option" type="radio" value="9"/>
                                                                        9
                                                                        <input checked="checked" id="ten" name="student_option" type="radio" value="10"/>
                                                                        10
                                                                    </div>
                                                                    <button class="btn btn-primary " type="submit">
                                                                        提交
                                                                    </button>
                                                                </form>
                                                            </div>
                                                        </div>
                                                    </div>
                                                </div>
                                        		
                                        	</c:if>
                                        </td>
                                     </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                            <!-- <button type="button" class="btn btn-md btn-primary">
                                发布文章
                            </button> -->
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>