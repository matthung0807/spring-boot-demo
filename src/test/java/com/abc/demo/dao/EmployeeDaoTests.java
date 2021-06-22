package com.abc.demo.dao;

import com.abc.demo.entity.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class EmployeeDaoTests {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void findByNameAndAgeGreaterThan_nameIsEmptyAndAgeIsNull() {
        List<Employee> employeeList = employeeDao.findByNameAndAgeGreaterThan("", null);
        Assertions.assertEquals(3, employeeList.size());
    }

    @Test
    public void findByNameAndAgeGreaterThan_nameIsEmpty() {
        List<Employee> employeeList = employeeDao.findByNameAndAgeGreaterThan("", 30);
        Assertions.assertEquals(1, employeeList.size());
    }

    @Test
    public void findByNameAndAgeGreaterThan_ageIsNull() {
        List<Employee> employeeList = employeeDao.findByNameAndAgeGreaterThan("John", null);
        Assertions.assertEquals(1, employeeList.size());
    }

    @Test
    public void findByNameAndAgeGreaterThan_nameNotEmptyAndAgeNotNull() {
        List<Employee> employeeList = employeeDao.findByNameAndAgeGreaterThan("Andy", 20);
        Assertions.assertEquals(1, employeeList.size());
    }
}
