package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @RequestMapping("/hello")
    //请求参数名和处理参数名一样的情况下，我们直接接收到前端传递的数据；
    //Model主要作用：为了给前端传递我们封装好的参数；
    public String hello(String name, Model model){
        System.out.println(name);
        model.addAttribute("aaa",name);
        return "user";
    }

    //请求参数名和处理参数名不一样的情况下
    //状况：用户传递的参数名和我们要处理的参数名不一致，需要使用一个注解@RequestParam("username")来进行匹配
    @RequestMapping("/hello2")
    public String hello2(@RequestParam(value = "username",required = false) String name){
        System.out.println(name);
        return "user";
    }

    //如何传递一个对象
    //要求:提交表单的数据和对象的属性名一致；参数直接使用对象即可；否则按照上面方式处理
    //http://localhost:8080/mvc04/hello3?id=1&name=qinjiang&age=18;
    @RequestMapping("/hello3")
    public String hello3(User user,Model model){
        System.out.println(user);
        model.addAttribute("user",user);
        return "user";
    }

    //原理：接收到前端请求参数名，匹配你传递的对象的属性；如果属性OK，使用set方法赋值，否则使用默认值；
//    public String hello4(int id,int age,String name,Model model){
//        User user = new User(id, name, age);
//        System.out.println(user);
//        model.addAttribute("user",user);
//        return "user";
//    }


}
