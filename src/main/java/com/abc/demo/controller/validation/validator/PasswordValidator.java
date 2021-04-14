package com.abc.demo.controller.validation.validator;

import com.abc.demo.controller.validation.annotation.Password;
import com.abc.passwordvalidator.PasswordValidationService;
import com.abc.passwordvalidator.PasswordValidationServiceImpl;
import com.abc.passwordvalidator.rule.CharactersLengthRule;

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
