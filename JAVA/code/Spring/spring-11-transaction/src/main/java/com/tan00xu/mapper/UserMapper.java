package com.tan00xu.mapper;

import com.tan00xu.pojo.User;

import java.util.List;

public interface UserMapper {
     List<User> listUsers();

     //添加用户
     int addUser(User user);

     //删除用户
     int deleteUser(int id);
}
