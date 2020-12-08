package com.abc.demo.service;

import com.abc.demo.entity.Employee;
import com.abc.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.OptimisticLockingFailureException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void updateName(long id, String name) {
        try {
             Employee employee = employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);
             employee.setName(name);
             employeeRepository.save(employee);
        } catch (OptimisticLockingFailureException e) {
            System.out.println("Optimistic locking occur");
        }
    }

}
