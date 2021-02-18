package com.demo.quartz;

import org.springframework.stereotype.Component;

@Component
public class MyFirstJob {
    public void sayHello(){
        System.out.println("======firstJob#sayhello=====");
    }

}
