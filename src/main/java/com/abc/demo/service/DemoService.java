package com.abc.demo.service;

import com.abc.demo.entity.ModifyLog;
import com.abc.demo.repository.EmployeeRepository;
import com.abc.demo.repository.ModifyLogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class DemoService {

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private ModifyLogRepository modifyLogRepository;

    /**
     * 無交易管理的方法
     */
    public void modifyName(long id, String name) {

        employeeRepository.findById(id).map(e -> {
            e.setName(name);
            return employeeRepository.save(e);
        }).ifPresent(e -> addModifyLog(  // 呼叫同類別中有交易管理的方法
                        e.getClass().getSimpleName().toUpperCase(),
                        e.getId()));

    }

    /**
     * 有交易管理的方法
     */
    @Transactional
    public void addModifyLog(String tableName, long tableId) {
        ModifyLog log = ModifyLog.builder()
                .tableName(tableName)
                .tableId(tableId)
                .modifyDate(new Date())
                .build();

        modifyLogRepository.save(log);

        throw new RuntimeException("Database error.");
    }

}
