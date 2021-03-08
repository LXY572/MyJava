package com.kuang.controller;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/item")
public class MappingController {

    //@RequestMapping("/add?p1=1&p2=2")
    @RequestMapping("/add/{p1}/{p2}/{name}")
    public String add(@PathVariable int p1,@PathVariable int p2,@PathVariable String name, Model model){
        String sum = p1 + p2 + name;
        //String sum = name+ p1 + p2;
        model.addAttribute("msg",sum);
        return "hello";
    }

//    public ModelAndView add2(HttpServletRequest request, HttpServletResponse response){
//        ModelAndView modelAndView = new ModelAndView();
//        String p1 = request.getParameter("p1");
//        String p2 = request.getParameter("p2");
//        String add = p1+p2;
//        modelAndView.addObject("msg",add);
//        modelAndView.setViewName("hello");
//        return modelAndView;
//    }

}
