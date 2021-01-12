package com.abc.demo.service;

import com.abc.demo.entity.Department;
import com.abc.demo.entity.Employee;
import com.abc.demo.repository.DepartmentRepository;
import com.abc.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@SpringBootTest
public class DepartmentServiceTests {

    @Autowired
    private DepartmentService departmentService;
    @Autowired
    private DepartmentRepository departmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void deleteDepartment_rollback() {
        long id = 1;
        departmentService.deleteDepartment(id);

        Department department = departmentRepository.findById(id).orElse(null);
        List<Employee> employeeList = employeeRepository.findAll();
        System.out.println(department); // Department(id=1, name=Marketing)
        System.out.println(employeeList); // [Employee(id=1, departmentId=1, name=John, age=22), Employee(id=2, departmentId=1, name=Mary, age=25), Employee(id=3, departmentId=2, name=Andy, age=33)]

        Assertions.assertAll(() -> {
            Assertions.assertNotNull(department);
            Assertions.assertEquals("Marketing", department.getName());
            Assertions.assertEquals(3, employeeList.size());
        });

    }

}
