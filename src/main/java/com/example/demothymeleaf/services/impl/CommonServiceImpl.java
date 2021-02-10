package com.example.demothymeleaf.services.impl;

import com.example.demothymeleaf.services.CommonService;
import org.springframework.stereotype.Service;

@Service
public class CommonServiceImpl implements CommonService {
    @Override
    public void sayHello() {
        System.out.println("==我是CommonServiceImpl#sayHello==");
    }
}
