package com.example.demothymeleaf.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
/*
*
* 整合 servlet
* 注意 需要在启动类中添加@ServletComponentScan 注解 否则无效
* webservlet中的值应该为 web页面的请求，不能为json返回的方法
* */
@Slf4j
@WebServlet("/test2")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        //System.out.println("=1===myservlet===doPost==req="+req.getParameter("name"));
       // log.info("====myservlet===doPost==req="+req.getParameter("name"));
        super.doPost(req, resp);
    }
}
