package com.abc.demo.service.validation.rule.character;

import com.abc.demo.service.validation.properties.PasswordValidationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class LowercaseCharacter extends AbstractCharacter {

    @Autowired
    private PasswordValidationProperties passwordValidationProperties;

    @PostConstruct
    public void init() {
        this.count = passwordValidationProperties.getLowercaseCount();
    }

    @Override
    protected String pattern() {
        return "[a-z]";
    }

}
