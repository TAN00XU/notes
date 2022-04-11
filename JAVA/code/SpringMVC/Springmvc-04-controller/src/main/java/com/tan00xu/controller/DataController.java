package com.tan00xu.controller;

import com.tan00xu.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DataController {
    @GetMapping("t1")
    //可以通过@RequestParam注解指定名称
    public String test(@RequestParam("username") String name) {
        System.out.println("接收到的参数：" + name);
        return "test";
    }

    /**
     * 1.接收前端用户传递的参数,判断参数的名字,假设名字直接在方法上,可以直接使用
     * 2.假设传递的是一个对象User,匹配User对象中的字段名
     *
     * 接收前端传递的对象：id,name,age
     */
    @GetMapping("t2")
    //可以通过@RequestParam注解指定名称
    public String test2(User user) {
        System.out.println("接收到的参数：" + user);
        return "test";
    }

    @GetMapping("t3")
    public String test3(Model model) {
        model.addAttribute("msg", "hello world");
        return "test";
    }

    @GetMapping("t4")
    public String test4(ModelMap modelMap) {
        modelMap.addAttribute("msg", "hello world");
        return "test";
    }
}
