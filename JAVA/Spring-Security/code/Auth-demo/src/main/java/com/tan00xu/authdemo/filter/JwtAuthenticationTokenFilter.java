package com.tan00xu.authdemo.filter;

import com.tan00xu.authdemo.domain.LoginUser;
import com.tan00xu.authdemo.utils.CmdOutputInformationUtils;
import com.tan00xu.authdemo.utils.JwtUtil;
import com.tan00xu.authdemo.utils.RedisCache;
import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * jwt身份验证令牌过滤器类
 * OncePerRequestFilter 只走一次，请求前
 *
 * @author 饮梦 TAN00XU
 * @date 2022/10/10 11:07:38
 */
@Component
public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {

    @Autowired
    RedisCache redisCache;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        //1 获取token
        String token = request.getHeader("token");
        if (!StringUtils.hasText(token)) {
            //放行，让后面的过滤器报错
            filterChain.doFilter(request, response);
            return;
        }
        //2 解析token
        String userId;
        try {
            Claims claims = JwtUtil.parseJWT(token);
            userId = claims.getSubject();
        } catch (Exception e) {
            throw new RuntimeException("token不合法！");
        }
        //3 获取userId redis获取用户信息
        LoginUser loginUser = redisCache.getCacheObject("login:" + userId);
        if (Objects.isNull(loginUser)) {
            throw new RuntimeException("当前用户未登录！");
        }

        //4 封装Authentication
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(loginUser, null, loginUser.getAuthorities());

        //5 存入SecurityContextHolder
        SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        //放行
        filterChain.doFilter(request, response);
    }
}
