package com.tan00xu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * 登录控制器
 *
 * @author TAN00XU
 */
@Controller
@RequestMapping("/user")
public class LoginController {
    /**
     * 登录
     *
     * @param username 用户名
     * @param password 密码
     * @param model    模型
     * @param session  会话
     * @return {@link String}
     */
    @RequestMapping("/login")
    public String login(
            @RequestParam("username") String username,
            @RequestParam("password") String password,
            Model model,
            HttpSession session) {
        //具体的业务逻辑
        if(StringUtils.hasText(username) && "123123".equals(password)) {
            //登录成功
            session.setAttribute("username",username);
            return "redirect:/main.html";
        }else {
            //登录失败
            model.addAttribute("msg", "用户名或密码错误");
            return "index";
        }
    }


    /**
     * 注销
     *
     * @param session 会话
     * @return {@link String}
     */
    @RequestMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/index.html";
    }
}
