package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    //跳到登录页面
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }


    //跳到成功页面
    @RequestMapping("/toSuccess")
    public String toSuccess(){
        return "success";
    }


    //登录
    @RequestMapping("/login")
    public String login(String username, String pwd, HttpSession session){
        //接收前端的信息，判断是否正确，方法哦session中；
        System.out.println("用户名====="+username);

        session.setAttribute("user",username);

        return "success";
    }

    //注销
    @RequestMapping("/loginOut")
    public String loginOut(HttpSession session){
        session.invalidate();
        return "login";
    }


}
