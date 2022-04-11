package com.tan00xu.demo03;

public class Client {
    public static void main(String[] args) {
        Host host = new Host();
        ProxyInvocationHandler proxyInvocationHandler = new ProxyInvocationHandler();
        //通过调用程序处理角色来处理我们要调用的接口对象
        proxyInvocationHandler.setRent(host);

        Rent proxy = (Rent) proxyInvocationHandler.getProxy();
        proxy.rent();

    }
}
