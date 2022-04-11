package com.tan00xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ForwardController {
    @RequestMapping("/f1")
    public String test(Model model){
        model.addAttribute("msg","不走视图解析器");
        //转发
//        return "/WEB-INF/jsp/test.jsp";
        //转发
//        return "forward:/WEB-INF/jsp/test.jsp";
        //重定向
        return "redirect:/index.jsp";
    }

    @RequestMapping("/f2")
    public String test2(Model model){
        model.addAttribute("msg","走视图解析器");
        //转发
        return "test";
        //重定向
//        return "redirect:/index.jsp";
    }


}
