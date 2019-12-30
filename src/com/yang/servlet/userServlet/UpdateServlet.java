package com.yang.servlet.userServlet;

import com.yang.service.IUserService;
import com.yang.service.impl.UserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateUserServlet")
public class UpdateServlet extends HttpServlet {
    private IUserService userService =new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         response.setContentType("text/html;charset=UTF-8");
        JSONObject obj =new JSONObject();
         String id =request.getParameter("id");
         String caozuo =request.getParameter("caozuo");
         if("".equals(id) || id==null || "".equals(caozuo) || caozuo ==null){
             obj.put("status",0);
             obj.put("msg","操作用户不存在");
         }else{
             int count =userService.updateActive(Integer.parseInt(id),caozuo);
             if(count>0){
                 obj.put("status",1);
             }else{
                 obj.put("status",0);
                 obj.put("msg","操作用户不存在");
             }
         }
        response.getWriter().write(obj.toString());

    }
}
