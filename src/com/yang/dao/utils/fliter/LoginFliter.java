package com.yang.dao.utils.fliter;

import com.yang.po.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
//@WebFilter("/*")
public class LoginFliter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        System.out.println();
        if(request.getRequestURI().equals("/layuiDemo01/") || request.getRequestURI().equals("/layuiDemo01/login.jsp") || request.getRequestURI().equals("/layuiDemo01/loginServlet")){
            filterChain.doFilter(servletRequest,servletResponse);
        }else{
            User user = (User) request.getSession().getAttribute("user");
            if(user!=null){
                filterChain.doFilter(servletRequest,servletResponse);
            }else{

                request.getRequestDispatcher("/login.jsp").forward(request,(HttpServletResponse) servletResponse);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
