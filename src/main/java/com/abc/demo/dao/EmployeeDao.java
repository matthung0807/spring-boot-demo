package com.abc.demo.dao;

import com.abc.demo.entity.Employee;
import com.abc.demo.repository.EmployeeRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDao {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findByNameAndAgeGreaterThan(String name, Integer age) {

        Specification<Employee> spec = Specification.where(null);
        if (StringUtils.isNotEmpty(name)) {
            spec = spec.and(Employee.nameEquals(name));
        }
        if (age != null) {
            spec = spec.and(Employee.ageGreaterThan(age));
        }

        return employeeRepository.findAll(spec);
    }
}
