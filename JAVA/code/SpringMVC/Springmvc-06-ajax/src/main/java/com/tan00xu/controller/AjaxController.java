package com.tan00xu.controller;

import com.tan00xu.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String testAjax() {
        return "Hello Ajax";
    }

    @RequestMapping("/a1")
    public void testAjax2(String name, HttpServletResponse response) throws IOException {
        System.out.println("ajax2:name=> " + name);
        if("tx".equals(name)) {
            response.getWriter().print("true");
        }else {
            response.getWriter().print("false");
        }

    }

    @RequestMapping("/a2")
    public List<User> a2(){
        ArrayList<User> userList = new ArrayList<User>();
        userList.add(new User("java",2,"男"));
        userList.add(new User("tx",20,"男"));
        userList.add(new User("ym",20,"男"));

        return userList;
    }

    @RequestMapping("/a3")
    public String a3(String name,String pwd){
        System.out.println("后端："+name+"===="+pwd);
        String msg = "";
        if(name!=null){
            if("admin".equals(name)){
                msg = "ok";
            }else {
                msg = "用户名有误";
            }
            System.out.println("判断用户名："+msg);
        }
        if(pwd!=null){
            if("123123".equals(pwd)){
                msg = "ok";
            }else {
                msg = "密码有误";
            }
            System.out.println("判断密码："+msg);
        }

        return msg;
    }

}
