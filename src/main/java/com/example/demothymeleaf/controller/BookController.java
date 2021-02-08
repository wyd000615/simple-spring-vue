package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.pojo.Book;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller

public class BookController {
    @GetMapping("/books")
    public ModelAndView books() {
        List<Book> bookList = new ArrayList<Book>();
        Book mybook = new Book();
        mybook.setId(1);
        mybook.setName("第一本书");
        mybook.setAuthor("wyd");
        bookList.add(mybook);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("books", bookList);
        modelAndView.setViewName("books");
        System.out.println(modelAndView.getViewName());
        return modelAndView;
    }

    @GetMapping("/book")
    @ResponseBody
    public Book book() {
        List<Book> bookList = new ArrayList<Book>();
        Book mybook = new Book();
        mybook.setId(1);
        mybook.setName("第一本书");
        mybook.setAuthor("wyd");
        mybook.setPrice((float) 222);
        mybook.setPublicaitonDate(new Date());
        bookList.add(mybook);

        return mybook;
    }
    @PostMapping("/add")
    @ResponseBody
    @CrossOrigin(value = "http://localhost:8081",maxAge = 1800,allowedHeaders = "*")
    public String addBook(String name){
        return "receive:"+name;

    }
    @DeleteMapping("/delete/{id}")
    @ResponseBody
    @CrossOrigin(value = "http://localhost:8081",maxAge = 1800,allowedHeaders = "*")

    public String deleteBookById(@PathVariable Long id ){
        return String.valueOf(id);
    }

}
