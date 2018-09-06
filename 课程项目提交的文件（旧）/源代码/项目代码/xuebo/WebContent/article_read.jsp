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
    <title>文章</title>
    <meta name="description" content="Source code generated using layoutit.com">
    <meta name="author" content="LayoutIt!">
    <link href="images/xuebo.jpg" rel="shortcut icon">
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/page.css" rel="stylesheet">
    <script>
    function delete_article(articleid){
    	var r=confirm("是否删除该文章？（此操作不可恢复）");
    	if(r==true){
    		window.location = "DeleteArticleActionForExpert?articleid=" + articleid;
    	}
    }
    </script>
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
            <form role="form">
                <div class="form-group">
                    <label for="exampleInputText1">
                        <h3>${article.articletitle } </h3>
                        </label>
                        <label style="color: #7D7D7D;text-align: right;width:590px;"><font style="font-size:15px">教育方向：&nbsp;<u>${article.articletype }</u></font></label>
                        <hr>
                    </div>
                    <div class="form-group">
                    	<div class="form-group" style="text-align: right;width:630px;">
                        <label for="exampleInputTextarea1" style="color: #7D7D7D;">
                            作者：${article.expertname }<c:if test="${cookie.xueboExpertName.value == article.expertid }">（本人）</c:if>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;${article.publishdate }
                        </label>
                        </div>
                        <p>${article.articlecontent }
                        </p>
                    </div>
                    <button type="button" class="btn btn-secondary" modal" onclick="window.close();">
                        关闭
                    </button>&nbsp;&nbsp;&nbsp;&nbsp;
                    <c:if test="${cookie.xueboExpertName.value == article.expertid }">
                    <button type="button" class="btn btn-primary data-dismiss="modal" onclick="delete_article('${article.articleid}')">
                        删除该文章
                    </button>
                    </c:if>
                </form>
                <br>
            </div>
            <div class="col-md-3">
            </div>
        </div>
    </div>
</body>

</html>