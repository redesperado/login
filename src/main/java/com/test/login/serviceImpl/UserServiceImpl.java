package com.test.login.serviceImpl;

import com.test.login.bean.UserBean;
import com.test.login.dao.UserDao;
import com.test.login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
 
    //将DAO注入Service层
    @Autowired
    UserDao userDao;
 
    @Override
    public UserBean loginIn(String name, String password) {
        return userDao.getInfo(name,password);
    }

    @Override
    public String getRole(String name) {
        return userDao.getRole(name);
    }

    @Override
    public String getPassword(String name) {
        return userDao.getPassword(name);
    }

}