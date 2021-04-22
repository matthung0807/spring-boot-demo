package com.abc.demo.service.validation.properties;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PasswordValidationPropertiesTests {

    @Autowired
    private PasswordValidationProperties passwordValidationProperties;

    @Test
    public void getProperties() {
        Assertions.assertAll(
                () -> Assertions.assertEquals(5, passwordValidationProperties.getLengthMin()),
                () -> Assertions.assertEquals(12, passwordValidationProperties.getLengthMax()),
                () -> Assertions.assertEquals(1, passwordValidationProperties.getDigitCount()),
                () -> Assertions.assertEquals(1, passwordValidationProperties.getLowercaseCount())
        );

    }

}
