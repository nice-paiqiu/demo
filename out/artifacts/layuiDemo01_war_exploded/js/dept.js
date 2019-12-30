layui.use('table', function() {
    var table = layui.table;
    //第一个实例
    var tableIns = table.render({
        //elem  绑定页面的table的id属性
        id:'role-table',
        elem: '#role-table'
        , height: 700
        , url: '/layuiDemo01/dept' //数据接口
        , page: true//开启分页
        , limits: [5, 10, 15, 20]
        , limit: 5
        , cols: [[ //表头
            {checkbox: true, fixed: 'left'},
            // {type: 'checkbox', fixed: 'left'},
            {field: 'id', title: 'ID',align:'center', width: 80, sort: true, fixed: 'left'}
            , {field: 'name',align:'center',title: '角色名称', width: 160}
            ,{title:'操作',align:'center',templet:"#roleList",width:200}
        ]]
    })
//列表操作
    table.on('tool(role-table)', function(obj){
        var layEvent = obj.event,
            data = obj.data;
        console.log(data);
        //修改
        if(layEvent=='edit'){
            console.log("修改角色名称")
            layer.open({
                title: '编辑名称'
                ,content: '<input id=\"newName\"  required=\"required\"/>'
                ,yes:function (index) {
                    console.log("数据内容"+newName.value);
                    $.ajax({
                        url:"/layuiDemo01/updateDept",
                        data:{"id":data.id,"name":newName.value},
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
                }
            });
        }
        //删除
        if(layEvent=='del'){
            console.log("删除"+data.id);
            layer.confirm('确定删除此角色？',{icon:3, title:'提示信息'},function(index){
                $.ajax({
                    url:"/layuiDemo01/delDept",
                    data:{"id":data.id},
                    dataType:"json",
                    type:"POST",
                    success:function(datajson){
                        if(datajson.status==1){
                            layer.close(index);
                            window.location.reload();
                        }else{
                            layer.msg(datajson.msg);
                        }
                    }
                })
            });
        }
    });
    var delBtn = document.getElementById("delBtn");
    delBtn.addEventListener("click",function () {

    });
});
//批量删除
function delBtn() {
    //询问是否删除
    layer.confirm("确定删除吗？",function (index) {
        console.log("确定删除！")
        var table = layui.table;
        var checkStatus = table.checkStatus('role-table');
        var data = checkStatus.data;
        console.log(checkStatus.data);
        var i =0;
        var ids ="";
        //id拼接
        for (i;i<data.length;i++){
            var id = data[i].id;
            console.log(id);
            ids=id+","+ids;
        }
        console.log("id拼接结果："+ids);
        //发送ajax请求
        $.ajax({
            url:"/layuiDemo01/delDeptBtn",
            data:{"ids":ids},
            type:"POST",
            dataType:"JSON",
            success:function (datajson) {
                if (datajson.status == 1){
                    //表格重新加载
                    window.location.reload();
                    layer.msg("删除成功");
                }else {
                    layer.msg("删除失败");
                }
            }
        })
        layer.close(index);
    })


}
