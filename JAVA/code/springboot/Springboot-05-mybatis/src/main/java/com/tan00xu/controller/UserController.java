package com.tan00xu.controller;

import com.tan00xu.mapper.UserMapper;
import com.tan00xu.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/listAllUser")
    public List<User> listAllUser(){
        List<User> userList = userMapper.listAllUser();
        userList.forEach(System.out::println);
        return userList;

    }

}
