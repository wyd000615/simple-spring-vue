package com.example.demothymeleaf.services.impl;

import com.example.demothymeleaf.services.UserService;
import org.springframework.stereotype.Service;

@Service("usrService")
public class UserServiceImpl  implements UserService {
    public String getUserById(Integer id){
        System.out.println("====get====");
        return "user";
    }
    public void deleteUserById(Integer id){
        System.out.println("====delete====");

    }
}
