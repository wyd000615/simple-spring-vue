package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.pojo.User;
import com.example.demothymeleaf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/getUser")
    public String getUser() {
        String userById = userService.getUserById(2);
        return userById;
    }

    /*
     * 测试aop
     * 打印日志
     *
     * */
    @RequestMapping("/getUserLog")
    public void getUserLog() {
        userService.getUserLog();
    }

    /*
     * 测试mysql - myvatis
     * */
    @RequestMapping("/queryUserById/{id}")
    //@ResponseBody
    public User queryUserById(@PathVariable("id") Integer id) {
        System.out.println("=====id===" + id);
        User user = userService.queryUserById(id);
        return user;
    }


}
