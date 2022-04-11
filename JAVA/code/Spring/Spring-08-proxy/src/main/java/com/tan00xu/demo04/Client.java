package com.tan00xu.demo04;

import com.tan00xu.demo02.UserService;
import com.tan00xu.demo02.UserServiceImpl;

public class Client {
    public static void main(String[] args) {
        //真实对象
        UserServiceImpl userService = new UserServiceImpl();

        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        //设置要代理的对象
        proxyInvocationHandler.setTarget(userService);
        //动态生成代理对象，注意要用接口强转，否则会报异常
        UserService proxy = (UserService) proxyInvocationHandler.getProxy();
        proxy.add();
    }
}
