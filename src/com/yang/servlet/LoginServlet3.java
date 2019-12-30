package com.yang.servlet;

import com.yang.po.User;
import com.yang.service.impl.UserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login2")
public class LoginServlet3 extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=UTF-8");
        JSONObject obj= new JSONObject();
        String name = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println("name:"+name+"password:"+password);
        if("".equals(name)||"".equals(password)||name==null||password==null){
            obj.put("status",0);
            obj.put("msg","账号密码不能为空！");
        }else {
            User user = userService.login(name,password);
            if (user!=null){
                System.out.println("登录成功");
                obj.put("status",1);
//            request.setAttribute("status",1);
//            request.getRequestDispatcher("index.jsp").forward(request,response);
            }else {
                obj.put("msg","账号或者密码错误，请重新输入");
                obj.put("status",0);
                System.out.println("登录失败");
//                request.setAttribute("status",0);
//                request.setAttribute("msg","账号或者密码错误，请重新输入");
            }
        }
        response.getWriter().write(obj.toString());
        System.out.println(obj.toString());
     }
            }
