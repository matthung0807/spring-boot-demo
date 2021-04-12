package com.abc.demo.controller.validation.validator;

import com.abc.demo.controller.validation.annotation.Password;
import com.abc.demo.service.PasswordValidationService;
import com.abc.demo.service.PasswordValidationServiceImpl;
import com.abc.demo.service.validation.rule.character.CharactersLengthRule;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

    @Override
    public boolean isValid(String password, ConstraintValidatorContext context) {
        PasswordValidationService passwordValidationService = new PasswordValidationServiceImpl();
        return passwordValidationService.isValid(
                password,
                new CharactersLengthRule());
    }
}
