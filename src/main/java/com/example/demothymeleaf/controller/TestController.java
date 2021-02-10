package com.example.demothymeleaf.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@Slf4j
@Controller
//@Import(value = "classpath:config.properties")
public class TestController {
    @Value("${book.id:25-}")
    private String bookId;

    @RequestMapping("/test")
    @ResponseBody
    public String test() {
        System.out.println("xxxxxxxxx");
        return bookId;
    }

    @RequestMapping("/testgobal")
    @ResponseBody
    public void testgobal(Model model) {
        Map<String, Object> gobalMap = model.asMap();
        Set<String> keySet = gobalMap.keySet();
        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            Object value = gobalMap.get(key);
            log.info("==获取全局数据==key" + key + "====对应的value==" + value);

        }
        for (String key : gobalMap.keySet()) {
            Object value =gobalMap.get(key);
            log.info("==获取全局数据=2=key" + key + "====对应的value==" + value);
        }

    }
}
