package com.abc.demo.service;

import com.abc.demo.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoService {

    @Autowired
    private DemoDao demoDao;

    @Transactional
    public void modify() {
        demoDao.insert("Ivy");
        demoDao.update1(1L, "John");  // Ivy -> John
        demoDao.update2(1L, "Kenny"); // John -> Kenny
    }

}
