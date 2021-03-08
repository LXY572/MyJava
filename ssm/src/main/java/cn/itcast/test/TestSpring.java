package cn.itcast.test;

import cn.itcast.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
    @Test//属于junit依赖
    public void run1(){
        //  加载配置文件,即resources中的applicationContext.xml文件，获取核心容器对象（ioc）
        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        //  根据id获取Bean对象，即java.cn.itcast.service.impl.AccountServiceImpl中的@Service("accountService")注解
        AccountService as = (AccountService) ac.getBean("accountService");

        //  调用其中的findAll()方法
        as.findAll();
    }













}
