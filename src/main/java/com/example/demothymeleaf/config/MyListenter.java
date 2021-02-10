package com.example.demothymeleaf.config;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyListenter  implements ServletRequestListener {
    @Override
    public void requestDestroyed(ServletRequestEvent sre) {
        //System.out.println("MyListenter>>>>sre="+sre.getServletContext().getContext("/").toString()+"==="+sre.getServletRequest().getProtocol().toString());

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        //System.out.println("MyListenter>>>>init="+sre.getServletContext()+"==="+sre.getServletRequest());

    }
}
