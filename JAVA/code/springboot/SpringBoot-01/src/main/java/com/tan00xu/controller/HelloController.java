package com.tan00xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {

        @RequestMapping("/sayHello")
        @ResponseBody
        public String sayHello() {
            return "hello";
        }
}
