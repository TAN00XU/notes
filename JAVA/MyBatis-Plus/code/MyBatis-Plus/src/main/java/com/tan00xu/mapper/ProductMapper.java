package com.tan00xu.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.tan00xu.entity.Product;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author TAN00XU
 * @date 2022/09/20 18:51
 */
@Mapper
public interface ProductMapper extends BaseMapper<Product> {
}
