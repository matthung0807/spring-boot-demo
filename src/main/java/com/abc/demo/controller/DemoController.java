package com.abc.demo.controller;

import com.abc.demo.entity.Employee;
import com.abc.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DemoController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employee/all")
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

}
