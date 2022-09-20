package com.tan00xu.entity;

import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.tan00xu.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 用户类
 *
 * @author TAN00XU
 * @date 2022/09/19
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
//@TableName("t_user")
public class User {
    /**
     * id
     */
    private Long id;
    /**
     * 名字
     */
    private String name;
    /**
     * 年龄
     */
    private Integer age;

    /**
     * 性别
     */
    private GenderEnum gender;

    /**
     * 电子邮件
     */
    private String email;

    /**
     * 是否被删除 逻辑删除字段 0为正常 1为被删除
     */
    @TableLogic
    private Integer isDeleted;


}
