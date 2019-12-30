<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/3
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="lib/layui/css/layui.css" />
    <script type="text/javascript" src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="lib/layui/layui.js" charset="utf-8"></script>
    <script src="js/x-layui.js" charset="utf-8"></script>
    <script src="js/dept.js" charset="utf-8"></script>
</head>
<body>
<div class="x-nav">
    <a href="#" class="layui-btn layui-btn-danger " onclick="delBtn()" style="margin-top: 13px" >
        <i class="layui-icon layui-icon-delete" id="delBtn" style="font-size: 20px; color: #1E9FFF;"></i>
        批量删除
    </a>
    <a href="#" class="layui-btn layui-btn-normal  " style="margin-top: 13px" onclick="add()" >
        添加部门
    </a>
</div>
<table id="role-table" lay-filter="role-table">
</table>

<script type="text/html" id="roleList">
    <a class="layui-btn layui-btn-xs" lay-event="edit">修改名称</a>
    <a class="layui-btn layui-btn-xs layui-btn-danger" lay-event="del">删除</a>
</script>
<script>
    function add() {
        var content = "<input id=\'addName\'/>";
        layer.open({
            title: '添加部门'
            ,content: content
            ,yes:function (index) {
                console.log("添加部门名称："+ addName.value);
                $.ajax({
                    url:"${pageContext.request.contextPath}/addDept",
                    data:{"name":addName.value},
                    dataType:"JSON",
                    type:"POST",
                    success:function (datajson) {
                        if (datajson.status==1){
                            window.location.reload();
                            layer.close(index);
                            layer.msg("添加成功");
                        }else{
                            layer.msg(datajson.msg);
                        }
                    }
                })
            }
        });
    }
</script>
</body>
</html>
