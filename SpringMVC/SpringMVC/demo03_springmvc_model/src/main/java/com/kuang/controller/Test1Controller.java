package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class Test1Controller {

    //ModelAndView
    @RequestMapping("/t1")
    public ModelAndView test1(HttpServletRequest request, HttpServletResponse response){
        ModelAndView mv = new ModelAndView();
        mv.addObject("msg","test1Controller");
        mv.setViewName("test");
        return mv;
    }

    //使用ServletApi
    @RequestMapping("/t2")
    public void test2(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("msg","test2Controller");
        //request.getSession().setAttribute();
        request.getRequestDispatcher("index.jsp").forward(request,response);//请求转发
        //response.sendRedirect("index.jsp");
    }

    //使用SpringMVC，不用视图解析器
    @RequestMapping("/t3")
    public String test3(HttpServletRequest request){
        request.setAttribute("msg","test3Controller");
        //return "index.jsp"; //请求转发
        return "forward:index.jsp";//请求转发
        //return "redirect:index.jsp";//重定向
    }

    //使用SpringMVC，有视图解析器
    @RequestMapping("/t4")
    public String test4(){
        return "test";
    }


}
