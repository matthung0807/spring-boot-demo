package com.abc.demo.controller;

import com.abc.demo.controller.request.RegisterRequest;
import com.abc.demo.service.validation.PasswordValidationService;
import com.abc.demo.service.validation.rule.Rule;
import com.abc.demo.service.validation.rule.CharactersLengthRule;
import com.abc.demo.service.validation.rule.CharactersTypeRule;
import com.abc.demo.service.validation.rule.NoRepeatSequenceRule;
import com.abc.demo.service.validation.rule.character.LowercaseCharacter;
import com.abc.demo.service.validation.rule.character.DigitCharacter;
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
        Rule[] rules = {
                new CharactersLengthRule(5, 12),
                new CharactersTypeRule(
                        new LowercaseCharacter(1),
                        new DigitCharacter(1)
                ),
                new NoRepeatSequenceRule()
        };

        boolean valid = passwordValidationService.isValid(
                registerRequest.getPassword(),
                rules);
        return valid ? "success" : "fail";
    }
}
