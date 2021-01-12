package com.abc.demo.service;

import com.abc.demo.entity.Employee;
import com.abc.demo.repository.DepartmentRepository;
import com.abc.demo.repository.EmployeeRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import java.sql.SQLException;
import java.util.List;

@Log4j2
@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private PlatformTransactionManager platformTransactionManager;

    public void deleteDepartment(long id) {
        List<Employee> employeeList = employeeRepository.findByDepartmentId(id);


        TransactionDefinition transactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus transactionStatus = platformTransactionManager.getTransaction(transactionDefinition);
        try {
            employeeRepository.deleteInBatch(employeeList); // 刪除部門所屬員工資料
            departmentRepository.deleteById(id); // 刪除部門資料
            if (id == 1L) {
                throw new SQLException("Database transaction error!!"); // 模擬交易發生錯誤
            }
            platformTransactionManager.commit(transactionStatus); // 提交
        } catch (Exception e) {
            log.error(e.getMessage());
            platformTransactionManager.rollback(transactionStatus); // 回滾
        }
    }
}
