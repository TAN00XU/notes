package com.tan00xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 注解@Controller表示这是一个控制器，会被spring管理
 * 被这个注解标注的类，会被spring初始化，并且会被加载到容器中
 * 如果返回值是String，并且有@RequestMapping，则会被视图解析器解析，并跳转到指定的页面
 */
@Controller
public class ControllerTesr2 {
    @RequestMapping("/t2")
    public String test1(Model model){
        model.addAttribute("msg","ControllerTesr2");
        return "test";

    }
}
