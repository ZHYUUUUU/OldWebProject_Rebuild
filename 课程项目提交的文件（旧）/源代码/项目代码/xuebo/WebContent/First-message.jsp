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
                张小龙-简介[等你来预约]
            </title>
            <link href="css/First-message.css" rel="stylesheet">
                <link href="images/xuebo.jpg" rel="shortcut icon">
                    <link href="css/homepage.css" rel="stylesheet">
                        <link href="css/bootstrap.min.css" rel="stylesheet">
                            <link href="css/head.css" rel="stylesheet">
                            </link>
                        </link>
                    </link>
                </link>
            </link>
        </meta>
    </head>
</html>
<script src="js/jquery.min.js">
</script>
<script src="js/bootstrap.min.js">
</script>
<script src="js/scripts.js">
</script>
<body>
    <!-- 导航栏 -->
    <div class="guding" id="cont-acont">
    <c:if test="${cookie.xueboStudentName.value != '' }">
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
                <li class="border" style="float:right;">
                    <a href="logout.jsp">
                        退出登录
                    </a>
                </li>
                <li class="border" style="float:right;">
                    <a href="PersonalActionForStudent?id=${cookie.xueboStudentName.value}" target="_blank">
                        个人主页
                    </a>
                </li>
            </ul>
        </div>
        <!-- 学博logo -->
        <a href="ShowHomepageAction?type=0" target="_blank">
            <img src="images/log4.png" style="position:relative; left:125px; top:-58px;" width="40px"/>
        </a>
    </c:if>
	<c:if test="${cookie.xueboExpertName.value != '' }">
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
                            <a href="PersonalActionForExpert?id=${cookie.xueboExpertName.value}">
                            个人主页
                        </a>
                        </li>
                    </ul>
                </div>
        <!-- 学博logo -->
        <a href="ShowHomepageAction?type=1" target="_blank">
            <img src="images/log4.png" style="position:relative; left:125px; top:-58px;" width="40px"/>
        </a>
	</c:if>
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12" style="position: relative;margin-left: -15px;">
                <img alt="Bootstrap Image Preview" src="images/message_bg.png"/>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <img alt="Bootstrap Image Preview" class="rounded-circle" src="${book.expertimage }" style="position: relative;margin-left: 230px; margin-top: -100px; width:140px;height:140px"/>
                <div class="row">
                    <div class="col-md-8 c-md-8">
                        <h1>${book.expertname }
                        </h1>
                        <p class="tutor-accomplish">${book.expertoccupation }
                        </p>
                        <p>
                            <img src="ui/location.png" width="12px">
                                ${expert.expertaddress }
                            </img>
                        </p>
                    </div>
                    <div class="col-md-4">
                        <div class="c-md-4">
                            <p class="about_tip1">
                                只需要
                                <b>
                                    几百元
                                </b>
                                ，就可以和专家
                            </p>
                            <p class="about_tip2">
                                <b>
                                    一对一约谈教学
                                </b>
                            </p>
                            <p class="about_tip2" style="color: #666 ; font-size: 14px;">
                                为您答疑解惑、出谋划策。不满意还能“无忧退款”。
                            </p>
                            <p style="position: relative;left: 290px; font-size: 16px; color: orange;">
                                学博
                            </p>
                            <c:if test="${cookie.xueboStudentName.value != '' }">
                            <a class="btn btn-1" data-toggle="modal" href="#modal-container-817139" id="modal-817139" role="button" style="color: white">
                                立即预约该专家
                            </a>
                            <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-817139" role="dialog">
                                <div class="modal-dialog" role="document" style="position: relative;margin-top: 80px;">
                                    <!-- 调整弹出小窗口的位置 -->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="myModalLabel">
                                                预约详情
                                            </h5>
                                            <button class="close" data-dismiss="modal" type="button">
                                                <span aria-hidden="true">
                                                    ×
                                                </span>
                                            </button>
                                        </div>
                                        <div class="modal-body">
                                        	<form role="form" action="BookActionForStudent?studentid=${cookie.xueboStudentName.value}&expertid=${book.expertid }" method="post">
                                                <div class="form-group">
                                                    <label for="exampleInputEmail1">
                                                        见面时间
                                                    </label>
                                                    <input type="date" class="form-control" name="exampleInputDate1" id="exampleInputDate1" placeholder="您想与专家私下见面的时间" style="font-size: 16px;"/>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputPassword1">
                                                        见面地点
                                                    </label>
                                                    <input class="form-control" name="exampleInputAddress1" id="exampleInputAddress1" placeholder="您想与专家私下见面的地点"/>
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputContent1">
                                                        上课内容
                                                    </label>
                                                    <textarea cols="56" name="exampleInputContent1" id="exampleInputContent1" rows="4" style="font-size: 16px;"></textarea>
                                                </div>
                                         <div class="modal-footer">
                                            <button class="btn btn-primary" type="submit">
                                                确认预约
                                            </button>
                                            
                                            <button class="btn btn-secondary" data-dismiss="modal" type="submit">
                                                关闭
                                            </button>
                                            
                                        </div>
                                            </form>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </c:if>
                        </div>
                    </div>
                </div>
				<div class="row">
                    <div class="col-md-6">
                        <div class="tutor-top">
                            <img src="ui/price.png" width="20px"/>
                            <span style=" font-size: 18px;">
                                <b>${book.expertprice }元
                                </b>
                                /次
                            </span>
                            <span style="position: relative;margin-left: 470px; font-size: 18px;">
                                <b>${book.avg_bookassess }分
                                </b>
                            </span>
                        </div>
                     </div>
                 </div>
                 <div class="row" style="line-height:300%">
                    <div class="col-md-6">
                    <strong><font style="font-size:24px">•&nbsp;专家文章</font></strong>
                     </div>
                 </div>
                 <c:forEach items="${articles }" var="article">
                 <div class="row">
                    <div class="col-md-6">
                        <blockquote class="blockquote">
                            <h5 class="mb-0">
                                <a href="ShowArticleReadAction?articleid=${article.articleid }" target="_blank">${article.order }.&nbsp;&nbsp;${article.articletitle }
                                </a>
                            </h5>
                            <footer class="blockquote-footer" style="overflow: hidden;text-overflow: ellipsis;white-space: nowrap;">
                                <!-- 以上style为省略文本 -->
                                ${article.articlecontent }
                            </footer>
                        </blockquote>
                    </div>
                </div>
                </c:forEach>
            </div>
        </div>
    </div>


<hr style="position: relative;margin-left: 150px; " width="680px"/>
<div class="row">
    <div class="col-md-6" style="position: relative;margin-left: 160px;">
        <!-- 
                                    这里若统一用col-md-6的class定义margin-left，位置有点偏差，故直接用了style -->
        <h4>
            <b>
                •&nbsp;关于专家
            </b>
        </h4>
        <img src="ui/down.png" width="20px" />
            <p>
              ${expert.expertintroduce }
            </p> 
            <p>
                一系列主要成就有：（研究成果）
            </p>
            <p>
            	${expert.expertresearch }
            </p>

       
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
                <a href="homepage.jsp">
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
        <p style="position: relative;top: -20px;">
            住址：广东省深圳市龙岗区布吉新区上雪科技园(北区)
        </p>
        <p style="position: relative;top: -32px;">
            电话：18244993589
        </p>
    </div>
</div>
</body>