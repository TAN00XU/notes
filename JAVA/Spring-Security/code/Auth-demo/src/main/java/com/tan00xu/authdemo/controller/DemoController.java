package com.tan00xu.authdemo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 饮梦 TAN00XU
 * @date 2022/09/29 19:50
 */
@RestController
@RequestMapping("demo")
public class DemoController {
    @GetMapping("hello")
    @PreAuthorize("hasAuthority('dev:code:pull')")
    public String hello() {
        return "hello world";
    }
}
