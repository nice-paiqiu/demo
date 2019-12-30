<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/8
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="lib/layui/css/layui.css">
    <script src="lib/layui/layui.js" ></script>
    <script src="js/jquery.js"></script>
    <style>
        #registView div input {
            margin-top: 40px;
            margin-left: 5px;
            font-size: 20px;
            background-color: transparent;
            height: 40px;
            border-bottom: 2px solid #C0C4CC;
            border-left: 0;
            border-right: 0;
            border-top: 0;
        }
        .re{
            width: 70%;
            height: auto;
            text-align: center;
            background: url(images/regist_bg.jpg) no-repeat;
            display: inline-block;
            margin-top: 30%;
            margin-left: 15%;
        }
    </style>
</head>
<body>
<div>
    <a href="loginView.jsp">
        <i class="layui-icon layui-icon-return" style="font-size: 30px;"></i>
        返回登录
    </a>
</div>
<script>
    function regist() {
        var username = document.getElementById("username");
        var fullname = document.getElementById("fullname");
        var password = document.getElementById("password");
        var password2 = document.getElementById("password2");
        console.log(username.value);
        $.ajax({
            url:"/layuiDemo01/regist",
            data:{"username":username.value,"fullname":fullname.value,"password":password.value,"password2":password2.value},
            dataType:"json",
            type:"POST",
            success:function(datajson){
                if(datajson.status==1){
                    alert(datajson.msg+"返回登录页");
                    window.location="loginView.jsp";
                }else{
                    layui.use('layer', function(){
                        var layer = layui.layer;
                        layer.msg(datajson.msg);
                    });
                }
            }
        })
    }</script>

<div id="registView" class="re layui-anim layui-anim-up">
    <%--<form class="layui-form" autocomplete="off" action="" method="">--%>
        <!--账号-->
        <div>
            <i class="layui-icon layui-icon-username" style="font-size: 30px; color: #1E9FFF;"></i>
            <input id="username" type="text" required="required" placeholder="请输入账号" />
        </div>
        <!--真实姓名-->
        <div>
            <i class="layui-icon layui-icon-username" style="font-size: 30px; color: #1E9FFF;"></i>
            <input id="fullname" type="text" required="required" placeholder="请输入真实姓名" />
        </div>
        <!--密码-->
        <div>
            <i class="layui-icon layui-icon-password" style="font-size: 30px; color: #1E9FFF;"></i>
            <input id="password" type="password" required="required" placeholder="请输入密码" />
        </div>
        <!--确认密码-->
        <div>
            <i class="layui-icon layui-icon-password" style="font-size: 30px; color: #1E9FFF;"></i>
            <input id="password2" type="password" required="required" placeholder="请再次输入密码" />
        </div>
        <!--状态-->
        <!--注册-->
        <div>
            <button class="layui-btn layui-btn-normal"style="margin-top: 25px; width: 60%;" onclick="regist()">注册</button>
        </div>
    <%--</form>--%>
</div>
</body>
</html>
