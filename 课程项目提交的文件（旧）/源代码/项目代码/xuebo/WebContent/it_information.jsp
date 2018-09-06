<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <title>导航-业内行情</title>
    <link href="css1/font-awesome.css" rel="stylesheet">
<link rel="stylesheet" href="css/homepage.css">
<script type="text/javascript" src="js/jquery-1.10.1.min.js "></script>
<script type="text/javascript " src="js/google-maps.js "></script>
<script>$(document).ready(function(){$(".vertical-nav ").verticalnav({speed: 400,align: "left "});});</script>
</head>
<body>
<div style="text-align:center;clear:both; ">
<script src="/gg_bd_ad_720x90.js " type="text/javascript "></script>
<script src="/follow.js " type="text/javascript "></script>
</div>

<div class="guding" id="cont-acont" >
        <div id="cont-a" style="padding-top: 9px;">
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

<div id="page_content "  >
        <iframe id="menuFrame " name="menuFrame " src="it_information_list.jsp " frameborder="no " width="100% "  scrolling="no " height="700 " align="right " >
        </iframe>
</div>




<div class="kePublic " style="position: fixed; top: 60px; left:115px ; z-index: 2000">
<!--效果html开始-->
<div class="content ">
	<ul class="vertical-nav red ">
		<li class="active "><a href="it_information_list.jsp " target="menuFrame "><i class="icon-home "></i>HTML/CSS</a></li>
		<li><a href="it_information_list.jsp" target="menuFrame "><i class="icon-cogs "></i>后端开发</a>
		<!-- <span class="submenu-icon "></span> -->
		</li>
		<li><a href="it_information_list.jsp " target="menuFrame "><i class="icon-briefcase "></i>服务端</a>
		<!-- <span class="submenu-icon "></span> -->
		<!-- <ul>
			<li><a href="http://www.internetke.com/ ">二级导航</a></li>
			<li><a href="http://www.internetke.com/ ">二级导航</a></li>
			<li><a href="http://www.internetke.com/ ">二级导航<span class="submenu-icon "></span></a><ul>
				<li><a href="http://www.internetke.com/ ">三级导航</a></li>
				<li><a href="http://www.internetke.com/ ">三级导航</a></li>
				<li><a href="http://www.internetke.com/ ">三级导航 <span class="submenu-icon "></span>
				</a>
				<ul>
					<li><a href="http://www.internetke.com/ ">四级导航</a></li>
					<li><a href="http://www.internetke.com/ ">四级导航</a></li>
					<li><a href="http://www.internetke.com/ ">四级导航</a></li>
					<li><a href="http://www.internetke.com/ ">四级导航</a></li>
				</ul>
				</li>
				<li><a href="http://www.internetke.com/ ">三级导航</a></li>
			</ul>
			</li>
			<li><a href="http://www.internetke.com/ ">二级导航</a></li>
			<li><a href="http://www.internetke.com/ ">二级导航</a></li>
		</ul> -->
		</li>
		<li><a href="it_information_list.jsp" target="menuFrame "><i class="icon-user "></i>移动开发</a></li>
		<!-- <li><a href="http://www.internetke.com/ "><i class="icon-comments-alt "></i>博客</a></li>
		<li><a href="http://www.internetke.com/ "><i class="icon-picture "></i>导航</a></li>
		<li><a href="http://www.internetke.com/ "><i class="icon-info "></i>信息</a></li>
		<li><a href="http://www.internetke.com/ "><i class="icon-group "></i>团队</a></li>
		<li><a href="http://www.internetke.com/ "><i class="icon-question "></i>常见问题</a></li>
		<li><a href="http://www.internetke.com/ "><i class="icon-bar-chart "></i>案例</a></li>
		<li><a href="http://www.internetke.com/ "><i class="icon-envelope "></i>联系我们</a></li> -->
	</ul>
</div>
</div>
<!--效果html结束-->

	



</body>
</html>