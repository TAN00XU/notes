package com.tan00xu.mapper;

import java.util.Collection;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tan00xu.entity.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author TAN00XU
 * @date 2022/09/19 23:37
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据id查询用户信息为map集合
     *
     * @param id id
     * @return {@link Map}<{@link String}, {@link Object}>
     */
    Map<String, Object> selectMapById(Long id);

    /**
     * 通过年龄查询用户信息并分页
     *
     * @param page MyBatis-Plus所提供的分页对象，必须位于第一个参数的位置
     * @param age  年龄
     * @return {@link Page}<{@link User}>
     */
    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);

}
