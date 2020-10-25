package com.abc.demo.repository;

import com.abc.demo.entity.Employee;
import com.abc.demo.entity.enumeration.State;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

@SpringBootTest
class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    /**
     * 測試資料表欄位值轉entity屬性值
     */
    @Test
    void testStateConverter_tableColumnToEntityAttribute() {
        State state = employeeRepository.findById(1L)
                .map(Employee::getState).orElse(State.OTHERS);

        Assertions.assertEquals(State.NORMAL, state);
    }

    /**
     * 測試entity屬性值轉資料表欄位值
     */
    @Test
    void testStateConverter_entityAttributeToTableColumn() {
        Employee employee = Employee.builder()
                .name("Mike")
                .state(State.LEAVE)
                .build();

        State state = Optional.of(employeeRepository.save(employee))
                .map(Employee::getState).orElse(State.OTHERS);

        Assertions.assertEquals(State.LEAVE, state);
    }

}
