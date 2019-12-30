<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/14
  Time: 20:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>
        用户管理系统
    </title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="format-detection" content="telephone=no">
    <link rel="stylesheet" href="css/xadmin.css">
</head>

<body>
<div class="x-body">
    <form class="layui-form">
        <input type="hidden" id="id" name="id"  class="layui-input" />
        <div class="layui-form-item">
            <label for="username"  class="layui-form-label">
                <span class="x-red">*</span>登录名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="username" name="username" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>将会成为您唯一的登入名
            </div>
        </div>
        <div class="layui-form-item">
            <label for="password" class="layui-form-label">
                <span class="x-red">*</span>密码
            </label>
            <div class="layui-input-inline">
                <input type="password" id="password" name="password" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
            <div class="layui-form-mid layui-word-aux">
                <span class="x-red">*</span>将会成为您唯一的密码
            </div>
        </div>
        <div class="layui-form-item">
            <label for="fullname" class="layui-form-label">
                <span class="x-red">*</span>真实姓名
            </label>
            <div class="layui-input-inline">
                <input type="text" id="fullname" name="fullname" required="" lay-verify="required"
                       autocomplete="off" class="layui-input">
            </div>
        <div class="layui-form-item layui-row layui-col-xs12">
            <div class="layui-input-block">
                <button class="layui-btn layui-btn-sm" lay-submit="" lay-filter="addUser">提交</button>
                <button type="reset" class="layui-btn layui-btn-sm layui-btn-primary">取消</button>
            </div>
        </div>
        </div>
    </form>
</div>
</div>
<script src="lib/layui/layui.js" charset="utf-8"></script>
<script>
    layui.use(['form','layer'],function(){
        var form = layui.form
        layer = parent.layer === undefined ? layui.layer : top.layer,
            $ = layui.jquery;

        form.on("submit(addUser)",function(data) {
            var url = "";
            console.log(data.field);
            if(data.field.id==null || data.field.id==""){ //增加
                url="/layuiDemo01/addUserServlet";
            }else{
                url="/layuiDemo01/doUpdateUserServlet"; //修改
            }
            $.ajax({
                url:url,
                data:data.field,
                dataType:"json",
                type:"POST",
                success:function(datajson){
                    if(datajson.status==1){
                        setTimeout(function(){
                            top.layer.msg("用户操作成功！");
                            layer.closeAll("iframe");
                            //刷新父页面
                            parent.location.reload();
                        },1000);
                    }else{
                        layer.msg(datajson.msg);
                    }
                }
            })

            return false;
        })

</script>
</body>
</html>
