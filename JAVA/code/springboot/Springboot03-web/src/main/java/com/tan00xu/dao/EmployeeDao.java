package com.tan00xu.dao;

import com.tan00xu.pojo.Department;
import com.tan00xu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 员工dao
 */
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employeeMap = null;

    /**
     * 员工有所属部门
     */
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employeeMap=new HashMap<Integer, Employee>();
        employeeMap.put(101,new Employee(1001,"AA","A666@66.com",0,new Department(101,"教学部")));
        employeeMap.put(102,new Employee(1002,"BB","B666@66.com",1,new Department(102,"市场部")));
        employeeMap.put(103,new Employee(1003,"CC","C666@66.com",0,new Department(103,"教研部")));
        employeeMap.put(104,new Employee(1004,"DD","D666@66.com",1,new Department(104,"运营部")));
        employeeMap.put(105,new Employee(1005,"EE","E666@66.com",0,new Department(105,"后勤部")));
    }

    /**
     * 主键自增
     */
    private static Integer initId=1006;

    /**
     * 增加员工
     */
    public void save(Employee employee){
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(), employee);
    }

    /**
     * 查询全部员工
     */
    public Collection<Employee> listAll(){
        return employeeMap.values();
    }

    /**
     * 通过id查询员工
     */
    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }

    /**
     * 通过id删除员工
     */
    public void deleteById(Integer id) {
        employeeMap.remove(id);
    }

}
