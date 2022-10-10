package com.tan00xu.authdemo.service;

import com.tan00xu.authdemo.domain.ResponseResult;
import com.tan00xu.authdemo.domain.User;

/**
 * @author 饮梦 TAN00XU
 * @date 2022/10/09 16:25
 */
public interface LoginService {
    ResponseResult login(User user);

    ResponseResult<?> logout();
}
