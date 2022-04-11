package com.tan00xu.demo04;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyInvocationHandler implements InvocationHandler {

    // 被代理对象
    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    // 创建代理对象
    public Object getProxy() {
        return Proxy.newProxyInstance(
                this.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this
        );
    }

    @Override
    // 调用被代理对象的方法，并返回结果
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        log(method.getName());
        return method.invoke(target, args);
    }

    public void log(String msg) {
        System.out.println("执行了" + msg + "方法");

    }

}

