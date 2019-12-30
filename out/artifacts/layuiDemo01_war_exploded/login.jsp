<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/12
  Time: 20:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>后台系统管理</title>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    <meta http-equiv="Cache-Control" content="no-siteapp" />

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="./css/font.css">
    <link rel="stylesheet" href="./css/xadmin.css">
    <%--<script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>--%>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script src="./lib/layui/layui.js" charset="utf-8"></script>
    <script type="text/javascript" src="./js/xadmin.js"></script>
    <link rel="stylesheet" href="css/login.css"/>
    <script>
        function toLogin() {
            $.ajax({
                url:"/loginServlet",
                data:{"username":"admin","password":"admin"}
               ,dataType:"JSON",
               type:"POST" ,
                success:function (datajson) {
                    if (datajson.status==1){

                    }else {
                        layer.msg("登录失败！");
                    }
                    
                }
            })
        }
    </script>
</head>
<body class="login-bg">

<div class="login">
    <div class="message">管理登录</div>
    <div id="darkbannerwrap"></div>

    <form method="post" class="layui-form" >
        <input name="username" placeholder="用户名"  type="text" lay-verify="required" class="layui-input" >
        <hr class="hr15">
        <input name="password" lay-verify="required" placeholder="密码"  type="password" class="layui-input">
        <hr class="hr15">
        <input value="登录" lay-submit lay-filter="login" style="width:100%;" type="submit">
        <hr class="hr20" >
    </form>
</div>

<script>
    $(function  () {
        layui.use('form', function(){
            var form = layui.form;

            //监听提交
            form.on('submit(login)', function(data){
              //发送ajax
                $.ajax({
                    url:"${pageContext.request.contextPath}/loginServlet",
                    data:data.field,
                    type:"POST",
                    dataType:"json",
                    success:function(data){

                          if(data.status==0){
                              //登录失败
                              layer.msg(data.msg);
                          }else{
                              //登录成功
                              location.href='index.jsp'
                          }
                    }
                })
                return false;
            });
        });
    })


</script>
<!-- 底部结束 -->
</body>

<%--<body>--%>
<%--<div class="bg">--%>
    <%--<div id="left" class="layui-anim-scale"></div>--%>
    <%--<div id="right">--%>
        <%--<div id="loginView">--%>
            <%--<div>--%>
                <%--<img src="images/loginIcon.jpg" width="100%"/>--%>
            <%--</div>--%>
            <%--<form action="${pageContext.request.contextPath}/loginServlet" method="post">--%>
                <%--<!--账号-->--%>
                <%--<div>--%>
                    <%--<i class="layui-icon layui-icon-username"  style="font-size: 23px; color: #1E9FFF;"></i>--%>
                    <%--<input id="username" type="text" required="required" placeholder="请输入账号" />--%>
                <%--</div>--%>
                <%--<!--密码-->--%>
                <%--<div>--%>
                    <%--<i class="layui-icon" style="font-size: 23px; color: #1E9FFF;">&#xe673;</i>--%>
                    <%--<input id="password" type="password" required="required" placeholder="请输入密码" />--%>
                <%--</div>--%>

                <%--<!--忘记密码-->--%>
                <%--<div style="margin-top: 5px; width: 65%;display: inline-block; text-align: right;">--%>
                    <%--<a href="#" class="a">忘记密码</a>--%>
                <%--</div>--%>

                <%--<!--登录按钮-->--%>
                <%--<div>--%>
                    <%--<button class="layui-btn layui-btn-normal"  onclick="toLogin()"  style="margin-top: 25px; width: 60%;">登录</button>--%>
                <%--</div>--%>
                <%--<div style="margin-top: 5px; width: 65%;display: inline-block; text-align: right;">--%>
                    <%--<font size="2" color="#C9C5C5">没有账号？</font><br/>--%>
                    <%--<a href="#" class="aa">这里注册(。・∀・)ノ--%>
                        <%--<i class="layui-icon layui-icon-next" style="font-size: 13px;"></i></a>--%>
                <%--</div>--%>
            <%--</form>--%>
        <%--</div>--%>
    <%--</div>--%>
<%--</div>--%>
<%--<script>--%>
<%--</script>--%>
<%--</body>--%>



</html>
