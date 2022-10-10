package com.tan00xu.authdemo.service.impl;

import com.tan00xu.authdemo.domain.LoginUser;
import com.tan00xu.authdemo.domain.ResponseResult;
import com.tan00xu.authdemo.domain.User;
import com.tan00xu.authdemo.service.LoginService;
import com.tan00xu.authdemo.utils.JwtUtil;
import com.tan00xu.authdemo.utils.RedisCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author 饮梦 TAN00XU
 * @date 2022/10/09 16:29
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    RedisCache redisCache;

    @Override
    public ResponseResult login(User user) {
        //3使用ProviderManager auth方法进行验证
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken
                = new UsernamePasswordAuthenticationToken(user.getUserName(), user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //校验失败了
        if (Objects.isNull(authenticate)) {
            throw new RuntimeException("用户名或密码错误！");
        }

        //4自己生成jwt给前端
        LoginUser loginUser = (LoginUser) (authenticate.getPrincipal());
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtil.createJWT(userId);

        Map<String, String> map = new HashMap();
        map.put("token", jwt);
//        //5系统用户相关所有信息放入redis
        redisCache.setCacheObject("login:" + userId, loginUser);

        return new ResponseResult(200, "登陆成功", map);
    }

    @Override
    public ResponseResult<?> logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long id = loginUser.getUser().getId();
        redisCache.deleteObject("login:" + id);
        return new ResponseResult<>(200, "退出成功");
    }
}
