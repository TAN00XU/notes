package com.tan00xu.log;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class Log implements MethodBeforeAdvice, AfterReturningAdvice {
    @Override
    /**
     * method：要执行的目标方法
     * args：目标对象的方法的参数
     * target：方法调用的目标对象。可能为null。
     */
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println(target.getClass().getName()+"的"+method.getName()+"方法开始执行");

    }
    @Override
    public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
        System.out.println("执行了" + method.getName() + "方法；" + "返回值为：" + returnValue);
    }


}
