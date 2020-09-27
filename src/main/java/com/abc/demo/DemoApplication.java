package com.abc.demo;

import com.abc.demo.properties.SystemProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.PropertySource;

@PropertySource("classpath:system-${spring.profiles.active}.properties")
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(DemoApplication.class, args);
        SystemProperties systemProperties = ctx.getBean(SystemProperties.class);

        System.out.println(systemProperties.getName());
        System.out.println(systemProperties.getUrl());
        System.out.println(systemProperties.getPort());

    }

}
