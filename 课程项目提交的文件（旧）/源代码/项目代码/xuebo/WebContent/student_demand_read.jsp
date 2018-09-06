<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">

<head>
    <meta charset="UTF-8">
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
    <title>学员需求-描述</title>
    <link href="images/xuebo.jpg" rel="shortcut icon">
    <link href="css/page.css" rel="stylesheet">
    <link href="css/bootstrap.min.css" rel="stylesheet">
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
    <div class="container-fluid">
        <div class="row">
            <div class="col-md-6" style="position: relative;margin: 0 auto; margin-top: 60px; border: 1px solid orange;border-radius: 25px; ">
                <form role="form" style=" padding: 20px;" 
                action="AcceptDemandActionForExpert?expertid=${cookie.xueboExpertName.value}&studentid=${demand.studentid}&demandid=${demand.demandid }" method="post">
                    <dl>
                        <dt>
                           ● 姓名
                        </dt>
                        <dd>${demand.studentname }
                        </dd>
                        <dt>
                            ● 联系方式
                        </dt>
                        <dd>${demand.studentphone }
                        </dd>
                        <dt>
                          ● 需求发布时间
                        </dt>
                        <dd>${demand.demanddate }<input type="hidden" name="demanddate" value="${demand.demanddate }">
                        </dd>
                        <dt>
                            ● 见面时间
                        </dt>
                        <dd>${demand.demandmeetdate }<input type="hidden" name="demandmeetdate" value="${demand.demandmeetdate }">
                        </dd>
                        <dt>
                            ● 见面地点
                        </dt>
                        <dd>${demand.demandmeetaddress }<input type="hidden" name="demandmeetaddress" value="${demand.demandmeetaddress }">
                        </dd>
                        <dt>
                            ● 需求方向
                        </dt>
                        <dd>${demand.demandtype }
                        </dd>
                        <dt>
                            ● 需求内容
                        </dt>
                        <dd>${demand.demandcontent }<input type="hidden" name="demandcontent" value="${demand.demandcontent }">
                        </dd>
                    </dl>
                    <button type="submit" class="btn btn-primary ">
                        接受
                    </button>
                    <button type="submit" class="btn btn-primary data-dismiss=" modal " onclick="window.close(); ">
                        关闭
                    </button>
                </form> 
            </div>
        </div>
    </div> 
</body>
</html>