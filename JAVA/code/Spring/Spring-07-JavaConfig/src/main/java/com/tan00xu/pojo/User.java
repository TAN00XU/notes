package com.tan00xu.pojo;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component//类被Spring接管，注册到了容器中
public class User {
    private String name;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    @Value("饮梦")//属性注入值
    public void setName(String name) {
        this.name = name;
    }
}
