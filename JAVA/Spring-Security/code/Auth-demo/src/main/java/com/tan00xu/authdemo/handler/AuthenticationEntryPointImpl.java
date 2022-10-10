package com.tan00xu.authdemo.handler;

import com.alibaba.fastjson.JSON;
import com.tan00xu.authdemo.domain.ResponseResult;
import com.tan00xu.authdemo.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 认证失败
 * 身份验证条目点实现类
 *
 * @author 饮梦 TAN00XU
 * @date 2022/10/10 16:24:38
 */
@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException, ServletException {
        ResponseResult responseResult = new ResponseResult<>(HttpStatus.UNAUTHORIZED.value(), "登录验证失败，请重新登陆");
        String jsonObject = JSON.toJSONString(responseResult);
        WebUtils.renderString(response, jsonObject);

    }
}
