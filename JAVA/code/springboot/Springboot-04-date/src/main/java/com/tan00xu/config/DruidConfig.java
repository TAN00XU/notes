package com.tan00xu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {


    @ConfigurationProperties(prefix = "druid")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }

    public ServletRegistrationBean a(){
        new ServletRegistrationBean<>(new StatViewServlet(),)
    }
}
