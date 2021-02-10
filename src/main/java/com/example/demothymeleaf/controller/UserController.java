package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/getUser")
    public String getUser(){
        String userById = userService.getUserById(2);
        return userById;
    }

    /*
    * 测试aop
    * 打印日志
    *
    * */
    @RequestMapping("/getUserLog")
    public void getUserLog(){
         userService.getUserLog();
    }

}
