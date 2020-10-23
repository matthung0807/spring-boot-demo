package com.abc.demo.dao;

import com.abc.demo.entity.Employee;
import com.abc.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class DemoDao {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void insert(String name) {
        Employee employee = Employee.builder()
                .name(name)
                .build();
        employeeRepository.save(employee);
    }

    public void update1(long id, String name) {
        employeeRepository.findById(id).ifPresent(e -> {
            e.setName(name);
            employeeRepository.save(e);
        });
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void update2(long id, String name) {
        try {
            employeeRepository.findById(id).ifPresent(e -> {
                e.setName(name);
                employeeRepository.save(e);
            });
            throw new RuntimeException("Database error.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
