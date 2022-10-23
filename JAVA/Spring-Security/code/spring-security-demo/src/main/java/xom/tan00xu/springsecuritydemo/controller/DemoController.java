package xom.tan00xu.springsecuritydemo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 饮梦 TAN00XU
 * @date 2022/09/29 16:39
 */
@RestController
@RequestMapping("demo")
public class DemoController {
    @GetMapping("hello")
    public String hello() {
        System.out.println("\n\n\n=====================\n\n\n"
                + SecurityContextHolder.getContext()
                + "\n\n\n=====================\n\n\n");
        return "hello spring security";
    }
}
