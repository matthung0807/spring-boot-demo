package com.abc.demo.service;

import com.abc.demo.entity.Employee;
import com.abc.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoServiceTests {

    @Autowired
    private DemoService demoService;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void modify_nameIsJohn() {

        demoService.modify();

        String name = employeeRepository.findById(1L)
                .map(Employee::getName).orElse("");

        Assertions.assertEquals("John", name); // pass
    }

}
