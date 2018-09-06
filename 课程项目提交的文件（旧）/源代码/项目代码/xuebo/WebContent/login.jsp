<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
    <head>
        <meta charset="utf-8"/>
        <title>
            学博注册界面
        </title>
        <link href="images/xuebo.jpg" rel="shortcut icon">
            <link href="css/login.css" rel="stylesheet" type="text/css">
                <link href="css/bootstrap1.min.css" rel="stylesheet" type="text/css">
                </link>
            </link>
        </link>
    </head>
    <body>
        <div class="container">
            <form action="RegisterActionForUser" class="form" method="post">
                <div class="div1">
                    <p class="p1">
                        欢迎加入学博
                    </p>
                </div>
                <table class="table">
                    <tr>
                        <td>
                            <span>
                                用户名
                            </span>
                        </td>
                        <td>
                            <input name="user_name" type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>
                                email
                            </span>
                        </td>
                        <td>
                            <input name="user_email" type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>
                                密码
                            </span>
                        </td>
                        <td>
                            <input name="user_password" type="password"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <span>
                                确认密码
                            </span>
                        </td>
                        <td>
                            <input name="user_confirm_password" type="password"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            性别
                        </td>
                        <td>
                            <input checked="" id="male" name="user_sex" type="radio" value="男"/>
                            男
                            <input id="female" name="user_sex" type="radio" value="女"/>
                            女
                        </td>
                    </tr>
                    <tr>
                        <td>
                            手机号码
                        </td>
                        <td>
                            <input name="user_phone1" type="text"/>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input checked="" name="user_agreement" type="checkbox"/>
                            我已看过并接受
                            <a href="#">
                                《用户协议》
                            </a>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2">
                            <input name="submit" type="submit" value="立即注册"/>
                            <a href="page.jsp" style="position: relative; left:50px; font-size: 14px;">返回登录</a>
                        </td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>