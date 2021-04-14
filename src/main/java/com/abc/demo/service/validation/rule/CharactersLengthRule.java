package com.abc.demo.service.validation.rule;

import com.abc.demo.service.validation.properties.PasswordValidationProperties;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@ToString
public class CharactersLengthRule implements Rule {

    private final int minLength;
    private final int maxLength;

    public CharactersLengthRule () {
        minLength = PasswordValidationProperties.MIN_LENGTH;
        maxLength = PasswordValidationProperties.MAX_LENGTH;
    }

    public CharactersLengthRule(int minLength, int maxLength) {
        if (minLength > maxLength) {
            throw new IllegalArgumentException(
                    "minLength=" + minLength + " is greater than maxLength=" + maxLength);
        }
        this.minLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public boolean match(String password) {
        if (password == null) {
            log.info("password is null");
            return false;
        }
        if (minLength > maxLength) {
            throw new IllegalArgumentException(
                    "rule.length.min=" + minLength + " is greater than rule.length.max=" + maxLength);
        }
        return password.length() >= minLength
                && password.length() <= maxLength;
    }

}
