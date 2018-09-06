<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
        机构-简介[等你来报名]
    </title>
    <link href="css/First-message.css" rel="stylesheet"></link>
    <link href="images/xuebo.jpg" rel="shortcut icon"></link>
    <link href="css/homepage.css" rel="stylesheet"></link>
    <link href="css/bootstrap.min.css" rel="stylesheet"> </link>
    <link href="css/head.css" rel="stylesheet"></link>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
</head>

</html>

<body>
    <!-- 导航栏 -->
    <div class="guding" id="cont-acont">
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
    </div>
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-12" style="position: relative;margin-left: -15px;">
                <img alt="Bootstrap Image Preview" src="images/message_bg.png" />
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <img alt="Bootstrap Image Preview" class="rounded-circle" src="${organ.organizationimage }" style="position: relative;margin-left: 230px; margin-top: -100px; width: 160px;height:160px" />
                <div class="row">
                    <div class="col-md-8 c-md-8">
                        <h1>${organ.organizationname }
                        </h1>
                        <!--                         <p class="tutor-accomplish">
                            腾讯公司高级副总裁，微信创始人，Foxmail创始人
                        </p> -->
                        <p>
                            <img src="ui/location.png" width="12px"> ${organ.organizationadd }
                            </img>
                        </p>
                        <hr style="margin-top: 30px" />
                    </div>
                    <div class="col-md-4">
                        <div class="c-md-4" style="height: 170px">
                            <p class="about_tip1">
                                客服联系方式
                            </p>
                            <p class="about_tip2">
                                <b>${organ.organizationphone }
                                </b>
                            </p>
                            <p class="about_tip2" style="color: #666 ; font-size: 14px;">
                                24小时为你服务，欢迎来电咨询。
                            </p>
                            <a class="btn btn-1" data-toggle="modal" href="#modal-container-817139" id="modal-817139" role="button" style="color: white">
                                立即报名
                            </a>
                            <div aria-hidden="true" aria-labelledby="myModalLabel" class="modal fade" id="modal-container-817139" role="dialog">
                                <div class="modal-dialog" role="document" style="position: relative;margin-top: 80px;">
                                    <!-- 调整弹出小窗口的位置 -->
                                    <div class="modal-content">
                                        <div class="modal-header">
                                            <h5 class="modal-title" id="myModalLabel">
                                                报名详情
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
                                                    <label for="exampleInputname1">
                                                        姓名
                                                    </label>
                                                    <input class="form-control" id="exampleInputname1" />
                                                </div>
                                                <div class="form-group">                                        
                                                    <label for="exampleInputtel1">
                                                        联系方式
                                                    </label>
                                                    <input class="form-control" id="exampleInputtel1" />
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputdate1">
                                                        报名时间
                                                    </label>
                                                    <input type="date" class="form-control" id="exampleInputdate1" placeholder="您想与专家私下见面的时间" style="font-size: 16px;" />
                                                </div>
                                                <div class="form-group">
                                                    <label for="exampleInputcourse1">
                                                        报名课程
                                                    </label>
                                                    <textarea cols="56" id="exampleInputcourse1" rows="4" style="font-size: 16px;"></textarea>
                                                </div>
                                            </form>
                                        </div>
                                        <div class="modal-footer">
                                            <button class="btn btn-primary" type="submit">
                                                确认报名
                                            </button>
                                            <button class="btn btn-secondary" data-dismiss="modal" type="submit">
                                                关闭
                                            </button>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="row" style="margin-top: -50px">
        <div class="col-md-6" style="position: relative;margin-left: 160px;">
            <!-- 
                                    这里若统一用col-md-6的class定义margin-left，位置有点偏差，故直接用了style -->
            <h4>
            <b>
                关于机构
            </b>
            </h4>
            <img src="ui/down.png" width="20px" />
            <p>${organ.organizationintroduce }
            </p>
            <form role="form">
                <div class="form-group">
                    <label for="exampletextarea1">
                        开设课程
                    </label>
                    <textarea type="text" readonly="readonly" class="form-control" id="exampletextarea1" />${organ.organizationclass }</textarea>
                </div>
                <div class="form-group">
                    <label for="exampletext2">
                        培训费用（元）
                    </label>
                    <input type="text" readonly="readonly" value="${organ.organizationclass_price }" class="form-control" id="exampletext2" />
                </div>
                <div class="form-group">
                    <label for="exampletext2">
                        培训时长
                    </label>
                    <input type="text" readonly="readonly" value="不同课程时长不等，具体时长按所报课程为准！" class="form-control" id="exampletext2" />
                </div>
                <div class="form-group">
                    <label for="exampleInputtext1">
                        机构地点
                    </label>
                    <input type="text" readonly="readonly" value="${organ.organizationaddress }" class="form-control" id="exampleInputtext1" />
                </div>
            </form>
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
                    <img src="images/jinggong.png" style="position:relative;  " width="10px" /> 京公网安备11000002000150号
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