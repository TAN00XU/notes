package com.tan00xu.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * 员工表
 */
@Data
@NoArgsConstructor
public class Employee {
    private Integer id;
    private String lastname;
    private String email;
    private Integer gender;

    private Department department;
    private Date birthday;

    public Employee(Integer id, String lastname, String email, Integer gender, Department department) {
        this.id = id;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.department = department;
        this.birthday = new Date();
    }
}
