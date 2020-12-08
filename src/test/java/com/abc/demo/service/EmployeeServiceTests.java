package com.abc.demo.service;

import com.abc.demo.entity.Employee;
import com.abc.demo.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityNotFoundException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class EmployeeServiceTests {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    void updateName_accumulateVersion() {
        long id = 1L;

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("John");
        employeeRepository.save(employee);

        String newName = "Luke";
        employeeService.updateName(id, newName);

        employee = employeeRepository.findById(id).orElseThrow(EntityNotFoundException::new);

        Assertions.assertEquals(newName, employee.getName());
        Assertions.assertEquals(1L, employee.getVersion());

    }

    @Test
    void updateName_concurrentUpdateOptimisticLocking() throws InterruptedException {
        long id = 1L;

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("John");
        employeeRepository.save(employee);

        final ExecutorService executorService = Executors.newFixedThreadPool(2); // create 2 threads in thread pool

        // transaction 1
        executorService.execute(() -> employeeService.updateName(id, "Luke"));
        // transaction 2
        executorService.execute(() -> employeeService.updateName(id, "Leon"));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        Employee result = employeeRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Assertions.assertEquals(1L, result.getVersion());

    }

    @Test
    void updateNameUntilSuccess_success() throws InterruptedException {
        long id = 1L;

        Employee employee = new Employee();
        employee.setId(id);
        employee.setName("John");
        employeeRepository.save(employee);

        final ExecutorService executorService = Executors.newFixedThreadPool(2); // create 2 threads in thread pool

        // transaction 1
        executorService.execute(() -> employeeService.updateNameUntilSuccess(id, "Luke"));
        // transaction 2
        executorService.execute(() -> employeeService.updateNameUntilSuccess(id, "Leon"));

        executorService.shutdown();
        executorService.awaitTermination(1, TimeUnit.MINUTES);

        Employee result = employeeRepository.findById(1L)
                .orElseThrow(EntityNotFoundException::new);

        Assertions.assertEquals(2L, result.getVersion());

    }

}
