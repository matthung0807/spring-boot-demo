package com.abc.demo.service.validation.properties;

import com.abc.demo.service.validation.rule.character.Character;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;

@SpringBootTest
public class PasswordValidationPropertiesTests {

    @Test
    public void getCharacterSet_empty() {
        Set<Character> characterSet = PasswordValidationProperties.getCharacterSet();
        Assertions.assertTrue(characterSet.isEmpty());
    }

}
