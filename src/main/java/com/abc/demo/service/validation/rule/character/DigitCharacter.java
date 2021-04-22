package com.abc.demo.service.validation.rule.character;

import com.abc.demo.service.validation.properties.PasswordValidationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class DigitCharacter extends AbstractCharacter {

    @Autowired
    private PasswordValidationProperties passwordValidationProperties;

    @PostConstruct
    public void init() {
        this.count = passwordValidationProperties.getDigitCount();
    }

    @Override
    public String pattern() {
        return "[0-9]";
    }

}
