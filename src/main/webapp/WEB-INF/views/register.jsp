<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath() + "/webapp/";
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>INSPINIA | Register</title>
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="font-awesome/css/font-awesome.css" rel="stylesheet">
    <link href="css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="css/animate.css" rel="stylesheet">
    <link href="css/style.css" rel="stylesheet">
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen   animated fadeInDown">
    <div>
        <div>
            <p aglin="center" font-size:50px>Register</p>
        </div>
        <p>注册用户</p>
        <%
            System.out.println(path + "css/bootstrap.min.css");
            String info = (String) request.getAttribute("error");
        %>
        <form class="m-t" role="form" action="<%=path %>Register" method="post">
            <div class="form-group">
                <input type="text" name="username" class="form-control" placeholder="用户名" required="">
            </div>
            <div class="form-group">
                <input type="password" name="password1" class="form-control" placeholder="请输入密码" required="">
            </div>
            <div class="form-group">
                <input type="password" name="password2" class="form-control" placeholder="再次确认密码" required="">
            </div>
            <span style="color:red">
						<%=(info == null) ? "" : info%>
				</span>
            <input type="button" class="btn btn-primary block full-width m-b" onclick="register()">注册</input>
            <a class="btn btn-sm btn-white btn-block" href="<%=path %>Login">返回登录</a>
        </form>
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
    </div>
</div>
</body>
<script type="text/javascript">
    function register() {
        $.ajax({
            type: 'POST',
            url: 'register',
            dataType: 'json',
            data: {
                username: $("#username").val(),
                password: $("#password").val()
            },
            async: false,
            success: function (data) {
                if (data.status == 200) {
                    window.location.href = "wechat";
                } else {
                    alert(data.msg);
                }
            }
        });
    }
</script>
</html>
