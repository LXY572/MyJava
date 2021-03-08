package com.kuang.interceptor;

import com.sun.org.apache.regexp.internal.RE;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("进入UserInterceptor拦截器区域");

        //判断是不是登录页面，如果是就放行；
        System.out.println("url:"+request.getRequestURL());//获得请求的路径
        if (request.getRequestURI().contains("login")){
            System.out.println("login放行");
            return true;
        }

        //如果用户已经登录，放行
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("user"));
        if (session.getAttribute("user")!=null){
            System.out.println("登录放行");
            return true;
        }

        //如果用户没有登录，想进成功页面，拦截，让他回到登录页面
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,response);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
