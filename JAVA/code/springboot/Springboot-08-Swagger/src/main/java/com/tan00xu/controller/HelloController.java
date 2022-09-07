package com.tan00xu.controller;

import com.tan00xu.pojo.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class HelloController {

    @RequestMapping(value = "/hello")
    @ApiOperation("hello接口")
    public String hello() {
        return "hello";
    }


    /**
     * 只要我们的返回值中存在实体类，他就会被扫描到Swagger中
     *
     * @return {@link User}
     */
    @ApiOperation("用户接口")
    @PostMapping("/user")
    public User user(){
        return new User();
    }
}
