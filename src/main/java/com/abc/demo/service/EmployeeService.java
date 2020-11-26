package com.abc.demo.service;

import com.abc.demo.entity.Employee;
import com.abc.demo.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public Employee alterId() {
        Employee employee = employeeRepository.findById(1L).orElse(null);
        if (employee != null) {
            employee.setId(2L);
            return employeeRepository.save(employee); // 拋錯
        }
        return null;
    }

    @Transactional
    public Employee alterIdByCreateNew() {
        Employee employee = employeeRepository.findById(1L).orElse(null);
        if (employee != null) {
            Employee employeeNew = new Employee();
            BeanUtils.copyProperties(employee, employeeNew);
            employeeNew.setId(2L);

            employeeRepository.delete(employee);
            return employeeRepository.save(employeeNew);
        }
        return null;
    }

}
