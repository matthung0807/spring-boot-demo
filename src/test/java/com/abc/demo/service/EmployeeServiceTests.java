package com.abc.demo.service;

import com.abc.demo.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaSystemException;

@SpringBootTest
public class EmployeeServiceTests {

    @Autowired
    private EmployeeService employeeService;

    @Test
    public void alterId_throwJpaSystemException() {
        Assertions.assertThrows(JpaSystemException.class, () -> employeeService.alterId());
    }

    @Test
    public void alterIdByCreateNew_correct() {
        Employee employee = employeeService.alterIdByCreateNew();
        Assertions.assertEquals(2L, employee.getId());
    }

}
