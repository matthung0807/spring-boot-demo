package com.abc.demo.controller.validation.validator;

import com.abc.demo.controller.validation.annotation.Password;
import com.abc.demo.service.validation.PasswordValidationService;
import com.abc.demo.service.validation.PasswordValidationServiceImpl;
import com.abc.demo.service.validation.rule.CharactersLengthRule;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidationService passwordValidationService = new PasswordValidationServiceImpl();
        return passwordValidationService.isValid(
                password,
                new CharactersLengthRule(5, 12));
    }
}
