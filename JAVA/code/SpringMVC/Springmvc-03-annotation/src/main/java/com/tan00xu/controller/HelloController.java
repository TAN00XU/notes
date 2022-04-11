package com.tan00xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
//若类上加了RequestMapping，则地址先经过类上的RequestMapping，再经过方法上的RequestMapping
@RequestMapping("/helloController")
public class HelloController {

    //真实访问地址(http://localhost:8080/helloController/hello)
    @RequestMapping("/hello")
    public String hello(Model model) {
        //向模型中添加属性msg与值，可以在JSP页面中取出并渲染
        model.addAttribute("msg","HELLO,SpringMVC annotation");
        //返回给视图解析器处理
        return "hello";
    }

}
