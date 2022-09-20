package com.tan00xu.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * 性别枚举类
 *
 * @author TAN00XU
 * @date 2022/09/20
 */
@Getter
public enum GenderEnum {
    /**
     * 男性
     */
    MALE(1, "男"),
    /**
     * 女
     */
    FEMALE(0, "女");
    @EnumValue //将注解所标识的属性的值存储到数据库中
    private Integer gender;
    private String genderName;

    GenderEnum(Integer gender, String genderName) {
        this.gender = gender;
        this.genderName = genderName;
    }
}
