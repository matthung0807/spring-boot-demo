package com.abc.demo;

import com.abc.demo.properties.SystemProperties;
import com.abc.demo.service.DemoService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@EnableConfigurationProperties(SystemProperties.class)
@PropertySource("classpath:system.properties")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        DemoService demoService = ctx.getBean(DemoService.class);

        demoService.printSystemPropertiesValue();

    }

}
