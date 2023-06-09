package com.tan00xu.dao;

import com.tan00xu.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TAN00XU
 * 部门Dao
 */
@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101,new Department(101,"教学部"));
        departments.put(102,new Department(102,"市场部"));
        departments.put(103,new Department(103,"教研部"));
        departments.put(104,new Department(104,"运营部"));
        departments.put(105,new Department(105,"后勤部"));

    }

    /**
     * 获取所有部门信息
     */
    public  Collection<Department> listDepartment() {
        return departments.values();
    }
    /**
     * 根据id获取部门信息
     */
    public Department getDepartmentById(Integer id) {
        return departments.get(id);
    }

}
