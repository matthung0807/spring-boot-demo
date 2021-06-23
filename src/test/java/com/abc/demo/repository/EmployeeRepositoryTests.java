package com.abc.demo.repository;

import com.abc.demo.entity.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void test() {
        // insert
        Employee employee = new Employee(4, "Jack", 26);
        employee = employeeRepository.save(employee);

        // update
        employee.setName("Jackson");
        employeeRepository.save(employee);

        // delete
        employeeRepository.delete(employee);

    }

}
