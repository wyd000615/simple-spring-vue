package com.example.demothymeleaf.config;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
* 注册拦截器
* springmvc 中提供了aop风格的拦截器
* 拥有更加清晰的拦截处理能力
* 拦截器中的方法将按
* preHandle -》 controller -> postHandle->afterCompletion 的顺序执行
*
* */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
       // System.out.println("=======preHandle====");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        //System.out.println("=======postHandle====");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        //System.out.println("=======afterCompletion====");

    }
}
