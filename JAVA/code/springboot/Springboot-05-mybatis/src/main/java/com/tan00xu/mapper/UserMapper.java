package com.tan00xu.mapper;

import com.tan00xu.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface UserMapper {

    /**
     * 列出所有用户
     *
     * @return {@link List}<{@link User}>
     */
    List<User> listAllUser();

    /**
     * 根据id得到用户信息
     *
     * @param id id
     * @return {@link User}
     */
    User getUserById(int id);

    /**
     * 添加用户
     *
     * @param user 用户
     * @return int
     */
    int addUser(User user);

    /**
     * 更新用户
     *
     * @param user 用户
     * @return int
     */
    int updateUser(User user);

    /**
     * 通过id删除用户
     *
     * @param id id
     * @return int
     */
    int deleteUserById(int id);

}
