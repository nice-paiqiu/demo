package com.yang.servlet.roleServlet;

import com.yang.service.impl.RoleServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delRoleBtn")
public class DelRoleBtn extends HttpServlet {
    RoleServiceImpl roleService = new RoleServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("---------批量删除开始---------");
        JSONObject obj =new JSONObject();
        String ids = request.getParameter("ids");
        System.out.println("ids："+ids);
        String[] id = ids.split(",");
        for (String i : id){
            int result = roleService.delRole(Integer.parseInt(i));
            if (result>0){
                obj.put("status",1);
//                request.setAttrib0ute("status",1);
                System.out.println("成功删除:"+i);
            }else {
                obj.put("status",0);
//                request.setAttribute("status",0);
                System.out.println("2.删除失败");
            }

        }
        response.getWriter().write(obj.toString());
        System.out.println("---------批量删除结束---------");

    }
}
