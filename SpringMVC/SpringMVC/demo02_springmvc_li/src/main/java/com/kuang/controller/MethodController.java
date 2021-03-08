package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/m")
public class MethodController {

    //method:限定请求的方法：get。post
    //这个方法的意思就是，请求 服务器/项目名/m/post 这个请求只能使用post方法提交
    //@RequestMapping(value = "/post",method ={RequestMethod.GET} )
    @RequestMapping(value = "/post",method ={RequestMethod.POST} )
    public String onlyPost(Model model){
        model.addAttribute("msg","允许Post请求进入");
        return "hello";
    }

}
