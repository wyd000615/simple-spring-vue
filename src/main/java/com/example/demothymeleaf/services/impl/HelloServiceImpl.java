package com.example.demothymeleaf.services.impl;

import com.example.demothymeleaf.services.HelloService;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {
    @Override
    public void sayHello() {
        System.out.println("====我是helloservice===");
    }
}
