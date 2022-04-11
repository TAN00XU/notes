package com.tan00xu.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.tan00xu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//使用@RestController注解后，类中所有方法返回的都是json数据，不需要再写@ResponseBody注解，不会走视图解析器
@RestController
public class UserController {

    //produces = "application/json;charset=UTF-8"设置返回的数据类型,解决JSON乱码问题
    @RequestMapping(value = "/j1")
    //加上@ResponseBody注解后，就不会走视图解析器了，而是直接返回json数据
    public String json1() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User("饮梦", 18, "男");

        String s = objectMapper.writeValueAsString(user);

        return s;
    }

    @RequestMapping("/j2")
    public String json2() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        List<User> userList = new ArrayList<User>();
        User user0 = new User("饮梦", 18, "男");
        User user1 = new User("饮梦", 18, "男");
        User user2 = new User("饮梦", 18, "男");
        User user3 = new User("饮梦", 18, "男");
        User user4 = new User("饮梦", 18, "男");

        userList.add(user0);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        String s = objectMapper.writeValueAsString(userList);

        return s;
    }

    @RequestMapping("/j3")
    public String json3() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();

        Date date = new Date();

        //使用ObjectMapper关闭格式化为时间戳，默认是true
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //通过setDateFormat设置日期格式
        objectMapper.setDateFormat(simpleDateFormat);
        //原生simpleDateFormat方式转换格式
        String dateFormat = simpleDateFormat.format(date);

        //ObjectMapper解析时间后的默认格式为：TimeStamp,时间戳格式
        return objectMapper.writeValueAsString(date);
    }

    @RequestMapping("/j4")
    public String json4() throws JsonProcessingException {


        List<User> userList = new ArrayList<User>();
        User user0 = new User("饮梦0", 18, "男");
        User user1 = new User("饮梦1", 18, "男");
        User user2 = new User("饮梦2", 18, "男");
        User user3 = new User("饮梦3", 18, "男");
        User user4 = new User("饮梦4", 18, "男");

        userList.add(user0);
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);

        return JSON.toJSONString(userList);

    }
}
