package com.test.login.dao;


import com.test.login.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao {
 
    UserBean getInfo(String name, String password);

    String getRole(String name);

    String getPassword(String name);
}