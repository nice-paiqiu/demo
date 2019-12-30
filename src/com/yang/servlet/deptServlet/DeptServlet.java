package com.yang.servlet.deptServlet;

import com.yang.po.Dept;
import com.yang.service.impl.DeptServiceImpl;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/dept")
public class DeptServlet extends HttpServlet {
    DeptServiceImpl deptService = new DeptServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        System.out.println("==========部门开始==========");
        //分页信息
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

        System.out.println("pageSize:"+pageSize);
        System.out.println("pageNumber:"+pageNumber);

        Integer total = deptService.getTotal();
        System.out.println("total:"+total);
        List<Dept> depts = deptService.getDepts(pageSize,pageNumber);

        JSONObject obj = new JSONObject();
        JSONArray array = JSONArray.fromObject(depts);
        obj.put("code",0);
        obj.put("count",total);
        obj.put("data",array);
        response.getWriter().write(obj.toString());
        System.out.println(obj.toString());
        System.out.println("==========部门结束==========");

    }
}
