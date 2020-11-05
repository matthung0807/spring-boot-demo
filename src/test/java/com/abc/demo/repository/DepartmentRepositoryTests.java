package com.abc.demo.repository;

import com.abc.demo.entity.Department;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
class DepartmentRepositoryTests {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Transactional
    @Test
    void findByIdJoinEmployee_correct() {
        Department department = departmentRepository.findByIdJoinEmployee(1L)
                .orElse(null);

        Assertions.assertNotNull(department);
        Assertions.assertEquals(2, department.getEmployeeList().size());
    }

    @Transactional
    @Test
    void findByEmployeeIdJoinEmployee_correct() {
        long departmentId = departmentRepository.findByEmployeeIdJoinEmployee(3L)
                .map(Department::getId)
                .orElse(0L);

        Assertions.assertEquals(2L, departmentId);
    }
}
