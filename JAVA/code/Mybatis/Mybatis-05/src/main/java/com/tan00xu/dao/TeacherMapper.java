package com.tan00xu.dao;

import com.tan00xu.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> lisTeachers();

    //获取指定老师下的所有学生及老师的信息
    Teacher getTeacher(@Param("tid") int id);

}
