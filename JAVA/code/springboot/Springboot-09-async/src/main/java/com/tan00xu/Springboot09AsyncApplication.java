package com.tan00xu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync //开启异步功能
public class Springboot09AsyncApplication {

    public static void main(String[] args) {
        SpringApplication.run(Springboot09AsyncApplication.class, args);
    }

}
