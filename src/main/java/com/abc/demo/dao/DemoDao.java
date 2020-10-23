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

    /** 新增 */
    @Transactional
    public void insert(String name) {
        Employee employee = Employee.builder()
                .name(name)
                .build();
        employeeRepository.save(employee);
    }

    /** 修改1 */
    @Transactional
    public void update1(long id, String name) {
        employeeRepository.findById(id).ifPresent(e -> {
            e.setName(name);
            employeeRepository.save(e);
        });
    }

    /** 修改2 */
    @Transactional(propagation = Propagation.REQUIRES_NEW) // 另外產生新的交易，所以丟出例外時僅此方法的異動回滾
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
