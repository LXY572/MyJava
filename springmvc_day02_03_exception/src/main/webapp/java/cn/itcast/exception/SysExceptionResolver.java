package cn.itcast.exception;

import org.springframework.lang.Nullable;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器的构造
 */
public class SysExceptionResolver implements HandlerExceptionResolver{


    /**
     * 处理异常业务逻辑
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @return
     */
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,  Object o, Exception e) {
        //获取到异常对象
        SysException ex = null;
        if(e instanceof SysException){
            ex = (SysException)e;
        }else {
            ex =new SysException("系统正在维护。。。");
        }
        //ModelAndView可以跳转某界面,创建ModelAndView对象
        ModelAndView mv = new ModelAndView();
        mv.addObject("errorMsg",ex.getMessage());
        mv.setViewName("error");
        return mv;
    }
}