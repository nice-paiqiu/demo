<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/8
  Time: 17:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
        <link rel="stylesheet" href="lib/layui/css/layui.css">
        <script src="lib/layui/layui.js" ></script>
       <script type="text/javascript" src="js/jquery.js"></script>
    <style>
        .bg{
            width: 100%;
            height: 100%;
            margin-top: 0;
            margin-left: 0;
            position: fixed;
        }
        #left{
            width: 70%;
            height: 100%;
            position: fixed;
            margin-left: 0px;
            background: url(images/bg2_img.jpg) no-repeat fixed;
        }
        #right{
            width: 30%;
            height: 100%;
            text-align: center;
            float: right;
        }
    </style>

</head>

<body>
    <div class="bg">
        <div id="left" class="layui-anim-scale"></div>
        <div id="right">
            <iframe src="loginView.jsp" style="height: 100%; width: 100%; border: 0px;"></iframe>
        </div>
    </div>
</body>
</html>
