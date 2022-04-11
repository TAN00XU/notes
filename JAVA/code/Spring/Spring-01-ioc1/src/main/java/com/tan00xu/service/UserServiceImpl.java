package com.tan00xu.service;

import com.tan00xu.dao.UserDao;
import com.tan00xu.dao.UserDaoImpl;

public class UserServiceImpl implements UserService{

    private UserDao userDao;
    /**
     * 利用set进行动态实现值的注入
     */
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void getUser() {
        userDao.getUser();
    }
}
