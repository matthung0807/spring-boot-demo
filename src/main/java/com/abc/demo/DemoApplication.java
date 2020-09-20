package com.abc.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan(basePackages = {
//        "com.abc.demo.controller",
//        "com.abc.demo.service",
//        "com.abc.demo.repository"
//})
@SpringBootApplication(scanBasePackages = {
        "com.abc.demo.controller",
        "com.abc.demo.service",
        "com.abc.demo.repository"
})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
