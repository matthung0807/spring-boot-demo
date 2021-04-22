package com.abc.demo.controller;

import com.abc.demo.controller.request.RegisterRequest;
import com.abc.demo.service.validation.PasswordValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class RegisterController {

    @Autowired
    private PasswordValidationService passwordValidationService;

    @PostMapping("/register")
    public String register(@Valid @RequestBody RegisterRequest registerRequest) {
        boolean valid = passwordValidationService.isValid(registerRequest.getPassword());
        return valid ? "success" : "fail";
    }
}
