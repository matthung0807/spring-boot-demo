package com.abc.demo.properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ConfigServerDemoPropertiesTests {

    @Autowired
    private ConfigServerDemoProperties configServerDemoProperties;

    @Value("${demo.env}")
    private String demoEnv;

    @Test
    void getEnv_correct() {

        System.out.println(demoEnv);

        String env = configServerDemoProperties.getEnv();
        Assertions.assertEquals("DEMO TEST", env);

    }

}
