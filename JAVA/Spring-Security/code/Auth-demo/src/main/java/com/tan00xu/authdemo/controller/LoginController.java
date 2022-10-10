package com.tan00xu.authdemo.controller;

import com.tan00xu.authdemo.domain.ResponseResult;
import com.tan00xu.authdemo.domain.User;
import com.tan00xu.authdemo.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 饮梦 TAN00XU
 * @date 2022/10/09 16:21
 */
@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @PostMapping("/user/login")
    public ResponseResult login(@RequestBody User user) {
        return loginService.login(user);
    }

    @PostMapping("/user/logout")
    public ResponseResult logout() {
        return loginService.logout();
    }
}
