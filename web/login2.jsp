
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
    <link rel="stylesheet" href="css/index_login.css" />
    <script type="text/javascript" src="js/jquery.js"></script>

    <script>
        function createCode() {
            var src="/layuiDemo01/code?time="+new Date().getTime();
            $("#code").attr("src",src);
        }
    </script>
</head>
<body>

<div id="main_box_login_2"></div>
<div id="main_box_login">
    <!--头 -->
    <div id="main_box_login_head">
        通行证&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    </div>
    <!--登录主体-->
    <div>
        <form action="/layuiDemo01/login" method="post">
            <%--账号--%>
            <input class="input_css" type="text" name="username" placeholder="请输入用户名"/>
            <%--密码--%>
            <input class="input_css" type="password" name="password" placeholder="请输入密码" />
                <%--输入验证码--%>
                <div>
                <input class="input_css" name="code" type="text" placeholder="验证码" style="width:150px;">
                <img src="/layuiDemo01/code" id="code" onclick="createCode()" title="点击更换验证码">
                 </div>
            <%--登录按钮--%>
            <input class="submit_css" type="submit" value="放行"/>

        </form>
    </div>
    <!--忘记密码|注册-->
    <div class="login_link">
        <a href="#">忘记密码</a>
        |
        <a href="#">注册</a>
    </div>
    <span style="color: red">${msg}</span>


</div>
</body>

</html>
