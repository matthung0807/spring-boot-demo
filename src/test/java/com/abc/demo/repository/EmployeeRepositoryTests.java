package com.abc.demo.repository;

import com.abc.demo.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;

@SpringBootTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void findById_test() {
        Employee employee = employeeRepository.findById(1L).orElseThrow(EntityNotFoundException::new);
        System.out.println(employee); // Employee(id=1, name=John, age=22)

        Assertions.assertEquals("John", employee.getName());
    }

}
