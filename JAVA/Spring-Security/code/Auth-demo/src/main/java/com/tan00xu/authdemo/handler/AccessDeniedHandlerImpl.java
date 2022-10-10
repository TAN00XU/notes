package com.tan00xu.authdemo.handler;

import com.alibaba.fastjson.JSON;
import com.tan00xu.authdemo.domain.ResponseResult;
import com.tan00xu.authdemo.utils.WebUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 授权失败
 * 访问被拒绝
 *
 * @author 饮梦 TAN00XU
 * @date 2022/10/10 16:32
 */
@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException, ServletException {
        ResponseResult responseResult = new ResponseResult<>(HttpStatus.FORBIDDEN.value(), "权限不足");
        String jsonObject = JSON.toJSONString(responseResult);
        WebUtils.renderString(response, jsonObject);


    }
}
