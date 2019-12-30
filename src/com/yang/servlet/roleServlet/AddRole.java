package com.yang.servlet.roleServlet;

import com.yang.service.impl.RoleServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/addRole")
public class AddRole extends HttpServlet {
    RoleServiceImpl roleService = new RoleServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("========添加角色开始========");
        String name = request.getParameter("name");
        JSONObject obj = new JSONObject();
        if ("".equals(name)||name==null){
            obj.put("status",0);
            obj.put("msg","名称不能为空");
        }else {
            int result = roleService.addRole(name);
            if (result>0){
                obj.put("status",1);
                obj.put("msg","添加成功");
            }else {
                obj.put("status",0);
                obj.put("msg","添加失败");
            }
        }
        response.getWriter().write(obj.toString());
        System.out.println(obj.toString());
        System.out.println("========添加角色结束========");

    }
}
