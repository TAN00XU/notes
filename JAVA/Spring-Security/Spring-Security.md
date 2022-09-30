>  [SpringSecurity | 文档合集 (ydlclass.com)](https://www.ydlclass.com/doc21xnv/frame/springsecurity/#课程概述)

# 一、第一章 简介

> https://spring.io/projects/spring-security#overview

## 1、 概念

​	Spring家族当中，一个安全管理框架。

​	Shiro也是一个安全框架，提供了很多安全功能。Shiro比较老，旧的项目当中，可能还在使用。上手还挺简单。

​	在新项目当中，一线互联网大型项目，都是使用SpringSecurity 

## 2、认证 鉴权

一般的web项目当中，总会有登陆和鉴权的需求。但是大家一定要区分开。

- **认证**：验证当前访问的用户是不是本系统中的用户。确定是哪一个具体的用户。
- **鉴权**：经过认证，判断当前登陆用户有没有权限来执行某个操作。

所以说，安全框架SpringSecurity 当中，必定会有认证和鉴权的两大核心功能。



# 二、入门

## 1、准备web项目

### [#](https://www.ydlclass.com/doc21xnv/frame/springsecurity/#_1-创建springboot-web项目)（1）创建springboot web项目

```xml
  <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>

        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
    </dependencies>
```

创建controller

```java
@RestController
@RequestMapping("demo")
public class DemoController {
    @GetMapping("hello")
    public String hello() {
        return "hello spring security";
    }
}
```



## 2、引入SpringSecurity

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-security</artifactId>
</dependency>
```



### Security 自带的登陆页面

http://localhost:8080/login

![](https://www.ydlclass.com/doc21xnv/assets/image-20220820161941164.cbb43a81.png)

### 自带退出

http://localhost:8080/logout

![](https://www.ydlclass.com/doc21xnv/assets/image-20220820162224080.61bbcd0e.png)



# 