package com.abc.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DemoServiceTests {

    @Autowired
    private DemoService demoService;

    @Test
    public void test() {
        int result = demoService.add(1, 999);
        Assertions.assertEquals(1999, result);
    }
}
