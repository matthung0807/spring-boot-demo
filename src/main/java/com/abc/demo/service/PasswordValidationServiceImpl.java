package com.abc.demo.service;

import com.abc.demo.service.validation.rule.Rule;

public class PasswordValidationServiceImpl implements PasswordValidationService {

    @Override
    public boolean isValid(String password, Rule... rules) {
        if (rules == null || rules.length == 0) {
            return true;
        }

        for (Rule rule : rules) {
            if (!rule.match(password)) {
                return false;
            }
        }
        return true;
    }

}
