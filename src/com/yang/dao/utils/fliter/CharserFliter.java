package com.yang.dao.utils.fliter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class CharserFliter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setCharacterEncoding("UTF-8");
        //编码过滤器
        filterChain.doFilter(servletRequest,servletResponse);

    }
    @Override
    public void destroy() {
    }
}
