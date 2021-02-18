package com.example.demothymeleaf.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HellorController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello";
    }
    @RequestMapping("/admin/hello")
    public String adminhello(){
        return "只有admin权限的人才能访问该链接";
    }
    @RequestMapping("/user/hello")
    public String userhello(){
        return "只有user权限的人才能访问该链接";
    }





}
