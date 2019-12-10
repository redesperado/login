package com.test.login.service;

import com.test.login.bean.UserBean;

public interface UserService {
 
    UserBean loginIn(String name, String password);

    String getRole(String name);

    String getPassword(String name);
 
}
