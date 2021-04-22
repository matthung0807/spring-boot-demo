package com.abc.demo.service.validation.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
public class PasswordValidationProperties {

    @Value("${rule.length.min:0}")
    private int lengthMin;

    @Value("${rule.length.max:1}")
    private int lengthMax;

    @Value("${rule.char.types:}")
    private String[] charTyeps;

    @Value("${rule.char.lowercase.count:1}")
    private int lowercaseCount;

    @Value("${rule.char.digit.count:1}")
    private int digitCount;

}
