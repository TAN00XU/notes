package com.tan00xu.controller;

import com.tan00xu.dao.DepartmentDao;
import com.tan00xu.dao.EmployeeDao;
import com.tan00xu.pojo.Department;
import com.tan00xu.pojo.Employee;
import com.tan00xu.utils.CmdOutputInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/empList")
    public String listEmployee(Model model) {
        model.addAttribute("employees", employeeDao.listEmployees());
        return "/emp/empList";
    }

    @GetMapping("/addEmployee")
    public String toAddEmployee(Model model) {
        //获取所有部门信息
        Collection<Department> departments = departmentDao.listDepartment();
        model.addAttribute("departments", departments);
        return "/emp/empAdd";
    }
    @PostMapping("/addEmployee")
    public String addEmployee(Employee employee) {
        new CmdOutputInformation().debug("过=======");
        employeeDao.addEmployee(employee);
        return "redirect:/emp/empList";
    }


    /**
     * 修改员工
     */
    @GetMapping("/editEmployee/{id}")
    public String toUpdateEmployee(@PathVariable("id") Integer id, Model model) {
        
        return "emp/EmpUpdate";
    }


}
