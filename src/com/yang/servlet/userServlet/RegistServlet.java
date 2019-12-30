package com.yang.servlet.userServlet;

import com.yang.service.impl.UserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/regist")
public class RegistServlet extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = request.getParameter("username");
        String fullname = request.getParameter("fullname");
        String password = request.getParameter("password");
        String password2 = request.getParameter("password2");
        JSONObject obj  = new JSONObject();
        if ("".equals(username)||"".equals(password)||"".equals(password2)||"".equals(fullname)||username==null||password==null||password2==null||fullname==null){
            obj.put("status",0);
            obj.put("msg","请完善信息");
        }else {
            if(password.equals(password2)){
                int result = userService.addUser(username,password,fullname);
                if (result>0){
                    obj.put("msg","注册成功！");
                    obj.put("status",1);
                }else {
                    obj.put("msg","注册失败！");
                    obj.put("status",0);
                }
            }else {
                obj.put("status",0);
                obj.put("msg","两次输入密码不一致,注册失败");
            }
        }
       response.getWriter().write(obj.toString());
    }
}
