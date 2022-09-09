package com.tan00xu.controller;

import com.tan00xu.service.AsyncService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 异步控制器类
 *
 * @author TAN00XU
 * @date 2022/09/07
 */
@RestController
public class AsyncController {
    @Autowired
    private AsyncService asyncService;

    @Async //告诉Spring这是一个异步方法
    @RequestMapping("/hello")
    public String hello() {
        asyncService.hello();
        return "ok";
    }

}
