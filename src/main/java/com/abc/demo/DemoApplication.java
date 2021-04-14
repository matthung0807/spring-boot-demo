package com.abc.demo;

import com.abc.passwordvalidator.PasswordValidationService;
import com.abc.passwordvalidator.PasswordValidationServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public PasswordValidationService passwordValidationService() {
        return new PasswordValidationServiceImpl();
    }

}
