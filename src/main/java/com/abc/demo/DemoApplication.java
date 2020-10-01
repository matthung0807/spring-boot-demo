package com.abc.demo;

import com.abc.demo.properties.SystemProperties;
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
        SystemProperties systemProperties = ctx.getBean(SystemProperties.class);

        System.out.println(systemProperties.getName());    // Demo system
        System.out.println(systemProperties.getVersion()); // 1.0.0
        System.out.println(systemProperties.getUrl());     // 192.168.0.111
        System.out.println(systemProperties.getPort());    // 8080

        System.out.println(systemProperties.getKeyMap());  // {key2=value2;, key1=value1}

        System.out.println(systemProperties.getAdmin().getUsername()); // admin
        System.out.println(systemProperties.getAdmin().getPassword()); // 12345
        System.out.println(systemProperties.getAdmin().getSchemas());  // [greenlake, redsky]

    }

}
