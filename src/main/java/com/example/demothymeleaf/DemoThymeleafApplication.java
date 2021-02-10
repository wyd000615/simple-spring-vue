package com.example.demothymeleaf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class DemoThymeleafApplication {
    @Value("${book.id}")
    private static String bookId;
    public static void main(String[] args) {

        SpringApplication.run(DemoThymeleafApplication.class, args);
        System.out.println(bookId);
    }

}
