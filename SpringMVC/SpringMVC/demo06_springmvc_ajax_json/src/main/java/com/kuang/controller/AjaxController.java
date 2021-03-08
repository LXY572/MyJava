package com.kuang.controller;

import com.kuang.pojo.User;
import com.kuang.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListResourceBundle;

@Controller
@RequestMapping("/ajax")
public class AjaxController {

    //第一种方式，服务器要返回一个字符串，直接使用response
    @RequestMapping("/a1")
    public void ajax(String name, HttpServletResponse response) throws IOException {
        if ("admin".equals(name)){
            response.getWriter().print("true");
        }else {
            response.getWriter().print("false");
        }
    }


    @RequestMapping("/a2")
    @ResponseBody
    public List<User> ajax2(){

        List<User> list = new ArrayList<>();

        User user1 = new User("秦疆1号",1,"男");
        User user2 = new User("秦疆2号",1,"男");
        User user3 = new User("秦疆3号",1,"男");
        User user4 = new User("秦疆4号",1,"男");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        return list; //由于加了@ResponseBody注解，他会返回一个字符串；
    }

    @RequestMapping("/a3")
    @ResponseBody
    public String ajax3(String name,String pwd){
        String msg = "";
        if (name!=null){
            if ("admin".equals(name)){
                msg = "ok";
            }else {
                msg = "用户名有误";
            }
        }
        if (pwd!=null){
            if ("123456".equals(pwd)){
                msg = "ok";
            }else {
                msg = "密码输入有误";
            }
        }
        return msg;
    }



}
