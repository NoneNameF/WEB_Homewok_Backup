package com.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
//        String uri = ((HttpServletRequest) request).getRequestURI();
//        System.out.println("登录过滤");
//        if (uri.contains("/index.jsp") || uri.contains("/pic/") || uri.contains("/nav.jsp") || uri.contains("/login") || uri.contains("*.css") || uri.contains("*.js")) {
//            chain.doFilter(request, response);
//        } else {
//            Object manager = ((HttpServletRequest) request).getSession().getAttribute("Manager");
//            if (manager != null) chain.doFilter(request, response);
//            else request.getRequestDispatcher("/index.jsp").forward(request, response);
//        }
        chain.doFilter(request, response);
    }
}
