package com.example.demothymeleaf;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@ServletComponentScan
@SpringBootApplication
@MapperScan("com.example.demothymeleaf.dao")
@PropertySource(value={"classpath:datasource.properties","classpath:redis.properties"})
public class DemoThymeleafApplication {
    @Value("${book.id}")
    private static String bookId;
    public static void main(String[] args) {

        SpringApplication.run(DemoThymeleafApplication.class, args);
        System.out.println(bookId);
    }

}
