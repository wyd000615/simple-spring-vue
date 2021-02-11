package com.example.demothymeleaf.services.impl;

import com.example.demothymeleaf.dao.UserDao;
import com.example.demothymeleaf.pojo.User;
import com.example.demothymeleaf.services.CommonService;
import com.example.demothymeleaf.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.net.ftp.impl.FtpClient;

@Service()
public class UserServiceImpl  implements UserService {
    @Autowired
    CommonService commonService;
    @Autowired
    UserService self;
    private FtpClient ServiceLogProxy;
    @Autowired
    UserDao userDao;

    public String getUserById(Integer id){
        System.out.println("====get====");
        return "user";
    }
    @Override
    public void deleteUserById(Integer id){
        System.out.println("====delete====");

    }

    @Override
    public void getUserLog() {
        self.deleteUserById(1);
        commonService.sayHello();
    }

    @Override
    public User queryUserById(Integer id) {
        User user = userDao.selectByPrimaryKey(id);
        return user;
    }
}
