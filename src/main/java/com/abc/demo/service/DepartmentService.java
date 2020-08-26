package com.abc.demo.service;

import com.abc.demo.entity.Employee;
import com.abc.demo.repository.DepartmentRepository;
import com.abc.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public boolean deleteDepartment(Long id) {
        List<Employee> employeeList = employeeRepository.findByDepartmentId(id);
        employeeRepository.deleteInBatch(employeeList);
        departmentRepository.deleteById(id);
        return true;
    }
}
