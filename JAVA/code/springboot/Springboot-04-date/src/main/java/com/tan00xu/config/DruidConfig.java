package com.tan00xu.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DruidConfig {

    /**
      将自定义的 Druid数据源添加到容器中，不再让 Spring Boot 自动创建
      绑定全局配置文件中的 druid 数据源属性到 com.alibaba.druid.pool.DruidDataSource从而让它们生效
      注解@ConfigurationProperties(prefix = "spring.datasource")：作用就是将 全局配置文件中
      前缀为 spring.datasource的属性值注入到 com.alibaba.druid.pool.DruidDataSource 的同名参数中
    */
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druidDataSource() {
        return new DruidDataSource();
    }


    /**
     * 后台监控统计视图servlet
     * web.xml ServletRegistrationBean
     * 因为Springboot 内置了servlet容器，所以没有web.xml，替代方法ServletRegistrationBean
     *
     * @return {@link ServletRegistrationBean}
     */
    @Bean
    public ServletRegistrationBean StatViewServlet(){
        ServletRegistrationBean<StatViewServlet> statViewServletServletRegistrationBean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");
        //后台需要有人登录，账号密码配置
        HashMap<String,String> initParameters = new HashMap<>();
        //增加配置
        //登录key是固定的 loginUsername loginPassword
        initParameters.put("loginUsername","admin");
        initParameters.put("loginPassword","123123");

        //允许谁访问 参数为空所有人能访问,参数为localhost则本机能访问
        initParameters.put("allow","");

        //禁止谁能访问 initParameters.put("deny","192.168.137.1");

        //设置初始化参数
        statViewServletServletRegistrationBean.setInitParameters(initParameters);

        return statViewServletServletRegistrationBean;
    }


    /**
     * 过滤器
     *
     * @return {@link FilterRegistrationBean}
     */
    @Bean
    public FilterRegistrationBean webStatFilter() {
        FilterRegistrationBean<Filter> filterFilterRegistrationBean = new FilterRegistrationBean<>();
        filterFilterRegistrationBean.setFilter(new WebStatFilter());
        //过滤请求
        Map<String,String> initParameters = new HashMap<>();
        //这些不统计
        initParameters.put("exclusions", "*.js,*.css,/druid/*");
        filterFilterRegistrationBean.setInitParameters(initParameters);
        return filterFilterRegistrationBean;
    }
}
