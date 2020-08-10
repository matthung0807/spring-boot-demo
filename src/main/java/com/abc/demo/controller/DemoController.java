package com.abc.demo.controller;

import com.abc.demo.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/test")
    public Object test() {
        return employeeService.getAllEmployee();
    }

}
