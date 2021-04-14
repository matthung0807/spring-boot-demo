package com.abc.demo.service.validation;

import com.abc.demo.service.validation.rule.Rule;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PasswordValidationServiceImpl implements PasswordValidationService {

    @Override
    public boolean isValid(String password, Rule... rules) {
        log.info("validate password by rules={}", rules);

        for (Rule rule : rules) {
            if (!rule.match(password)) {
                log.info("password does not match rule of {}", rule);
                return false;
            }
        }
        return true;
    }

}
