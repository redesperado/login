package com.test.login.controller;

import com.test.login.service.UserService;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
public class LoginController {
 
    //将Service注入Web层
//    @Autowired
//    private UserService userService;


//    @RequestMapping("/login")
//    public String show(){
//        return "login";
//    }
//
//    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
//    public String login(String name,String password){
//        UserBean userBean = userService.loginIn(name,password);
//        if(userBean!=null){
//            return "success";
//        }else {
//            return "error";
//        }
//    }

//    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
//    public String login(String name,String password){
//        //从SecurityUtils中创建一个subject
//        Subject subject = SecurityUtils.getSubject();
//        //在认证前提交准备token（令牌）
//        UsernamePasswordToken token = new UsernamePasswordToken(name,password);
//        //执行认证登录
//        subject.login(token);
//        //根据权限，返回指定数据
//        String role = userService.getRole(name);
//        if("user".equals(role)){
//            System.out.println("--------用户登录-------");
//            return "success";
//        }
//        if("admin".equals(role)){
//            System.out.println("--------管理员登录-------");
//            return "success";
//        }
//        System.out.println("--------无权限登录-------");
//        return "error";
//    }

//    @RequestMapping("/admin")
//    public String admin(){
//        return "login/admin";
//    }
//
//    @RequestMapping("/user")
//    public String user(){
//        return "login/user";
//    }
//
//
//    @RequestMapping("/noRole")
//    public String noRole(){
//        return "login/noRole";
//    }
 
 
 
}