package com.abc.demo.service.validation;

import com.abc.demo.service.validation.rule.CharactersLengthRule;
import com.abc.demo.service.validation.rule.CharactersTypeRule;
import com.abc.demo.service.validation.rule.NoRepeatSequenceRule;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class PasswordValidationServiceImplTests {

    @Autowired
    private PasswordValidationServiceImpl passwordValidationService;

    @Test
    public void isValid_5to12() {
        passwordValidationService.config(CharactersLengthRule.class);

        Assertions.assertAll(
                () -> Assertions.assertTrue(passwordValidationService.isValid("12345")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("1234")),
                () -> Assertions.assertFalse(passwordValidationService.isValid(null)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("1234567890123"))
        );
    }

    @Test
    public void isValid_1lowercaseAnd1digit() {
        passwordValidationService.config(CharactersTypeRule.class);

        Assertions.assertAll(
                () -> Assertions.assertTrue(passwordValidationService.isValid("1abcDef")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("123456")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("abcde"))
        );
    }

    @Test
    public void isValid_5to12And1digitAnd1lowercase() {

        passwordValidationService.config(CharactersLengthRule.class, CharactersTypeRule.class);

        Assertions.assertAll(
                () -> Assertions.assertTrue(passwordValidationService.isValid("12345abcde")),
                () -> Assertions.assertFalse(passwordValidationService.isValid(null)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("1234567abcdefgh"))
        );
    }

    @Test
    public void isValid_noRepeat() {

        passwordValidationService.config(NoRepeatSequenceRule.class);

        Assertions.assertAll(
                () -> Assertions.assertTrue(passwordValidationService.isValid("a" )),
                () -> Assertions.assertTrue(passwordValidationService.isValid("abc" )),
                () -> Assertions.assertTrue(passwordValidationService.isValid("abc123" )),
                () -> Assertions.assertTrue(passwordValidationService.isValid("abc123abc")),
                () -> Assertions.assertTrue(passwordValidationService.isValid("abcba")),
                () -> Assertions.assertTrue(passwordValidationService.isValid(null)),
                () -> Assertions.assertTrue(passwordValidationService.isValid("")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("aa")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("0aa")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("0abcabc")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("a12323")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("Aab12ab12")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("abcd1234512345xyz"))
        );
    }

    @Test
    public void isValid_5to12And1digitAnd1lowercaseAndNoRepeat() {
        passwordValidationService.config(
                CharactersLengthRule.class,
                CharactersTypeRule.class,
                NoRepeatSequenceRule.class);
        Assertions.assertAll(
                () -> Assertions.assertTrue(passwordValidationService.isValid("ab123")),
                () -> Assertions.assertTrue(passwordValidationService.isValid("a1234")),
                () -> Assertions.assertTrue(passwordValidationService.isValid("1abcd")),
                () -> Assertions.assertFalse(passwordValidationService.isValid(null)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("1")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("a")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("ab12")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("abcde")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("12345")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("0abcabc")),
                () -> Assertions.assertFalse(passwordValidationService.isValid("012ab12abc0"))
        );
    }

}
