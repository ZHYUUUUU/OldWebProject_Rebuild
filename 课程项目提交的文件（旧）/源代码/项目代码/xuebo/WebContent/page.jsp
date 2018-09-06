<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head lang="en">
    <meta charset="utf-8">
    <title>
        学博登录
    </title>
    <link href="images/xuebo.jpg" rel="shortcut icon"></link>
    <link href="css/page.css" rel="stylesheet"></link>
    </meta>
</head>

<body>
    <div class="page_nav">
        <div class="page_a">
                    <img src="images\xuebo.jpg" style="position:relative;  top:20px;" width="30"/>
                    <div style="position: relative; top:-9px; font-size: 16px; left:38px; color: white">
                        学博
                    </div>
            <div class="page_b">
                <a href="#" style=" position: relative; left: 30px; color: white">
                        关于我们
                    </a>
                <a href="#" style="position: relative; left:50px; color: white ">
                        帮助
                    </a>
            </div>
        </div>
    </div>
    <div class="page_bg">
        <!-- 背景图片 -->
        <div class="page_kuai">
            <img src="images\ZaihBackground.jpg" style="position: relative; left: 20px; top: 60px;" width="400" />
            <hr size="380" style="position: absolute; left: 440px; top:0px;" width="1" />
            <div class="r">
                <div>
                    <span class="xueyuan" ><a href="#" style="color:black;">学员登录</a></span>
                    <span class="zhuanjia" ><a href="#" style="color:black;">专家登录</a></span>
                </div>
                <div class="choice1">
                    <form action="LoginAction" class="form1" method="get" name="usermessage1">
                    	<hr size="2" width="80" style=" position: relative; left: -60px; top: -10px;" />
                        <input type="text" placeholder="学员用户名" name="name">
                        <br />
                        <input type="password" placeholder="密码" name="pwd">
                        <br />
                        <a href="homepage.jsp">
                        <input type="submit" value="登录" style="background-color:#108cee ;color:white; border: none;">
                        </a>
                        <br />
                        <a href="login.jsp" style="position: relative; margin-left: 150px; top: -10px;">没有账号？马上成为学员</a>
                    </form>
                </div>
                <div class="choice2">
                    <form action="LoginAction" class="form1" method="get" name="usermessage2">
                    	<hr size="2" width="80" style=" position: relative; left: 80px; top: -10px;" />
                        <input type="text" placeholder="专家用户名" name="name">
                        <br />
                        <input type="password" placeholder="密码" name="pwd">
                        <br />
                        <input type="text" placeholder="身份证验证" name="check_id_card">
                        <br />
                        <a href="expert_homepage.jsp">
                        <input type="submit" value="登录" style="background-color:#108cee ;color:white; border: none;">
                        </a>
                        <br />
                        <a href="expert_login.jsp" style="position: relative; margin-left: 150px; top: -10px;">没有账号？马上成为专家</a>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <!-- <script>
            $('.choice span').click(function() {
            var i = $(this).index();//下标第一种写法
            //var i = $('tit').index(this);//下标第二种写法
            $(this).addClass('select').siblings().removeClass('select');
            $('#con ').eq(i).show().siblings().hide();
        });
        </script> -->
</body>
<script type="text/javascript" src="js/jquery-3.1.1.min.js"></script>
<script>
$(document).ready(function() {
    /*这是一个自定义的函数,作用是设置class1类为隐藏,class2类显示*/
    function showDiv(class1, class2) {
        $(class1).css("display", "none");
        $(class2).css("display", "block");

    }
    /*给右下角的图标设置点击事件*/
    $('.xueyuan').click(function() {
        showDiv(".choice2", ".choice1");
        $("input[name=name]").val("");
        $("input[name=pwd]").val("");
        $("input[name=check_id_card]").val("");
    })

    $('.zhuanjia').click(function() {

        showDiv(".choice1", ".choice2");
        $("input[name=name]").val("");
        $("input[name=pwd]").val("");
        $("input[name=check_id_card]").val("");
    })
})

</script>

</html>