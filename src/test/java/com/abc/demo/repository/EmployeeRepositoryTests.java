package com.abc.demo.repository;

import com.abc.demo.entity.Employee;
import com.abc.demo.entity.enumeration.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void employeeStateConverter() {
        State state = employeeRepository.findById(1L)
                .map(Employee::getState).orElse(State.OTHERS);

        Assertions.assertEquals(State.NORMAL, state);
    }
}
