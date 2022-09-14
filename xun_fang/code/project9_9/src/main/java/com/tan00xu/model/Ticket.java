package com.tan00xu.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 票类
 *
 * @author TAN00XU
 * @date 2022/09/09
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Ticket implements Serializable {

    //    3.票(Ticket)的封装 ：所属区域、排、号、价格、是否被预订(构造时均为false，被预订成功后该属性变为true),预订者的手机号
    /**
     * 区域
     */
    private String area;

    /**
     * 排
     */
    private int row;

    /**
     * 号
     */
    private int number;

    /**
     * 价格
     */
    private int price;


    /**
     * 是否被预定
     */
    private boolean reserve;

    /**
     * 电话
     */
    private long tel;


}
