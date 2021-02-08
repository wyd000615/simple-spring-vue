package com.example.demothymeleaf.controller;

import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.channels.MulticastChannel;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@RestController()
public class FileUploadController {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd/");

    @PostMapping("/upload")
    @ResponseBody
    public String upload(MultipartFile uploadFile, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //生成文件路径
        ServletContext servletContext = request.getSession().getServletContext();
        System.out.println(request.getServletPath());
        ;//获取能够与“url-pattern”中匹配的路径，注意是完全匹配的部分，*的部分不包括。
        System.out.println("=======request.getPathInfo()======" + request.getPathInfo());//:与getServletPath()获取的路径互补，能够得到的是“url-pattern”中*d的路径部分
        System.out.println("=====request.getContextPath()========" + request.getContextPath());//:获取项目的根路径
        System.out.println("======request.getRequestURI()=======" + request.getRequestURI());//:获取根路径到地址结尾
        System.out.println("=====request.getRequestURL()========" + request.getRequestURL());//:获取请求的地址链接（浏览器中输入的地址）
        System.out.println("======request.getServletContext().getRealPath(\"/\")=======" + request.getServletContext().getRealPath("/"));//:获取“/”在机器中的实际地址
        System.out.println("======request.getScheme()=======" + request.getScheme());//:获取的是使用的协议(http 或https)
        System.out.println("=====request.getProtocol()========" + request.getProtocol());//:获取的是协议的名称(HTTP/1.11)
        System.out.println("=======request.getServerName()======" + request.getServerName());//:获取的是域名(xxx.com)
        System.out.println("====request.getLocalName()=========" + request.getLocalName());//:获取到的是IP
        String realPath = request.getSession().getServletContext().getRealPath("/uploadFile/");
        // String realPath = ResourceUtils.getFile("/uploadFile/").getPath();
        String format = sdf.format(new Date());
        System.out.println(ResourceUtils.getFile("/uploadFile/" + format).getName());
        System.out.println(ResourceUtils.getFile("/uploadFile/" + format).getPath());
        System.out.println(ResourceUtils.getFile("/uploadFile/" + format).getAbsolutePath());
        //String realPath = "D:\\vue_workspace\\demo-thymeleaf-202210124/uploadFile/";
        File file = new File(realPath + format);
        System.out.println("===file=的生成路径=" + realPath + "==文件名==" + realPath + format);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        //
        String oldFilename = uploadFile.getOriginalFilename();
        String newFilename = UUID.randomUUID().toString() + oldFilename.substring(oldFilename.lastIndexOf("."), oldFilename.length());
        uploadFile.transferTo(new File(file, newFilename));
        String filePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + "/uploadFile/" + format + newFilename;
        return filePath;
    }
}
