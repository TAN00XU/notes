package com.tan00xu.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect // 声明一个切面
public class AnnotationPointCut {
    @Before("execution(* com.tan00xu.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("======方法执行前======");
    }

    @After("execution(* com.tan00xu.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("======方法执行后======");
    }

    //在环绕通知中，我们可以给定一个参数，可以获取到目标方法的参数值，也可以修改目标方法的参数值
    @Around("execution(* com.tan00xu.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("环绕前");
        //获取到调用的方法
        System.out.println("signature："+proceedingJoinPoint.getSignature());
        //执行方法
        Object proceed = proceedingJoinPoint.proceed();
        System.out.println("环绕后");
    }
}
