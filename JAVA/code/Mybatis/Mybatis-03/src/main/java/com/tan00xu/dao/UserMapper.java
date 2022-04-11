package com.tan00xu.dao;

import com.tan00xu.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 查询全部用户
     * @return
     */
    public List<User> listUsers();

    //分页
    List<User> listUsersByLimit(Map<String,Integer> map);
    //分页
    List<User> listUsersByRowBounds(Map<String,Integer> map);

}
