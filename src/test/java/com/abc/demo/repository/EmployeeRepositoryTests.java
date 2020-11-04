package com.abc.demo.repository;

import com.abc.demo.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void findByName_returnNull() {
        Employee employee = employeeRepository.findByName("Jack");
        System.out.println(employee); // null

        Assertions.assertNull(employee);
    }

    @Test
    void findByName_returnOptionalIsEmpty() {
        Optional<Employee> employeeOptional = employeeRepository.findByNameJPQL("Jack");
        System.out.println(employeeOptional.isPresent()); // false

        Assertions.assertFalse(employeeOptional.isPresent());
    }

}
