package com.abc.demo.controller;

import com.abc.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee/modify")
    public void modify() {
        employeeService.modify();
    }

}
