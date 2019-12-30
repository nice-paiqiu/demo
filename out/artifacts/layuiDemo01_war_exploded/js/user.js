layui.use('table', function(){
    var table = layui.table;
    //第一个实例
    var tableIns=table.render({
        //elem  绑定页面的table的id属性
        elem: '#user'
        ,height: 700
        ,url: '/layuiDemo01/userServlet' //数据接口
        ,page: true//开启分页
        ,limits : [5,10,15,20],
        limit : 5
        ,cols: [[ //表头

            {field: 'id', title: 'ID', width:80, sort: true, fixed: 'left'}
            ,{field: 'username', title: '用户名', width:80}
            ,{field: 'password', title: '密码', width:80, sort: true}
            ,{field: 'fullname', title: '真实姓名', width:80}
            ,{field: 'active', title: '用户状态',  align:'center',width:120},
            {title:'操作',align:'center',templet:"#userListBar",width:280}
        ]],done:function(res, curr, count){
            $("[data-field='active']").children().each(function () {
                if ($(this).text() == '1') {
                    $(this).text("激活")
                }else if($(this).text() == '0'){
                    $(this).text("冻结")
                }
            });
        }
    });
    // 添加用户
    function addUser(data){

        var title="";
        if(data){
            title="修改用户";
        }else{
            title="添加用户";
        }
        var index = layui.layer.open({
            title : title,
            type : 2,
            area: ['800px', '900px'],
            content : "userAdd.jsp",
            success : function(layero, index){
                var body = layui.layer.getChildFrame('body', index);
                if(data){
                    body.find("#id").val(data.id);
                    body.find("#username").val(data.username);
                    body.find("#password").val(data.password);
                    body.find("#fullname").val(data.fullname);
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
    }
//列表操作
    table.on('tool(user)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        console.log(data);
        //修改
        if(layEvent=='edit'){
           addUser(data);
           // x_admin_show('编辑用户','userAdd.jsp','600','500');
        }
        //删除
        if(layEvent=='del'){
            layer.confirm('确定删除此用户？',{icon:3, title:'提示信息'},function(index){
                $.ajax({
                    url:"/layuiDemo01/deleteUserServlet",
                    data:{"id":data.id},
                    dataType:"json",
                    type:"POST",
                    success:function(datajson){
                        if(datajson.status==1){
                            tableIns.reload();
                            layer.close(index);
                        }else{
                            layer.msg(datajson.msg);
                        }
                    }
                })
            });
        }else if(layEvent === 'usable'){ //启用和禁用
            var _this=$(this);
            if(_this.text()=="停用"){
                usableText = "是否确定停用此用户？",
                    btnText = "启用";
            }else if(_this.text()=="启用"){
                usableText = "是否确定启用此用户？",
                    btnText = "停用";
            }
           layer.confirm(usableText,{
                icon: 3,
                title:'系统提示',
                cancel : function(index){
                    layer.close(index);
                }
            },function(index){
                _this.text(btnText);
                if(_this.text()=="启用"){
                    $.ajax({
                        url:"/layuiDemo01/updateUserServlet",
                        data:{"id":data.id,"caozuo":"stop"},
                        type:"POST",
                        dataType:"json",
                        success:function(datajson){
                            if(datajson.status==1){
                                layer.close(index);
                                window.location.reload();
                            }else{
                                layer.msg(datajson.msg);
                            }
                        }
                    })
                }else if(_this.text()=="停用"){
                    $.ajax({
                        url:"/layuiDemo01/updateUserServlet",
                        data:{"id":data.id,"caozuo":"start"},
                        type:"POST",
                        dataType:"json",
                        success:function(datajson){
                            if(datajson.status==1){
                                layer.close(index);
                                window.location.reload();
                            }else{
                                layer.msg(datajson.msg);
                            }
                        }
                    })
                }
            });
        }

    });

});

