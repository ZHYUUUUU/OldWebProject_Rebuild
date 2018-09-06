<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="utf-8"></meta>
    <title>
        导航-教育机构
    </title>
    <link href="images/xuebo.jpg" rel="shortcut icon"></link>
    <link href="css/head.css" rel="stylesheet"></link>
    <link href="css/bootstrap.min.css" rel="stylesheet"></link>
    <!--  <link href="css/bootstrap1.min.css" rel="stylesheet" type="text/css"></link> -->
    <link href="css/Firstoption.css" rel="stylesheet"></link>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>    
</head>

<body>
    <div>
        <div id="cont-acont">
            <div id="cont-a">
                <ul>
                    <li class="border">
                        <a href="ShowFirstoptionListAction">
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
                <img src="images/log4.png" style="position:fixed; left:125px; top:10px;" width="40px"/>
            </a>
        </div>
    </div>
    <div class="row">
        <div class="col-md-12">
            <div class="carousel slide" id="carousel-86736">
                <ol class="carousel-indicators">
                    <li data-slide-to="0" data-target="#carousel-86736" class="active">
                    </li>
                    <li data-slide-to="1" data-target="#carousel-86736">
                    </li>
                    <li data-slide-to="2" data-target="#carousel-86736">
                    </li>
                </ol>
                <div class="carousel-inner">
                    <div class="carousel-item active">
                        <img class="d-block w-100" alt="Carousel Bootstrap First" src="images/banner_1.png" />
                        <div class="carousel-caption">
                            <h4>
                                First Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" alt="Carousel Bootstrap Second" src="images/banner_2.jpg" />
                        <div class="carousel-caption">
                            <h4>
                                Second Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                    <div class="carousel-item">
                        <img class="d-block w-100" alt="Carousel Bootstrap Third" src="images/banner_3.png" />
                        <div class="carousel-caption">
                            <h4>
                                Third Thumbnail label
                            </h4>
                            <p>
                                Cras justo odio, dapibus ac facilisis in, egestas eget quam. Donec id elit non mi porta gravida at eget metus. Nullam id dolor id nibh ultricies vehicula ut id elit.
                            </p>
                        </div>
                    </div>
                </div> <a class="carousel-control-prev" href="#carousel-86736" data-slide="prev"><span class="carousel-control-prev-icon"></span> <span class="sr-only">Previous</span></a> <a class="carousel-control-next" href="#carousel-86736" data-slide="next"><span class="carousel-control-next-icon"></span> <span class="sr-only">Next</span></a>
            </div>
        </div>
    </div>

    </div>
    <hr width=100% style="position: relative; top:-80px;" />
    <!-- 主页专家栏 -->
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-9" style="position: relative;margin: auto;">
                <!-- 专家栏居中 -->
                <div class="row">
                <c:forEach items="${organs }" var="organ">
                	<div class="col-md-3">
                        <div class="card " style="width: 220px;">
                            <img alt="Bootstrap Thumbnail First" class="card-img-top" src="${organ.organizationimage }" width="220px" height="220px" />
                            <div class="card-block">
                                <p class="card-text">${organ.organizationname }
                                </p>
                                <p>
                                    <a class="btn btn-primary" href="ShowOrganizationIntroduceAction?organizationid=${organ.organizationid }">
                                        前往了解
                                    </a>
                                </p>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                </div>
                <!-- <div class="row" style="position: relative;margin-top: 25px;">
                    <div class="col-md-3">
                        <div class="card">
                            <img alt="Bootstrap Thumbnail Second" class="card-img-top" src="images/expert5.jpg" width="220px" />
                            <div class="card-block">
                                <h5 class="card-title">
                                    郑诚云
                                </h5>
                                <p class="card-text">
                                    社交产品经理，社会化媒体营销实践者，专注网络社交领域
                                </p>
                                <p>
                                    <a class="btn btn-primary" href="#">
                                        前往了解
                                    </a>
                                    <span style="position: relative; margin-left: 10px; color:blue ">
                                        x人见过
                                    </span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card">
                            <img alt="Bootstrap Thumbnail Second" class="card-img-top" src="images/expert6.jpg" width="220px" />
                            <div class="card-block">
                                <h5 class="card-title">
                                    吴晓敏
                                </h5>
                                <p class="card-text">
                                    莫柏尔互动科技公司联合创始人，10年以上IT、互联网经验
                                </p>
                                <p>
                                    <a class="btn btn-primary" href="#">
                                        前往了解
                                    </a>
                                    <span style="position: relative; margin-left: 10px; color:blue ">
                                        x人见过
                                    </span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card">
                            <img alt="Bootstrap Thumbnail Third" class="card-img-top" src="images/expert7.jpg" width="220px" />
                            <div class="card-block">
                                <h5 class="card-title">
                                    李欣然
                                </h5>
                                <p class="card-text">
                                    中国传媒大学企业传播研究所副所长，专注于品牌传播等
                                </p>
                                <p>
                                    <a class="btn btn-primary" href="#">
                                        前往了解
                                    </a>
                                    <span style="position: relative; margin-left: 10px; color:blue ">
                                        x人见过
                                    </span>
                                </p>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-3">
                        <div class="card">
                            <img alt="Bootstrap Thumbnail Third" class="card-img-top" src="images/expert8.jpg" width="220px" />
                            <div class="card-block">
                                <h5 class="card-title">
                                    孔明
                                </h5>
                                <p class="card-text">
                                    21世纪中国不动产技术总监，十几年开发经验
                                </p>
                                <p>
                                    <a class="btn btn-primary" href="#">
                                        前往了解
                                    </a>
                                    <span style="position: relative; margin-left: 10px; color:blue ">
                                        x人见过
                                    </span>
                                </p>
                            </div>
                        </div>
                    </div> -->
                </div>
            </div>
        </div>
    </div>
</body>

</html>