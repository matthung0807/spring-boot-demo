package com.abc.demo.service;

import com.abc.demo.entity.Employee;
import com.abc.demo.repository.EmployeeRepository;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;

@Service
public class EmployeeService {

    @Value("classpath:static/user_icon.png")
    private Resource resource;

    @Autowired
    private EmployeeRepository employeeRepository;

    @PostConstruct
    void addPhoto() throws IOException {
        byte[] photo = IOUtils.toByteArray(resource.getInputStream());
        List<Employee> employeeList = employeeRepository.findAll();

        for(Employee employee : employeeList) {
            employee.setPhoto(photo);
        }

        employeeRepository.saveAll(employeeList);
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

}
