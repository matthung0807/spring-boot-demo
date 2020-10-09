package com.abc.demo.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource(properties = "app.name=Test Application")
@SpringBootTest
class DemoServiceTests {

    @Autowired
    private DemoService demoService;

    @Test
    void getAppName_test() {

        String appName = demoService.getAppName();
        Assertions.assertEquals("Test Application", appName);

    }
}
