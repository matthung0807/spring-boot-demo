package com.abc.demo.dao;

import com.abc.demo.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeDaoTests {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    void findById_test() {
        Employee employee = employeeDao.findById(1);
        System.out.println(employee); // Employee(id=1, name=John, age=22)

        Assertions.assertEquals("John", employee.getName());
    }

}
