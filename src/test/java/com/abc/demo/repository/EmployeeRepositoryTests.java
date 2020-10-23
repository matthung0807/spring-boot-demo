package com.abc.demo.repository;

import com.abc.demo.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

@SpringBootTest
class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void printJpaSqlParameters() {
        Employee employee = Employee.builder().name("John")
                .email("john@abc.com")
                .age(29)
                .createDate(new Date())
                .build();

        employee = employeeRepository.save(employee);

        Assertions.assertEquals(employee.getName(), "John");
    }
}
