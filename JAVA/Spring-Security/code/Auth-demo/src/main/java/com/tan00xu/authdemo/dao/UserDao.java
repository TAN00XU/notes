package com.tan00xu.authdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tan00xu.authdemo.domain.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author 饮梦 TAN00XU
 * @date 2022/10/09 11:33
 */
@Mapper
public interface UserDao extends BaseMapper<User> {
}
