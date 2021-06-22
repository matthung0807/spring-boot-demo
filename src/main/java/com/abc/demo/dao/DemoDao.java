package com.abc.demo.dao;

import com.abc.demo.aop.annotation.Intercept;
import org.springframework.stereotype.Repository;

@Repository
public class DemoDao {

    @Intercept
    public int getAmount(long id) {
        return 1000;
    }
}
