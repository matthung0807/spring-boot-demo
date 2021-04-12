package com.abc.demo.controller;

import com.abc.demo.controller.request.RegisterRequest;
import com.abc.demo.service.PasswordValidationService;
import com.abc.demo.service.validation.rule.Rule;
import com.abc.demo.service.validation.rule.character.CharactersLengthRule;
import com.abc.demo.service.validation.rule.character.CharactersTypeRule;
import com.abc.demo.service.validation.rule.character.NoRepeatSequenceRule;
import com.abc.demo.service.validation.rule.character.type.LowercaseCharacter;
import com.abc.demo.service.validation.rule.character.type.DigitCharacter;
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
                new CharactersLengthRule(),
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
