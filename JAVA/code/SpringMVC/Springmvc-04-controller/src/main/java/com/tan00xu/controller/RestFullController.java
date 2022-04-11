package com.tan00xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFullController {
    //过去的方式 ： http://localhost:8080/add?a=1&b=2
    //RestFul风格的方式： http://localhost:8080/add/1/2
    @RequestMapping(path = "/add/{a}/{b}",method={RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.HEAD} )
    //使用@PathVariable注解接收参数
 /*   @GetMapping("/add/{a}/{b}")
    @PostMapping()
    @PutMapping()
    @DeleteMapping()
    @PatchMapping()
*/
    public String test1(@PathVariable int a, @PathVariable int b, Model model) {
        int res = a+b;
        model.addAttribute("msg", "结果为"+res);
        return "test";
    }
}
