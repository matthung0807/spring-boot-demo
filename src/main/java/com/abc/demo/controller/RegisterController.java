package com.abc.demo.controller;

import com.abc.demo.controller.request.RegisterRequest;
import com.abc.demo.service.validation.PasswordValidationService;
import com.abc.demo.service.validation.rule.CharactersLengthRule;
import com.abc.demo.service.validation.rule.CharactersTypeRule;
import com.abc.demo.service.validation.rule.NoRepeatSequenceRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;

@RestController
public class RegisterController {

    @Autowired
    private ApplicationContext context;

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest registerRequest) {
        PasswordValidationService passwordValidationService = context.getBean(PasswordValidationService.class);
        boolean valid = passwordValidationService.config(
                Arrays.asList(CharactersLengthRule.class,
                        CharactersTypeRule.class,
                        NoRepeatSequenceRule.class)
        ).isValid(registerRequest.getPassword());

        return valid ? "success" : "fail";
    }
}
