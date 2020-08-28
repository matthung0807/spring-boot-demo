package com.abc.demo.service;

import com.abc.demo.entity.Employee;
import com.abc.demo.repository.DepartmentRepository;
import com.abc.demo.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import java.sql.SQLException;
import java.util.List;

@Log4j2
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    private final TransactionTemplate transactionTemplate;

    public DepartmentService(PlatformTransactionManager platformTransactionManager) {
        transactionTemplate = new TransactionTemplate(platformTransactionManager);
    }

//    @Transactional
    public void deleteDepartment(Long id) {
        List<Employee> employeeList = employeeRepository.findByDepartmentId(id);

        transactionTemplate.execute(new TransactionCallbackWithoutResult() {
            @Override
            protected void doInTransactionWithoutResult(TransactionStatus transactionStatus) {
                try {
                    employeeRepository.deleteInBatch(employeeList);
                    departmentRepository.deleteById(id);
                    if (id == 1L) {
                        throw new SQLException("Database transaction error!!");
                    }
                } catch (SQLException e) {
                    log.error(e.getMessage());
                    transactionStatus.setRollbackOnly();
                }
            }
        });
    }
}
