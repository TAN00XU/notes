package com.tan00xu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 观众类
 *
 * @author TAN00XU
 * @date 2022/09/09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Viewer implements Serializable {
    /**
     * 名字
     */
    private String name;

    /**
     * 年龄
     */
    private int age;

    /**
     * 性别
     */
    private String gender;

    /**
     * 电话
     */
    private long tel;

    /**
     * 密码
     */
    private String password;

    /**
     * 票
     */
    private ArrayList<Ticket> tickets;
}
