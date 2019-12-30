package com.yang.servlet.deptServlet;

import com.yang.service.impl.DeptServiceImpl;

import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateDept")
public class UpdateDeptServlet extends HttpServlet{

    DeptServiceImpl deptService =  new DeptServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("=========修改开始========");
        JSONObject obj = new JSONObject();
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        System.out.println("修改id："+id+"修改为："+name);
        if ("".equals(name)||name==null){
            obj.put("status",0);
            obj.put("msg","名称不允许为空");
        }else {
            int result = deptService.updateDept(Integer.parseInt(id),name);
            if (result>0){
                obj.put("status",1);

            }else{
                obj.put("status",0);
                obj.put("msg","修改失败");
            }
        }
        response.getWriter().write(obj.toString());
        System.out.println("=========修改结束=========");
    }
}
