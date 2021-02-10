package com.example.demothymeleaf.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

@WebFilter("/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
       // System.out.println("Myfilter>>>>init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
      //  System.out.println("Myfilter>>>>doFilter");

        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {
       // System.out.println("Myfilter>>>>destroy");

    }
}
