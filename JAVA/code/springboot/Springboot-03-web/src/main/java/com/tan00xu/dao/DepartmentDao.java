package com.tan00xu.dao;

import com.tan00xu.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 部门dao
 */
@Repository
public class DepartmentDao {
    private static Map<Integer, Department> departmentMap = null;
    static {
        departmentMap=new HashMap<Integer, Department>();
        departmentMap.put(101,new Department(101,"教学部"));
        departmentMap.put(102,new Department(102,"市场部"));
        departmentMap.put(103,new Department(103,"教研部"));
        departmentMap.put(104,new Department(104,"运营部"));
        departmentMap.put(105,new Department(105,"后勤部"));
    }

    /**
     * 获得所有部门信息
     */
    public Collection<Department> ListDepartments(){
        return departmentMap.values();
    }

    /**
     * 通过id得到部门
     */
    public Department getDepartmentById(Integer id) {
        return departmentMap.get(id);
    }
}
