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
    <link href="css/index.css" rel="stylesheet" type="text/css">
    <link href="css/head.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    <script>
    function check(checkedRadio) {
        checkedRadio.checked = true;
        if (checkedRadio.value == '1') {
            document.getElementById("ipAddress").style.display = 'none';
        } else if (checkedRadio.value == '2') {
            document.getElementById("ipAddress").style.display = '';
        }
    }

    function finishBook(id){
    	window.location = "FinishBookActionForExpert?" + id;
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
                        <li style="float:right;">
                            <a href="logout.jsp">
                            退出登录
                        </a>
                        </li>
                        <li style="float:right;">
                            <a href="PersonalActionForExpert?id=${cookie.xueboExpertName.value}">
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
        <div class="row">
            <!-- 左边栏为专家个人信息栏 -->
            <div class="col-md-3 personer-imformation" style="z-index: 1300">
                <div class="row">
                	<div class="img-center">
                        <!-- 点击上传界面 -->
                        <a class="btn btn-md" data-toggle="modal" href="#modal-container-1923721" id="modal-1923721" role="button">                        
                            <img alt="Bootstrap Image Preview" class="rounded-circle" src="${expert.expertimage }" width="140px" height="140px"/>
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
                                    <form role="form" method="post" action="UploadAction?id=${cookie.xueboExpertName.value }&type=1" enctype="multipart/form-data">
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
                <h4 class="text-center text-white">${expert.expertname }</h4>
                <div class="text-white text-center card" style="padding: 10px; margin-top: 40px;margin-bottom: 40px">
                    ${expert.expertoccupation }
                </div>
                <div class="page-footer">
                    <address class="text-center text-white">
                        <img src="ui/address.png" alt="">
                        <strong>${expert.expertaddress }</strong>
                        <br />
                        <abbr title="Phone">P:</abbr> ${expert.expertphone }
                    </address>
                </div>
                <div class="card" style="padding-top: 10px; margin-top: 140px">
                    <h6 class="text-center text-white">账号：${cookie.xueboExpertName.value}</h6>
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
                                <form role="form" action="UpdatePasswordActionForExpert?id=${cookie.xueboExpertName.value}" method="post">
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
            <!-- 右边栏为专家的功能栏 -->
            <div class="col-md-8" style="margin-top: 100px; z-index: 1200;">
                <div class="tabbable" id="tabs-244684">
                    <ul class="nav nav-tabs">
                        <li class="nav-item">
                            <a class="nav-link active show" href="#panel-564201" data-toggle="tab">简介</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#panel-557747" data-toggle="tab">文章</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#panel-557760" data-toggle="tab">预约详情</a>
                        </li>
                    </ul>
                    <div class="tab-content">
                        <div class="tab-pane active show" id="panel-564201">
                            <br />
                            <dl>
                                <dt>
                                    个人简介
                                </dt>
                                <dd class="card">${expert.expertintroduce }
                                </dd>
                                <dt style="padding-top: 20px">
                                    研究成果
                                </dt>
                                <dd class="card">${expert.expertresearch }
                                </dd>
                                <dt style="padding-top: 20px">
                                    教育方向
                                </dt>
                                <dd class="card">${expert.experttype }
                                </dd>
                                <dt style="padding-top: 20px">
                                    预约价格（元/天）
                                </dt>
                                <dd class="card">${expert.expertprice }
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
                                            <form role="form"  action="UpdatePersonalActionForExpert?id=${cookie.xueboExpertName.value}" method="post">
                                                <div class="form-group">
                                                    <label for="exampleInputname1">
                                                        姓名
                                                    </label>
                                                    <input type="text" class="form-control" name="exampleInputname1" id="exampleInputname1" value="${expert.expertname }"/>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputEmail1">
                                                        邮箱
                                                    </label>
                                                    <input type="email" class="form-control" name="exampleInputEmail1" id="exampleInputEmail1" value="${expert.expertemail }"/>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputadd1">
                                                        地址
                                                    </label>
                                                    <input type="text" class="form-control" name="exampleInputadd1" id="exampleInputadd1" value="${expert.expertaddress }"/>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputoccupation1">
                                                        职位
                                                    </label>
                                                    <input type="text" class="form-control" name="exampleInputoccupation1" id="exampleInputoccupation1" value="${expert.expertoccupation }"/>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputTel1">
                                                        手机号码
                                                    </label>
                                                    <input type="tel" class="form-control" name="exampleInputTel1" id="exampleInputTel1" value="${expert.expertphone }"/>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleTextarea1">
                                                        个人简介
                                                    </label>
                                                    <textarea rows="4" cols="56" name="exampleTextarea1" id="exampleTextarea1">${expert.expertintroduce }</textarea>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleText1">
                                                        研究成果
                                                    </label>
                                                    <input type="text" class="form-control" name="exampleText1" id="exampleText1" value="${expert.expertresearch }"/>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleText2">
                                                        教育方向
                                                    </label>
													<%
														expert = (Expert) session.getAttribute("expert");
														String type = expert.getExperttype();
														if (type.equals("HTML/CSS")) {
													%>
													<select class="form-control" name="experttype">
														<option value="HTML/CSS" selected="selected">
															HTML/CSS</option>
														<option value="后端开发">后端开发</option>
														<option value="服务端">服务端</option>
														<option value="框架">框架</option>
													</select>
													<%
														} else if (type.equals("后端开发")) {
													%>
													<select class="form-control" name="experttype">
														<option value="HTML/CSS">HTML/CSS</option>
														<option value="后端开发" selected="selected">后端开发</option>
														<option value="服务端">服务端</option>
														<option value="框架">框架</option>
													</select>
													<%
														} else if (type.equals("服务端")) {
													%>
													<select class="form-control" name="experttype">
														<option value="HTML/CSS">HTML/CSS</option>
														<option value="后端开发">后端开发</option>
														<option value="服务端" selected="selected">服务端</option>
														<option value="框架">框架</option>
													</select>
													<%
														}else if(type.equals("框架")){
													%>
													<select class="form-control" name="experttype">
														<option value="HTML/CSS">HTML/CSS</option>
														<option value="后端开发">后端开发</option>
														<option value="服务端">服务端</option>
														<option value="框架" selected="selected">框架</option>
													</select>
													<%
														}
													%>
												</div>
                                                <div class="form-group">
                                                    <label for="exampleText3">
                                                        预约价格
                                                    </label>
                                                    <input type="text" class="form-control" onkeyup="this.value=this.value.replace(/\D/g, '')" name="exampleText3" id="exampleText3" value="${expert.expertprice }"/>
                                                </div>
                                                <button type="submit" class="btn btn-primary ">
                                                    提交修改
                                                </button>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="tab-pane" id="panel-557747">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>
                                            #
                                        </th>
                                        <th>
                                            文章标题
                                        </th>
                                        <th>
                                            发布时间
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                	<c:forEach items="${articles }" var="article">
                                	<tr>
                                        <td>${article.order }
                                        </td>
                                        <td>
                                            <a href="ShowArticleReadAction?articleid=${article.articleid }" target="_blank">${article.articletitle }</a>
                                        </td>
                                        <td>${article.publishdate }
                                        </td>
                                    </tr>
                                	</c:forEach>
                                </tbody>
                            </table>
                            <a href="article_write.jsp" target="_blank" class="btn btn-primary btn-md">发布文章</a>
                        </div>
                        <div class="tab-pane" id="panel-557760">
                            <table class="table table-hover">
                                <thead>
                                    <tr>
                                        <th>
                                        </th>
                                        <th>
                                            学员姓名
                                        </th>
                                        <th>
                                            预约时间
                                        </th>
                                        <th>
                                            预约状态
                                        </th>
                                        <th>
                                        </th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${books }" var="book">
                                       	<tr>
                                        <td>${book.order }
                                        </td>
                                        <td>${book.studentname }
                                        </td>
                                        <td>${book.bookdate }
                                        </td>
                                        <td>
											<c:choose>
												<c:when test="${book.bookstate == 0 }">
												<font style="color:red">不接受</font>
												</c:when>
												<c:when test="${book.bookstate == 1 }">
												<strong><font style="color:green">已接受</font></strong>
												</c:when>
												<c:when test="${book.bookstate == 2 }">
												<strong><font style="color:orange">未接受</font></strong>
												</c:when>
												<c:when test="${book.bookstate == 3 }">
												<font style="color:blue">待评价</font>
												</c:when>
												<c:when test="${book.bookstate == 4 }">
												已评分
												</c:when>
											</c:choose>
										</td>
										<td>
											<c:choose>
												<c:when test="${book.bookstate == 0 }">
											<a class="btn " data-toggle="modal" href="#modal-container-${book.bookid }321" id="modal-817139" role="button" style="color: white; background-color: #0275d8 ;padding:5px ;font-size: 5px;">
                                            查看预约
                                            </a>
                                            <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-${book.bookid }321" role="dialog">
                                                <div class="modal-dialog" role="document" style="position: relative;margin-top: 80px;">
                                                    <!-- 调整弹出小窗口的位置 -->
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="myModalLabel">
                                                学员预约
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
                                                                    <input type="text" class="form-control" name="exampleInputTime1" id="exampleInputTime1" readonly="readonly" style="font-size: 16px;" value="${book.meetdate }"/>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputadd1">
                                                                        见面地点:
                                                                    </label>
                                                                    <input type="text" class="form-control" name="exampleInputadd1" id="exampleInputadd1" readonly="readonly" value="${book.meetaddress }"/>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputTel1">
                                                                        联系电话:
                                                                    </label>
                                                                    <input class="form-control" name="exampleInputTel1" id="exampleInputTel1" type="text" readonly="readonly" value="${book.studentphone }"/>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputContent1">
                                                                        上课内容:（拒绝预约理由）
                                                                    </label>
                                                                    <textarea cols="56" name="exampleInputContent1" id="exampleInputContent1" readonly="readonly" rows="4" style="font-size: 16px;">${book.bookintroduce }</textarea>
                                                                </div>
                                                            </form>
                                                        </div>
												</c:when>
												<c:when test="${book.bookstate == 1 }">
											<a class="btn " data-toggle="modal" href="#modal-container-${book.bookid }123" id="modal-817139" role="button" style="color: white; background-color: #0275d8 ;padding:5px ;font-size: 5px;">
                                            查看预约
                                            </a>
                                            <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-${book.bookid }123" role="dialog">
                                                <div class="modal-dialog" role="document" style="position: relative;margin-top: 80px;">
                                                    <!-- 调整弹出小窗口的位置 -->
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="myModalLabel">
                                                学员预约
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
                                                                    <input type="text" class="form-control" name="exampleInputTime1" id="exampleInputTime1" readonly="readonly" style="font-size: 16px;" value="${book.meetdate }"/>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputadd1">
                                                                        见面地点:
                                                                    </label>
                                                                    <input type="text" class="form-control" name="exampleInputadd1" id="exampleInputadd1" readonly="readonly" value="${book.meetaddress }"/>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputTel1">
                                                                        联系电话:
                                                                    </label>
                                                                    <input class="form-control" name="exampleInputTel1" id="exampleInputTel1" type="text" readonly="readonly" value="${book.studentphone }"/>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputContent1">
                                                                        上课内容:
                                                                    </label>
                                                                    <textarea cols="56" name="exampleInputContent1" id="exampleInputContent1" readonly="readonly" rows="4" style="font-size: 16px;">${book.bookintroduce }</textarea>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputAssess1">
                                                                       评分:
                                                                    </label>
                                                                    <input class="form-control" name="exampleInputAssess1" id="exampleInputAssess1" type="text" readonly="readonly" value="——请在完成预约后等待学员评分——"/>
                                                                </div>
                                                                </form>
                                                                </div>
                                                        </div>
												</c:when>
												<c:when test="${book.bookstate == 2 }">
											<a class="btn " data-toggle="modal" href="#modal-container-${book.bookid }312" id="modal-817139" role="button" style="color: white; background-color: #0275d8 ;padding:5px ;font-size: 5px;">
                                            查看预约
                                            </a>
                                            <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-${book.bookid }312" role="dialog">
                                                <div class="modal-dialog" role="document" style="position: relative;margin-top: 80px;">
                                                    <!-- 调整弹出小窗口的位置 -->
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="myModalLabel">
                                                学员预约
                                            </h5>
                                                            <button class="close" data-dismiss="modal" type="button">
                                                                <span aria-hidden="true">
                                                    ×
                                                </span>
                                                            </button>
                                                        </div>
                                                        <div class="modal-body">
                                                            <form role="form" action="AcceptBookActionForExpert?bookid=${book.bookid }&expertid=${book.expertid}" method="post">
                                                                <div class="form-group">
                                                                    <label for="exampleInputTime1">
                                                                        见面时间:
                                                                    </label>
                                                                    <input type="text" class="form-control" name="exampleInputTime1" id="exampleInputTime1" readonly="readonly" style="font-size: 16px;" value="${book.meetdate }"/>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputadd1">
                                                                        见面地点:
                                                                    </label>
                                                                    <input type="text" class="form-control" name="exampleInputadd1" id="exampleInputadd1" readonly="readonly" value="${book.meetaddress }"/>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputTel1">
                                                                        联系电话:
                                                                    </label>
                                                                    <input class="form-control" name="exampleInputTel1" id="exampleInputTel1" type="text" readonly="readonly" value="${book.studentphone }"/>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputContent1">
                                                                        上课内容:
                                                                    </label>
                                                                    <textarea cols="56" name="exampleInputContent1" id="exampleInputContent1" readonly="readonly" rows="4" style="font-size: 16px;">${book.bookintroduce }</textarea>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label>
                                                                        是否接受
                                                                    </label>
                                                                    <input checked="checked" id="yes" name="expert_option" onclick="check(this)" type="radio" value="1" /> 是
                                                                    <input id="no" name="expert_option" onclick="check(this)" type="radio" value="2" /> 否
                                                                    <div>
                                                                        <textarea cols="45" id="ipAddress" name="_ipAddress" rows="3" style="display: none;" onfocus="if(value=='请输入拒绝理由'){value=''}" onblur="if (value ==''){value='请输入拒绝理由'}">请输入拒绝理由</textarea>
                                                                    </div>
                                                                </div>
                                                                <button class="btn btn-primary " type="submit">
                                                                    提交
                                                                </button>
                                                                </form>
                                                                </div>
                                                        </div>
												</c:when>
												<c:when test="${book.bookstate == 3 }">
											<a class="btn " data-toggle="modal" href="#modal-container-${book.bookid }132" id="modal-817139" role="button" style="color: white; background-color: #0275d8 ;padding:5px ;font-size: 5px;">
                                            查看预约
                                            </a>
                                            <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-${book.bookid }132" role="dialog">
                                                <div class="modal-dialog" role="document" style="position: relative;margin-top: 80px;">
                                                    <!-- 调整弹出小窗口的位置 -->
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="myModalLabel">
                                                学员预约
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
                                                                    <input type="text" class="form-control" name="exampleInputTime1" id="exampleInputTime1" readonly="readonly" style="font-size: 16px;" value="${book.meetdate }"/>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputadd1">
                                                                        见面地点:
                                                                    </label>
                                                                    <input type="text" class="form-control" name="exampleInputadd1" id="exampleInputadd1" readonly="readonly" value="${book.meetaddress }"/>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputTel1">
                                                                        联系电话:
                                                                    </label>
                                                                    <input class="form-control" name="exampleInputTel1" id="exampleInputTel1" type="text" readonly="readonly" value="${book.studentphone }"/>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputContent1">
                                                                        上课内容:
                                                                    </label>
                                                                    <textarea cols="56" name="exampleInputContent1" id="exampleInputContent1" readonly="readonly" rows="4" style="font-size: 16px;">${book.bookintroduce }</textarea>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputAssess1">
                                                                       评分:
                                                                    </label>
                                                                    <input class="form-control" name="exampleInputAssess1" id="exampleInputAssess1" type="text" readonly="readonly" value="——请等待学员为您评分——"/>
                                                                </div>
                                                                </form>
                                                                </div>
                                                        </div>
												</c:when>
												<c:when test="${book.bookstate == 4 }">
											<a class="btn " data-toggle="modal" href="#modal-container-${book.bookid }324" id="modal-817139" role="button" style="color: white; background-color: #0275d8 ;padding:5px ;font-size: 5px;">
                                            查看预约
                                            </a>
                                            <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-${book.bookid }324" role="dialog">
                                                <div class="modal-dialog" role="document" style="position: relative;margin-top: 80px;">
                                                    <!-- 调整弹出小窗口的位置 -->
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="myModalLabel">
                                                学员预约
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
                                                                    <input type="text" class="form-control" name="exampleInputTime1" id="exampleInputTime1" readonly="readonly" style="font-size: 16px;" value="${book.meetdate }"/>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputadd1">
                                                                        见面地点:
                                                                    </label>
                                                                    <input type="text" class="form-control" name="exampleInputadd1" id="exampleInputadd1" readonly="readonly" value="${book.meetaddress }"/>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputTel1">
                                                                        联系电话:
                                                                    </label>
                                                                    <input class="form-control" name="exampleInputTel1" id="exampleInputTel1" type="text" readonly="readonly" value="${book.studentphone }"/>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputContent1">
                                                                        上课内容:
                                                                    </label>
                                                                    <textarea cols="56" name="exampleInputContent1" id="exampleInputContent1" readonly="readonly" rows="4" style="font-size: 16px;">${book.bookintroduce }</textarea>
                                                                </div>
                                                                <div class="form-group">
                                                                    <label for="exampleInputAssess1">
                                                                       评分:
                                                                    </label>
                                                                    <input class="form-control" name="exampleInputAssess1" id="exampleInputAssess1" type="text" readonly="readonly" value="${book.bookassess }"/>
                                                                </div>
                                                                </form>
                                                                </div>
                                                        </div>
												</c:when>
											</c:choose>
										</td>
										<td>
											<c:if test="${book.bookstate == 1 }">
											    <a class="btn " data-toggle="modal" href="#modal-container-${book.bookid }813" id="modal-813" role="button" style="color: white; background-color: #0275d8 ;padding:5px ;font-size: 5px;">
                                                    完成预约
                                                </a>
                                            <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-${book.bookid }813" role="dialog">
                                                <div class="modal-dialog" role="document" style="position: relative;margin-top: 80px;">
                                                    <!-- 调整弹出小窗口的位置 -->
                                                    <div class="modal-content">
                                                        <div class="modal-header">
                                                            <h5 class="modal-title" id="myModalLabel">
                                                                    完成预约
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
                                                                    <label>
                                                                        是否已完成本次预约？
                                                                        <br>
                                                                        （此操作不能恢复，请慎重选择~）
                                                                    </label>
                                                                </div>
                                                                <button class="btn btn-primary " type="button" onclick="finishBook('bookid=${book.bookid}&expertid=${book.expertid }')">
                                                                    &nbsp; 是 &nbsp; 
                                                                </button>
                                                                <button class="btn btn-secondary" data-dismiss="modal" type="button">
                                                                    &nbsp; 否 &nbsp; 
                                                                </button>
                                                            </form>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>
											</c:if>
										</td>
                        		</c:forEach>
                                </tbody>
                            </table>
                            </div>
                            </div>
                            </div>
                        </div>
                    </div>
                </div>
</body>

</html>