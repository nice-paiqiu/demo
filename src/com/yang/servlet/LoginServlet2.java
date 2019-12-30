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

@WebServlet("/login")
public class LoginServlet2 extends HttpServlet {
    UserServiceImpl userService = new UserServiceImpl();
    User user = null;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
//        获取输入的验证码
        String code = request.getParameter("code");
//        生成的验证码
        String vcode = (String) request.getSession().getAttribute("code");
        //查看是否接受到了输入值
        System.out.println("账号:"+username+"\n密码："+password);
        //输出输入的验证码和生成的验证码
        System.out.println("输入的验证码："+code+"\n生成的验证码为："+vcode);

        //非空判断
        if ("".equals(username)||"".equals(password)||null==username||null==password){
            request.setAttribute("msg","账号密码不能为空！");
            //重新进入
            request.getRequestDispatcher("/login2.jsp").forward(request,response);
            return;
        }else if (!code.equals(vcode)){
            //验证码错误
            request.setAttribute("msg","验证码错误！");
            request.getRequestDispatcher("/login2.jsp").forward(request,response);
        }else {
            user = userService.login(username,password);
            //是否有user
            if (user!=null){
                //登录成功
//                UserServlet userServlet = new UserServlet();
//                userServlet.service(request,response);
                request.getSession().setAttribute("user",user);
                request.getRequestDispatcher("/index.jsp").forward(request,response);

            }else {
                request.setAttribute("msg","账号密码错误，重新输入！");
                //重新进入
                request.getRequestDispatcher("/login2.jsp").forward(request,response);
            }
        }

    }
}
