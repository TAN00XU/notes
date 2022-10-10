package com.tan00xu.authdemo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.tan00xu.authdemo.dao.MenuMapper;
import com.tan00xu.authdemo.dao.UserDao;
import com.tan00xu.authdemo.domain.LoginUser;
import com.tan00xu.authdemo.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * @author 饮梦 TAN00XU
 * @date 2022/10/09 12:00
 */
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserDao userDao;

    @Autowired
    MenuMapper menuMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 1 根据用户名获取数据库中的系统用户
        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.eq(User::getUserName, username);
        User user = userDao.selectOne(userLambdaQueryWrapper);
        if (Objects.isNull(user)) {
            throw new RuntimeException("用户名错误");
        }
        //查询权限信息
//        List<String> arrayList = new ArrayList<>(Arrays.asList("test", "admin"));

        List<String> permissions = menuMapper.selectPermsByUserId(user.getId());

        return new LoginUser(user, permissions);
    }
}
