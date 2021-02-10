package com.example.demothymeleaf.config;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.HashMap;
import java.util.Map;

/*
* controlleradvice  全局数据
* */
@ControllerAdvice
public class GlobalConfig {
    @ModelAttribute(value = "info")
    public Map<String,String>  getGlobalMap(){
        HashMap<String, String> gobalMap = new HashMap<>();
        gobalMap.put("name","wyd");
        gobalMap.put("age","24");
        return  gobalMap;
    }
}
