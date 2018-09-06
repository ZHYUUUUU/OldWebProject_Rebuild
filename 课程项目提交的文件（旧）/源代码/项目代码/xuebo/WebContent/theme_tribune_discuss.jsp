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
    <title>评论</title>
    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
    <link href="images/xuebo.jpg" rel="shortcut icon">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/page.css" rel="stylesheet">
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</head>

<body>
    <div class="page_nav" style="background-color: #2e323e">
        <div class="page_a">
            <img src="images/xuebo.jpg" style="position:relative;  top:25px;" width="30" />
            <div style="position: relative; top:0px; font-size: 16px; left:38px; color: white">
                学博
            </div>
            <div class="page_b">
                <a href="#" style=" position: relative; left: 30px; top: 5px; color: white">
                        关于我们
                    </a>
                <a href="#" style="position: relative; left:50px; top: 5px; color: white ">
                        帮助
                    </a>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="col-md-3">
        </div>
        <div class="col-md-6" style="margin-top: 40px;z-index: 1200; background-color: #FFFFFF">
                <div class="form-group">
                    <label for="exampleInputText1">
                        <h3>${tribune.tribunetitle } </h1>
                        </label>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputTextarea1" style="color: #7D7D7D">
						${tribune.tribunetheme }
                        </label>
                    </div>
                    <hr>
                    <div class="form-group">
                        <div class="media" >
                            <img class="mr-3" alt="Bootstrap Media Preview" src="${tribune.creatorimage }" width=64px height=64px/>
                            <div class="media-body">
                                <h5 class="mt-0">
                                    ${tribune.creator }
                                </h5> ${tribune.tribunecontent }
                                <div class="media mt-3">
                                 <a class="btn btn-md" data-toggle="modal" href="#modal-container-817139" id="modal-817139" role="button">
                                            评论
                                        </a>
                                        <font style="font-size:14px;position: relative;left:300px;top:10px;">${tribune.createdate }</font>
                                        <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-817139" role="dialog">
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
                                                    <c:if test="${cookie.xueboExpertName.value == '' && cookie.xueboStudentName.value != ''}">
                                                   	<form role="form" action="PublishDiscussAction?id=${cookie.xueboStudentName.value }&tribuneid=${tribune.tribuneid}&type=0&state=1" method="post">                                                            
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
                                                    </c:if>
                                                    <c:if test="${cookie.xueboExpertName.value != '' && cookie.xueboStudentName.value == ''}">
                                                   	<form role="form" action="PublishDiscussAction?id=${cookie.xueboExpertName.value }&tribuneid=${tribune.tribuneid}&type=1&state=1" method="post">                                                            
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
                                                    </c:if>

                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                </div>
                                <hr />
                                <c:forEach items="${discusses }" var="discuss">
                                <div class="media mt-3">
                                     <a class="pr-3"><img alt="Bootstrap Media Another Preview" src="${discuss.discussimage }" width=64px height=64px/></a>
                                    <div class="media-body">
                                        <h5 class="mt-0">
                                            ${discuss.discussname }
                                        </h5> ${discuss.discusscontent }
                                        <c:if test="${cookie.xueboExpertName.value == discuss.expertid || cookie.xueboStudentName.value == discuss.studentid }">
                                        <br><a class="btn btn-md" data-toggle="modal" href="#modal-container-${discuss.discussid }817141" id="modal-817141" role="button">
                                            删除
                                        </a>
                                        
                                        <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-${discuss.discussid }817141" role="dialog">
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
                                                        <form role="form" action="DeleteDiscussAction?discussid=${discuss.discussid }&tribuneid=${discuss.tribuneid}" method="post">
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
                                        </c:if>
                                        <br><font style="font-size:14px;position: relative;left:290px;top:10px">${discuss.discussdate }</font>
                                    </div>
                                </div>
                                <hr />
                                </c:forEach>
                            </div>
                        </div>
                    </div>
                    <button type="submit" class="btn btn-primary data-dismiss="modal" onclick="window.close();">
                       关闭
                    </button>
            </div>
            <div class="col-md-3">
            </div>
        </div>
</body>

</html>