package com.test.login.controller;

import com.test.login.dao.UserDao;
import com.test.login.service.UserService;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
public class LogincfgController {

    @Autowired
    private UserService userService;


    @RequestMapping(value = "/notLogin", method = RequestMethod.GET)
    public String notLogin() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "您尚未登陆！");
        return "login";
    }


    @RequestMapping(value = "/noRole", method = RequestMethod.GET)
    public String notRole() {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "您没有权限！");
        return "login/noRole";
    }


    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        //注销
        subject.logout();
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("msg", "成功注销！");
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String toLogin () {
        return "login";
    }

    @RequestMapping("/admin")
    public String admin(){
        return "login/admin";
    }

    @RequestMapping("/user")
    public String user(){
        return "login/user";
    }


    @RequestMapping("/noRole")
    public String noRole(){
        return "login/noRole";
    }

    @RequestMapping("/main")
    public String main(){
        return "main";
    }



    /**
     * 登陆
     *
     * @param username 用户名
     * @param password 密码
     */
    @ResponseBody
    @RequestMapping(value = "/loginIn", method = RequestMethod.POST)
    public Map<String,Object> login(String username, String password) {
        // 从SecurityUtils里边创建一个 subject
        Subject subject = SecurityUtils.getSubject();
        // 在认证提交前准备 token（令牌）
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        // 执行认证登陆   封装了用户名，密码的 token 作为参数传入
        subject.login(token);
        //根据权限，指定返回数据
        String role = userService.getRole(username);
//        String sessionId = (String) subject.getSession().getId();
//        Session session = subject.getSession();
        Map<String, Object> map = new HashMap<>();
//        int userId = userService.getUserId(username);
        //modelMap.addAttribute("backInfo", backLessonsService.getBackLessonsList());
        //return "background/background-table" ;
/*        	Cookie cookie = new Cookie("sessionId",sessionId);
        	response.addCookie(cookie);*/
        map.put("msg", "success");
        map.put("role", role);
        map.put("username", username);
        if(role != "" && role != null){
            map.put("resultCode",1);
        }else{
            map.put("resultCode",2);
        }

//        session.setAttribute("role", role);
//        session.setAttribute("userId", userId);
//        session.setAttribute("username", username);
//        session.setAttribute("sessionId", sessionId);
        return map;
    }
}