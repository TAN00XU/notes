package com.tan00xu.pojo;

import lombok.Data;

@Data
public class Student {

    private int id;
    private String name;
//    private int tid;
    private Teacher teacher;
}
