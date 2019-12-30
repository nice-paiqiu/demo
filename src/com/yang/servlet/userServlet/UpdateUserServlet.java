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

@WebServlet("/doUpdateUserServlet")
public class UpdateUserServlet extends HttpServlet{
    private IUserService userService =new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        JSONObject obj =new JSONObject();
        String username = request.getParameter("username");
        String password =request.getParameter("password");
        String fullname =request.getParameter("fullname");
        String id =request.getParameter("id");
        if("".equals(id) || id==null || "".equals(username) ||username==null || "".equals(password) || password==null || "".equals(fullname) || fullname==null){
            obj.put("status",0);
            obj.put("msg","请填写您要修改的数据字段");
        }else{
            int count =userService.updateUser(Integer.parseInt(id),username,password,fullname);
            if(count>0){
                obj.put("status",1);
            }else{
                obj.put("status",0);
                obj.put("msg","修改失败");
            }
        }
        response.getWriter().write(obj.toString());
    }
}
