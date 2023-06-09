package com.tan00xu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author TAN00XU
 * 员工类
 */
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String name;
    private String email;
    /**
     * 员工性别
     * 0:女，1:男
     */
    private Integer gender;

    private Department department;
    private Date birthday;

    public Employee(Integer id, String name, String email, Integer gender, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birthday = new Date();
    }
}
