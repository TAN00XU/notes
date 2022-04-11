package com.tan00xu.config;

import com.tan00xu.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

//@Configuration,这个也会Spring容器托管,注册到容器中,因为他本来就是一个@Component
//@Configuration该注解代表了这是一个配置类，与applicationContext.xml一样
@Configuration
@ComponentScan("com.tan00xu.pojo")
@Import(JavaConfig.class)
public class JavaConfig {

    /**
    *注册一个Bean，就相当于我们之前写的一个bean标签
    *方法名字 == bean标签的id
    *方法的返回值 == bean标签中的class属性
    */
    @Bean
    public User getUser(){
        return new User();//返回要注入的bean对象
    }
}
