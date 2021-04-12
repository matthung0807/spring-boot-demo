package com.abc.demo.service;

import com.abc.demo.service.validation.rule.Rule;

public interface PasswordValidationService {
    boolean isValid(String password, Rule... rules);
}
