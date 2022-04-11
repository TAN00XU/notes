package com.tan00xu.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//等价于<bean id="user" class="com.tan00xu.pojo.User"/>
//组件
@Component
public class User {
    @Value("饮梦")
    public String name;
}
