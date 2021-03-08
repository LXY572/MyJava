package com.kuang.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kuang.pojo.User;
import com.kuang.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/json1")
    //思考问题，我们正常返回他会走视图解析器，而json需要返回的是一个字符串；
    //市面上有很多的第三方jar包可以实现这个功能，jackson.只需要一个简单的注解就可以实现了；
    //@ResponseBody , 将服务器端返回的对象转换为json对象响应回去；
    @ResponseBody
    public String json1() throws JsonProcessingException {
        //需要一个jackson的对象映射器，就是一个类，使用它可以直接将对象转换为json字符串；
        ObjectMapper mapper = new ObjectMapper();

        //创建一个对象
        User user = new User("秦疆1号",1,"男");
        System.out.println(user);

        //将Java对象转换为json字符串；
        String str = mapper.writeValueAsString(user);
        System.out.println(str);

        return str; //由于使用了@ResponseBody注解，这里会将str以json格式的字符串返回，十分方便；
    }

    //发现一个问题，乱码了，怎么解决？给@RequestMapping加一个属性
    //发现出现了乱码问题，我们需要设置一下他的编码格式为utf-8，以及它返回的类型；
    // 通过@RequestMaping的produces属性来实现，修改下代码
    //produces:指定响应体返回类型和编码
    @RequestMapping(value = "/json2",produces = "application/json;charset=utf-8")
    @ResponseBody
    public String json2() throws JsonProcessingException {

        User user = new User("秦疆1号",1,"男");

        return new ObjectMapper().writeValueAsString(user);
    }

    @RequestMapping(value = "/json3")
    @ResponseBody
    public String json3() throws JsonProcessingException {

        List<User> list = new ArrayList<>();

        User user1 = new User("秦疆1号",1,"男");
        User user2 = new User("秦疆2号",1,"男");
        User user3 = new User("秦疆3号",1,"男");
        User user4 = new User("秦疆4号",1,"男");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);

        return new ObjectMapper().writeValueAsString(list);
    }

    @RequestMapping(value = "/time1")
    @ResponseBody
    public String json4() throws JsonProcessingException {

        Date date = new Date();
        System.out.println(date);
        //发现问题：时间默认返回的json字符串变成了时间戳的格式：1564711481926 Timestamp。

        return new ObjectMapper().writeValueAsString(date);
    }

    @RequestMapping(value = "/time2")
    @ResponseBody
    public String json5() throws JsonProcessingException {

        ObjectMapper mapper = new ObjectMapper();
        //1.如何让他不返回时间戳！所以我们要关闭它的时间戳功能
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS,false);
        //2.时间格式化问题！自定日期格式对象；
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //3.让mapper指定时间日期格式为simpleDateFormat；
        mapper.setDateFormat(sdf);

        //写一个日期对象
        Date date = new Date();

        return mapper.writeValueAsString(date);
    }

    //发现问题，重复代码太多，给它编写一个工具类；
    @RequestMapping(value = "/time3")
    @ResponseBody
    public String json6() throws JsonProcessingException {
        return JsonUtils.getJson(new Date());
    }

}
