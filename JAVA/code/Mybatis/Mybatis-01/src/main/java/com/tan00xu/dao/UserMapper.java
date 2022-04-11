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

    /**
     * 根据id查询
     * @param id
     * @return User
     */
    User getUserById(int id);

    /**
     * 插入一个用户
     * @param user
     * @return
     */
    int insertUser(User user);
    //map传参
    int insertUser2(Map<String,Object> map);


    /**
     * 修改用户
     * @param user
     * @return
     */
    int updateUser(User user);

    /**
     * 删除一个用户
     * @param id
     * @return
     */
    int deleteUser(int id);
}
