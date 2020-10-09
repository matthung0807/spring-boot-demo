package com.abc.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
class DemoServiceTests {

    @Autowired
    private DemoService demoService;

    @Test
    void plus_test() {

        int x = 1;
        int y = 2;

        int actual = demoService.plus(x, y);

        int expected = x + y;
        Assertions.assertEquals(expected, actual);

    }
}
