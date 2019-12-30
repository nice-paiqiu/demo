package com.yang.servlet.roleServlet;

import com.yang.service.impl.RoleServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delRole")
public class DeleRoleServlet extends HttpServlet {
    RoleServiceImpl roleService = new RoleServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        JSONObject obj = new JSONObject();
        String id = request.getParameter("id");
        System.out.println("删除id："+id);
        System.out.println(Integer.parseInt(id));
         if ("".equals(id)||id==null){
               obj.put("status",0);
               System.out.println("1.删除失败");
               obj.put("msg","删除的数据不存在");
           }else {
           int result = roleService.delRole(Integer.parseInt(id));
           if (result>0){
               obj.put("status",1);
           }else {
               obj.put("status",0);
               obj.put("msg","删除失败");
               System.out.println("2.删除失败");
           }
       }
       response.getWriter().write(obj.toString());
    }
}
