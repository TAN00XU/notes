package com.tan00xu.authdemo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tan00xu.authdemo.domain.Menu;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 菜单映射器类
 *
 * @author 饮梦 TAN00XU
 * @date 2022/10/10 15:57:52
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    /**
     * 通过用户id查询菜单
     *
     * @param userId 用户id
     * @return {@link List}<{@link String}>
     */
    List<String> selectPermsByUserId(Long userId);

}