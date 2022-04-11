package com.tan00xu.dao;

import com.tan00xu.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    /**
     * 查询全部用户
     * @return
     */
    @Select("select * from mybatis.user")
    public List<User> listUsers();

    //方法存在多个参数，所有的参数前面必须加上@Param()注解
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id, account, password) values (#{id},#{account},#{password})")
    int insertUser(User user);

    @Update("update user set account=#{account},password=#{password} where id=#{id}")
    int updateUser(User user);

    @Delete("delete from user where id=#{id}")
    int deleteUser(int id);
}
