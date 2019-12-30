package com.yang.servlet;

import com.yang.po.User;
import com.yang.service.IUserService;
import com.yang.service.impl.UserServiceImpl;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private IUserService userService =new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          response.setContentType("text/html;charset=UTF-8");
          //获取参数
          String username =request.getParameter("username");
          String password=request.getParameter("password");

          System.out.println("username："+username);
        System.out.println("password:"+password);



        JSONObject obj =new JSONObject();
          //过滤参数
        if("".equals(username) || username==null || "".equals(password) || password==null){
            obj.put("status",0);
            obj.put("msg","用户名或者密码不允许为空");
        }else{
            //调用业务逻辑
            User user =userService.login(username,password);
            if(user!=null){
                request.getSession().setAttribute("user",user);
                obj.put("status",1);
            }else{
                obj.put("status",0);
                obj.put("msg","用户名或者密码错误");
            }
        }
          //返回数据
        response.getWriter().write(obj.toString());
    }
}
