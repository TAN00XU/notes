package com.tan00xu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

}
