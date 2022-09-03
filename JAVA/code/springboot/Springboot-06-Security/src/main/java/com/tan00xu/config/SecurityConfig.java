package com.tan00xu.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    /**
     * 授权
     *
     * @param http http
     * @throws Exception 异常
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //首页所有人可以访问，功能页只有对应有权限的人才能访问
        //请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");
        //没有权限默认会到登录页面
        http.formLogin()
                .loginPage("/toLogin")
                //用户名前端参数
//                .usernameParameter("user")
                //密码前端参数
//                .passwordParameter("pwd")
                //登录处理网址
//                .loginProcessingUrl("/login")
        ;

        //防跨站攻击 默认开启
        //关闭功能
        http.csrf().disable();
        //注销，跳到首页
        http.logout().logoutSuccessUrl("/");

        //开启记住我
        http.rememberMe()
                .rememberMeParameter("remember");
    }

    /**
     * 认证
     * 密码编码：PasswordEncoder
     *
     * @param auth 身份验证
     * @throws Exception 异常
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("123")
                .password(new BCryptPasswordEncoder().encode("123123"))
                .roles("vip1")

                .and()
                .withUser("tx")
                .password(new BCryptPasswordEncoder().encode("123123"))
                .roles("vip2", "vip3")

                .and()
                .withUser("root")
                .password(new BCryptPasswordEncoder().encode("123123"))
                .roles("vip1", "vip2", "vip3");
    }
}
