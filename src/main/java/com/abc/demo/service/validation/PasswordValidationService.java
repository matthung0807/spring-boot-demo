package com.abc.demo.service.validation;

import com.abc.demo.service.validation.rule.Rule;

public interface PasswordValidationService {
    boolean isValid(String password, Rule... rules);
}
