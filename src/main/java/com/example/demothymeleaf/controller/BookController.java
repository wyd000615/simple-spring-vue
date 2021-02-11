package com.example.demothymeleaf.controller;

import com.example.demothymeleaf.pojo.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller

public class BookController {
    @Autowired
    RedisTemplate redisTemplate;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/redis")
    @ResponseBody
    public void testRedis() {
        ValueOperations<String, String> ops01 = stringRedisTemplate.opsForValue();
        ops01.set("name", "三国演义");
        String name = ops01.get("name");
        System.out.println("====从redis里面获取name===" + name);
        ValueOperations ops2 = redisTemplate.opsForValue();
        Book book = new Book();
        book.setId(1);
        book.setName("红楼梦");
        book.setAuthor("曹雪芹");
        ops2.set("book", book);
        Book book2 = (Book) ops2.get("book");
        System.out.println("====从redis里面获取book2===" + book2);

    }


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
    @CrossOrigin(value = "http://localhost:8081", maxAge = 1800, allowedHeaders = "*")
    public String addBook(String name) {
        return "receive:" + name;

    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    @CrossOrigin(value = "http://localhost:8081", maxAge = 1800, allowedHeaders = "*")

    public String deleteBookById(@PathVariable Long id) {
        return String.valueOf(id);
    }

}
