package com.abc.demo.repository;

import com.abc.demo.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    @Test
    void findByDepartmentIdJoinDepartment_correct() {
        List<Employee> employeeList = employeeRepository.findByDepartmentIdJoinDepartment(1L);
        Assertions.assertEquals(2, employeeList.size());

        String departmentName = employeeList.stream().findFirst()
                .map(e -> e.getDepartment().getName())
                .orElse("");

        Assertions.assertEquals("Marketing", departmentName);
    }

    @Transactional
    @Test
    void findByAgeLessThanLeftJoinDepartment_correct() {
        List<Employee> employeeList = employeeRepository.findByAgeLessThanLeftJoinDepartment(30);
        Assertions.assertEquals(2, employeeList.size());
    }
}
