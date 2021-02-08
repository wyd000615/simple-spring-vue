package com.demo.Controller;

import com.demo.POJO.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @Autowired
    Book book;
    @GetMapping("/demo01")
    public String sayHello(){
        return "hello,world";
    }
    @GetMapping("/demo02")
    public String sayHello2(){
        return book.toString();
    }
}
