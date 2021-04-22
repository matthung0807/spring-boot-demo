package com.abc.demo.service.validation.rule;

import com.abc.demo.service.validation.properties.PasswordValidationProperties;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Setter
@Component
public class CharactersLengthRule implements Rule {

    @Autowired
    private PasswordValidationProperties passwordValidationProperties;

    @Override
    public boolean match(String password) {
        if (password == null || password.length() < 1) {
            log.info("password is empty");
            return false;
        }
        int minLength = passwordValidationProperties.getLengthMin();
        int maxLength = passwordValidationProperties.getLengthMax();
        if (minLength > maxLength) {
            throw new IllegalArgumentException(
                    "rule.length.min=" + minLength + " is greater than rule.length.max=" + maxLength);
        }
        return password.length() >= minLength
                && password.length() <= maxLength;
    }

    @Override
    public String toString() {
        return "CharactersLengthRule{minLength=" + passwordValidationProperties.getLengthMin()
                + ", maxLength=" + passwordValidationProperties.getLengthMax() + "}";
    }
}
