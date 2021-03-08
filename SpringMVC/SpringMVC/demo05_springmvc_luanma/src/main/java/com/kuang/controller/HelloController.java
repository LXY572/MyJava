package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.UnsupportedEncodingException;

@Controller
public class HelloController {

    @RequestMapping("/h1")
    public String hello(String name, Model model) throws UnsupportedEncodingException {
        System.out.println(name);
        model.addAttribute("name",name);
        return "user";
    }

}
