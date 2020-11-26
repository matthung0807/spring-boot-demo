package com.abc.demo.service;

import com.abc.demo.entity.Employee;
import com.abc.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeServiceTests {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void queryAndUpdateName_successUpdate() {
        String name = "Joe";

        System.out.println(employeeRepository.findById(1L).map(Employee::getName).orElse("")); // John

        employeeService.queryAndUpdateName(name);
        String updatedName = employeeRepository.findById(1L)
                .map(Employee::getName)
                .orElse("");

        System.out.println(updatedName); // Joe

        Assertions.assertEquals(name, updatedName);
    }

}
