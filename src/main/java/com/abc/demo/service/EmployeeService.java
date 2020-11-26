package com.abc.demo.service;

import com.abc.demo.entity.Employee;
import com.abc.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void queryAndUpdateName(String name) {
        Employee employee = employeeRepository.findById(1L).orElse(null);
        if (employee != null) {
            employee.setName(name);
        }
    }

}
