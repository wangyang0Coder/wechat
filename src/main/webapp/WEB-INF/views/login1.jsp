<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%@ page import="bean.*" %>
<%@ page import="dao.*" %>
<%
    String path = request.getContextPath() + "/";
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>chatRoom_login</title>
    <link href="<%=path %>css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="<%=path %>css/animate.css" rel="stylesheet">
    <link href="<%=path %>css/style.css" rel="stylesheet">
</head>

<body class="gray-bg">
<div class="middle-box text-center loginscreen animated fadeInDown">
    <div>
        <div>
            <h1 class="logo-name" align="center">Chat</h1>
        </div>
        <h3>Welcome to ChatRoom</h3>
        <p>
            这是一个在线聊天室!
        </p>
        <%
            String info = (String) request.getAttribute("error_login");
        %>
        <form class="m-t" role="form" action="<%=path %>Login" method="post">
            <div class="form-group">
                <input type="text" name="username" class="form-control" placeholder="用户名" required="">
            </div>
            <div class="form-group">
                <input type="password" name="password" class="form-control" placeholder="密码" required="">
            </div>
            <span style="color:red">
						<%=(info == null) ? "" : info%>
				</span>
            <button type="submit" class="btn btn-primary block full-width m-b">登录</button>
            <a class="btn btn-sm btn-white btn-block" href="<%=path %>Register">注册账户</a>
        </form>
        <span style="white-space:pre"></span>
        <td width="18%">
            <font color="#000000" size="6">
                <div id="time1">
                    <script type="text/javascript">
                        //非动态显示
                        //document.getElementById('time1').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());
                        //动态显示
                        setInterval("document.getElementById('time1').innerHTML=new Date().toLocaleString()+' 星期'+'日一二三四五六'.charAt(new Date().getDay());", 1000);
                    </script>
                </div>
            </font>
        </td>
    </div>
</div>

<!-- Mainly scripts -->
<script src="js/jquery-3.1.1.min.js"></script>
<script src="js/bootstrap.min.js"></script>

</body>

</html>
