package com.example.demothymeleaf.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@Import(value = "classpath:config.properties")
public class TestController {
    @Value("${book.id:25-}")
    private  String bookId;
    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        System.out.println("xxxxxxxxx" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "" +
                "");
        return bookId;
    }
}
