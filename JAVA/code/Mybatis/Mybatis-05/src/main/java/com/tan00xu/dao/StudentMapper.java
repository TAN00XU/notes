package com.tan00xu.dao;

import com.tan00xu.pojo.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface StudentMapper {


    List<Student> listStudents();
}
