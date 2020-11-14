package com.abc.demo.service;

import com.abc.demo.entity.Employee;
import com.abc.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {

    @Autowired
    private EmployeeRepository employeeRepository;

    /** 無try-catch 會觸發@Transactional rollback */
    @Transactional
    public void addWithoutTryCatch() {
        employeeRepository.save(new Employee("John"));
        throw new RuntimeException("Save data error!");
    }

    /** 有try-catch 不會觸發@Transactional rollback*/
    @Transactional
    public void addWithTryCatch() {

        try {
            employeeRepository.save(new Employee("John"));
            throw new RuntimeException("Save data error!");
        } catch (Exception e) {
        }

    }

}
