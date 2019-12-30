<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="lib/layui/css/layui.css">
    <script src="lib/layui/layui.js" ></script>
    <script src="js/jquery.js"></script>

    <style>
        #loginView {
            width: 70%;
            height: auto;
            /*background: #FF0000;*/
            text-align: center;
            /*border: 1px #0000FF solid;*/
            display: inline-block;
            margin-top: 30%;
            margin-left: 15%;
        }

        #loginView div input {
            margin-top: 40px;
            margin-left: 5px;
            font-size: 20px;
            height: 40px;
            border-bottom: 2px solid #C0C4CC;
            border-left: 0;
            border-right: 0;
            border-top: 0;
        }

        a:link {
            color: #1E9FFF;
        }

        a:hover {
            color: #00ccff;
        }

        a:visited {
            color: #1E9FFF;
        }

        .aa {
            font-size: 12px;
            color: #C0C4CC;
        }
    </style>
</head>
<body>
<script>
    function login() {
        var username = document.getElementById("username");
        var password = document.getElementById("password");
        $.ajax({
            url:"/layuiDemo01/login2",
            data:{"username":username.value,"password":password.value},
            dataType:"json",
            type:"POST",
            success:function(datajson){
                console.log(datajson.status)
                if(datajson.status==1){
                    top.location="index.jsp";
                }else{
                    console.log(datajson.msg);
                    layui.use('layer', function(){
                        var layer = layui.layer;
                        layer.msg(datajson.msg);
                    });
                }
            }
        })
    }
</script>
<div id="loginView" class="layui-anim layui-anim-scale">
    <div>
        <img src="images/loginIcon.jpg" />
    </div>
    <%--<form>--%>
        <!--账号-->
        <div>
            <i class="layui-icon layui-icon-username" style="font-size: 30px; color: #1E9FFF;"></i>
            <input id="username" name="username" type="text" required="required" placeholder="请输入账号" />
        </div>
        <!--密码-->
        <div>
            <i class="layui-icon layui-icon-password" style="font-size: 30px; color: #1E9FFF;"></i>
            <input id="password" name="password" type="password" required="required" placeholder="请输入密码" />
        </div>
        <!--忘记密码-->
        <div style="margin-top: 5px; width: 65%;display: inline-block; text-align: right;">
            <a href="#" class="a">忘记密码</a>
        </div>
        <!--登录-->
        <div>
            <button class="layui-btn layui-btn-normal" style="margin-top: 25px; width: 60%;" onclick="login()">登录</button>
        </div>
        <!--注册-->
        <div style="margin-top: 5px; width: 65%;display: inline-block; text-align: right;">
            <font size="2" color="#C9C5C5">没有账号？</font><br/>
            <a href="regist.jsp" class="aa">这里注册(。・∀・)ノ
                <i class="layui-icon layui-icon-next" style="font-size: 13px;"></i></a>
        </div>
    <%--</form>--%>
</div>
</body>
</html>
