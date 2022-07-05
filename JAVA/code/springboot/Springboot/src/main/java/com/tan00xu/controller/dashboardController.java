package com.tan00xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//在templates目录下的所有页面，只能通过controller来跳转
@Controller
public class dashboardController {
    @RequestMapping("/dashboard")
    public String index() {
        return "dashboard";
    }
}
