package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class AnnoController {

    //请求映射：url
    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("msg","Hello,SpringMVC");
        return "hello";
    }
    @RequestMapping("/hello2")
    public String hello2(Model model){
        model.addAttribute("msg","Hello,SpringMVC2");
        return "hello";
    }

}
