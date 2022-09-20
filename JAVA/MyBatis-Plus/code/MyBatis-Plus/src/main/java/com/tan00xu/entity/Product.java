package com.tan00xu.entity;

import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * 产品类
 * <p>
 * 类
 *
 * @author TAN00XU
 * @date 2022/09/20
 */
@Data
public class Product {
    /**
     * id
     */
    private Long id;
    /**
     * 名字
     */
    private String name;
    /**
     * 价格
     */
    private Integer price;
    /**
     * 版本
     */
    @Version //标识乐观锁版本号字段
    private Integer version;
}