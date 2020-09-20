package com.abc.demo.controller;

import com.abc.demo.service.DepartmentService;
import com.abc.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/employee/all")
    public Object getAllEmployee() {
        return employeeService.getAllEmployee();
    }

    @GetMapping("/department/all")
    public Object getAllDepartment() {
        return departmentService.getAllDepartment();
    }

}
