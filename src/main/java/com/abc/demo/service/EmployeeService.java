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
            System.out.println(Thread.currentThread().getName() + " update begin");

            Employee employee = employeeRepository.findById(id)
                    .orElseThrow(EntityNotFoundException::new);
            employee.setName(name);
            employeeRepository.save(employee);

            System.out.println(Thread.currentThread().getName() + " update success");
        } catch (OptimisticLockingFailureException e) {
            System.out.println("Optimistic locking occur");
            e.printStackTrace();
        }
    }

    public void updateNameUntilSuccess(long id, String name) {
        boolean success = false;
        int count = 0; // max re-try count

        while (!success) {
            try {
                System.out.println(Thread.currentThread().getName() + " update begin");

                Employee employee = employeeRepository.findById(id)
                        .orElseThrow(EntityNotFoundException::new);
                employee.setName(name);
                employeeRepository.save(employee);

                System.out.println(Thread.currentThread().getName() + " update success");
                success = true;
            } catch (OptimisticLockingFailureException e) {
                count++;
                if (count > 3) {
                    throw e;
                }
                System.out.println("Optimistic locking occur");
                try {
                    Thread.sleep(1000L); // wait 1 seconds
                } catch (InterruptedException interruptedException) {
                    System.out.println("Thread interrupted");
                }
            }
        }
    }

}
