package com.tan00xu.dao;

import com.tan00xu.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    User selectUserById(@Param("id") int id);
}
