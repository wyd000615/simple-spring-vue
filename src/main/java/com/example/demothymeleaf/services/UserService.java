package com.example.demothymeleaf.services;

import com.example.demothymeleaf.pojo.User;
import org.springframework.stereotype.Service;


public interface UserService {
    public String getUserById(Integer id);
    public void deleteUserById(Integer id);
    /*
    * 自测aop日志
    * */
    void getUserLog();

    User queryUserById(Integer id);
}
