package com.abc.demo.service;

import com.abc.demo.entity.Employee;
import com.abc.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeServiceTests {

    @Autowired
    EmployeeService employeeService;

    @Autowired
    EmployeeRepository employeeRepository;

    @Test
    void addWithoutTryCatch_rollback() {

        try {
            employeeService.addWithoutTryCatch();
        } catch (Exception e) {
        }

        List<Employee> employeeList = employeeRepository.findAll();
        Assertions.assertEquals(0, employeeList.size());
    }

    @Test
    void addWithTryCatch_noRollback() {

        employeeService.addWithTryCatch();
        List<Employee> employeeList = employeeRepository.findAll();
        Assertions.assertEquals(1, employeeList.size());

    }
}
