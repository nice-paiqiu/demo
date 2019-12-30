package com.yang.servlet.userServlet;

import com.yang.service.IUserService;
import com.yang.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import com.yang.po.User;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/userServlet")
public class UserServlet extends HttpServlet{
    private IUserService userService =new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
             //前端传入的两个值 page当前页   limit每页显示数
             response.setContentType("text/html;charset=UTF-8");
             JSONObject obj =new JSONObject();
             String page =request.getParameter("page");
             String size =request.getParameter("limit");
             Integer pageSize =1;
             Integer pageNumber=10;
             if(!"".equals(page) && page !=null){
                 pageSize =Integer.parseInt(page);
             }
             if(!"".equals(size) && size!=null){
                 pageNumber =Integer.parseInt(size);
             }
             Integer totalCount =userService.getTotal();

             List<User> users =userService.getUsers(pageSize,pageNumber);
             JSONArray array =JSONArray.fromObject(users);
             obj.put("code",0);
             obj.put("count",totalCount);
             obj.put("data",array);
             response.getWriter().write(obj.toString());
    }
}
