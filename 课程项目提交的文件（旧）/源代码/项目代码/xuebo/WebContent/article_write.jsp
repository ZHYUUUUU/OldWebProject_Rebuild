<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <title>个人主页</title>
    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
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
            <div class="col-md-3">
            </div>
            <div class="col-md-6" style="margin-top: 100px; z-index: 1200;">
                <form role="form" action="ArticlePublishActionForExpert?id=${cookie.xueboExpertName.value }" method="post">
                    <div class="form-group">
                        <label for="exampleInputText1">
                            文章标题
                        </label>
                        <input type="text" class="form-control" name="exampleInputText1" id="exampleInputText1" />
                    </div>
                    <div class="form-group">
                    	<label for="exampleSelectWay2">
                            文章教育方向
                        </label>
                        <select class="form-control" id="exampleSelectWay2" name="exampleSelectWay2">
							<option value="HTML/CSS" selected="selected">HTML/CSS</option>
							<option value="后端开发">后端开发</option>
							<option value="服务端">服务端</option>
							<option value="框架">框架</option>
						</select>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputTextarea1">
                            文章内容
                        </label>
                        <textarea rows="20" class="form-control" name="exampleInputTextarea1" id="exampleInputTextarea1" ></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary data-dismiss="modal">
                        确认发布
                    </button>
                </form>
            </div>
            <div class="col-md-3">
            </div>
        </div>
    </div>
</body>

</html>