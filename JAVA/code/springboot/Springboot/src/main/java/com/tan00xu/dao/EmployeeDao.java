package com.tan00xu.dao;

import com.tan00xu.pojo.Department;
import com.tan00xu.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author TAN00XU
 * 员工Dao
 */
@Repository
public class EmployeeDao {
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employees = new HashMap<Integer, Employee>();

        employees.put(1001, new Employee(1001, "张三", "1001@1001.com", 1, new Department(101, "教学部")));
        employees.put(1002, new Employee(1002, "李四", "1002@1002.com", 0, new Department(102, "市场部")));
        employees.put(1003, new Employee(1003, "王五", "1003@1003.com", 1, new Department(103, "教研部")));
        employees.put(1004, new Employee(1004, "赵六", "1004@1004.com", 0, new Department(104, "运营部")));
        employees.put(1005, new Employee(1005, "王二", "1005@1005.com", 1, new Department(105, "后勤部")));
    }

    //主键自增
    private static Integer initId = 1006;
    /**
     * 增加员工
     */
    public void addEmployee(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);

    }
    /**
     * 查询所有员工
     */
    public Collection<Employee> listEmployees() {
        return employees.values();
    }

    /**
     * 根据id查询员工
     */
    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }
    /**
     * 删除员工
     */
    public void deleteEmployeeById(Integer id) {
        employees.remove(id);
    }





}
