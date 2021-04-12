package com.abc.demo.service.validation.rule.character;

import com.abc.demo.service.validation.rule.PasswordValidationProperties;
import com.abc.demo.service.validation.rule.Rule;

public class CharactersLengthRule implements Rule {

    private int minLength = PasswordValidationProperties.MIN_LENGTH;
    private int maxLength = PasswordValidationProperties.MAX_LENGTH;

    public CharactersLengthRule () {
    }

    public CharactersLengthRule(int minLength, int maxLength) {
        this.maxLength = minLength;
        this.maxLength = maxLength;
    }

    @Override
    public boolean match(String content) {
        System.out.println("CharactersLengthRule.match()");
        if (content == null) {
            return false;
        }
        if (minLength > maxLength) {
            throw new IllegalArgumentException(
                    "rule.length.min=" + minLength + " is greater than rule.length.max=" + maxLength);
        }
        return content.length() >= minLength
                && content.length() <= maxLength;
    }
}
