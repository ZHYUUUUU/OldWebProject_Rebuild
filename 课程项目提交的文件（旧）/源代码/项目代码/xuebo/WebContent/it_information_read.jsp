<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
    <title>导航-业内行情【详情】</title>
    <link href="images/xuebo.jpg" rel="shortcut icon">
    <link rel="stylesheet" href="css/homepage.css">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>

<body>
    <div class="container-fluid">
        <div class="row guding" id="cont-acont">
            <div style="position: relative;margin-top: -8px; ">
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
            <div class="col-md-6" style="margin-top: 80px;z-index: 1200; background-color: #FFFFFF">
                <form role="form">
                    <div class="form-group">
                        <label for="exampleInputText1">
                            <h3>CSDN日报1806019——《程序员，读研你的优势是什么呢？》 </h1>
                        </label>
                        <hr>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputTextarea1" style="color: #7D7D7D">
                            作者：<h6 >xxx</h6>
                            2018.06.10
                        </label>
                        <p> 
                            CSDN日报1806019——《程序员，读研你的优势是什么呢？》

						在开发安卓app的时候，首先我们需要配置一下电脑的开发环境。到jdk官网下载最新版本的jdk安装包。

						Window64位下载地址：http://download.oracle.com/otn-pub/java/jdk/8u112-b15/jdk-8u112-windows-x64.exe </p>

						<p>下载完成后，全部默认安装，一直点击下一步知道完成。在安装的过程中，会安装两个jdk和jre（java环境）。

						之后就是配置环境变量。

						配置环境变量参考下面的链接：

						http://jingyan.baidu.com/article/6dad5075d1dc40a123e36ea3.html</p>

						<p>配置成功后，java的开发环境已经弄好了。下一步就是下载android开发的开发工具了。在这里，我建议使用android studio，因为google已经放弃了对eclipse的支持，目前在开发者也正在从eclipse中向android studio转移。

						下载android studio首先登陆android studio的官网：http://www.android-studio.org/index.php/download</p>
                       
                    </div>
                    <a type="button" class="btn btn-primary data-dismiss="modal" href="it_information_list.jsp">
                        关闭
                    </a>
                </form>
            </div>
            <div class="col-md-3">
            </div>
        </div>
    </div>
</body>
</html>