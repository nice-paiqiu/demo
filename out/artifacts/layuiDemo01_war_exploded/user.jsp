<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/12
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>
        阳光成单系统
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="lib/layui/css/layui.css" />
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
  <%--  <script type="text/javascript" src="js/jquery.js"></script>--%>
    <script src="lib/layui/layui.js" charset="utf-8"></script>
    <script src="js/x-layui.js" charset="utf-8"></script>
    <script src="js/user.js" charset="utf-8"></script>
</head>
<body>

<div class="x-body">
    <form class="layui-form x-center" action="" style="width:80%">
        <div class="layui-form-pane" style="margin-top: 15px;">
            <div class="layui-form-item"></div>
            <button class="layui-btn layui-btn-danger" style="margin-top: 0px" onclick="delAll()"><i class="layui-icon">&#xe640;</i>批量删除</button>
           <%-- </button><button class="layui-btn" onclick="admin_add('添加用户','admin-add.html','600','500')"><i class="layui-icon">&#xe608;</i>添加</button>--%>
           <div class="layui-inline"> <%----%>
            <a class="layui-btn layui-btn-normal addNews_btn" style="margin-top: 0px">添加用户</a><%----%>
           </div> <%----%>
        </div>
    </form>
    <table id="user" lay-filter="user"></table>
</div>
<script type="text/html" id="userListBar">
    <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
    {{#  if(d.active ==1){ }}
    <a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="usable">停用</a>
    {{#  } else { }}
    <a class="layui-btn layui-btn-xs layui-btn-warm" lay-event="usable">启用</a>
    {{#  } }}
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
</script>
<script>
   /* function admin_add(title,url,w,h) {
        x_admin_show(title,url,w,h);
    }*/
    //添加用户
    function addUser(data){
        var title="";
        if(data){
            title="修改用户";
        }else{
            title="添加用户";
        }
        layui.use('layer', function(){

            var index = layui.layer.open({
                title : title,
                type : 2,
                area: ['800px', '900px'],
                content : "userAdd.jsp",
                success : function(layero, index){
                    var body = layui.layer.getChildFrame('body', index);
                    if(data){
                        body.find(".username").val(data.username);
                        body.find(".password").val(data.password);
                        body.find(".fullname").val(data.fullname);
                        body.find(".status").val(data.status);
                        body.find(".uid").val(data.id);
                        form.render();
                    }
                    setTimeout(function(){
                        layui.layer.tips('点击此处返回用户列表', '.layui-layer-setwin .layui-layer-close', {
                            tips: 3
                        });
                    },500)
                }
            })
            layui.layer.full(index);
            //改变窗口大小时，重置弹窗的宽高，防止超出可视区域（如F12调出debug的操作）
            $(window).on("resize",function(){
                layui.layer.full(index);
            })
        });

    }
    $(".addNews_btn").click(function(){
        addUser();
    })
</script>
</body>
</html>
