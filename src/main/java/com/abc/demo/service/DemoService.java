package com.abc.demo.service;

import com.abc.demo.dao.DemoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

    @Autowired
    private DemoDao demoDao;

    public int add(long id, int amount) {
        return amount + demoDao.getAmount(id);
    }
}
