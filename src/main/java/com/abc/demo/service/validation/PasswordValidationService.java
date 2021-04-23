package com.abc.demo.service.validation;

import com.abc.demo.service.validation.rule.Rule;

import java.util.List;

public interface PasswordValidationService {
    boolean isValid(String password);
    PasswordValidationService config(List<Class<? extends Rule>> ruleClasses);
}
