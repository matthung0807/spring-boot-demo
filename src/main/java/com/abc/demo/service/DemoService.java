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
        demoDao.update1(1L, "John"); // John -&gt; Sam
        demoDao.update2(1L, "Kenny"); // Sam -&gt; Paul
    }

}
