package com.abc.demo.service.validation;

import com.abc.demo.service.validation.rule.Rule;
import com.abc.demo.service.validation.rule.CharactersLengthRule;
import com.abc.demo.service.validation.rule.CharactersTypeRule;
import com.abc.demo.service.validation.rule.NoRepeatSequenceRule;
import com.abc.demo.service.validation.rule.character.DigitCharacter;
import com.abc.demo.service.validation.rule.character.LowercaseCharacter;
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
        Rule[] rules = {new CharactersLengthRule(5, 12)};

        Assertions.assertAll(
                () -> Assertions.assertTrue(passwordValidationService.isValid("12345", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("1234", rules))
        );
    }


    @Test
    public void isValid_5digit() {
        Rule[] rules = {new CharactersTypeRule(new DigitCharacter(5))};

        Assertions.assertAll(
                () -> Assertions.assertTrue(passwordValidationService.isValid("11111", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("aaaaa", rules))
        );
    }

    @Test
    public void isValid_5lowercase() {
        Rule[] rules = {new CharactersTypeRule(new LowercaseCharacter(5))};

        Assertions.assertAll(
                () -> Assertions.assertTrue(passwordValidationService.isValid("abcDef", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("ABCdeF", rules))
        );
    }

    @Test
    public void isValid_5to12And5digitAnd5lowercase() {

        Rule[] rules = {new CharactersLengthRule(5, 12),
                new CharactersTypeRule(
                        new DigitCharacter(5),
                        new LowercaseCharacter(5))};

        Assertions.assertAll(
                () -> Assertions.assertTrue(passwordValidationService.isValid("12345abcde", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("1234567abcdefgh", rules))
        );
    }

    @Test
    public void isValid_noRepeat() {
        Rule[] rules = {new NoRepeatSequenceRule()};

        Assertions.assertAll(
                () -> Assertions.assertTrue(passwordValidationService.isValid("a", rules)),
                () -> Assertions.assertTrue(passwordValidationService.isValid("abc", rules)),
                () -> Assertions.assertTrue(passwordValidationService.isValid("abc123", rules)),
                () -> Assertions.assertTrue(passwordValidationService.isValid("abc123abc", rules)),
                () -> Assertions.assertTrue(passwordValidationService.isValid("abcba", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("aa", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("0aa", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("0abcabc", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("a12323", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("Aab12ab12", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("abcd1234512345xyz", rules))
        );
    }

    @Test
    public void isValid_5to12And1digitAnd1lowercaseAndNoRepeat() {
        Rule[] rules = {
                new CharactersLengthRule(5, 12),
                new CharactersTypeRule(
                        new DigitCharacter(1),
                        new LowercaseCharacter(1)
                ),
                new NoRepeatSequenceRule()};

        Assertions.assertAll(
                () -> Assertions.assertTrue(passwordValidationService.isValid("ab123", rules)),
                () -> Assertions.assertTrue(passwordValidationService.isValid("a1234", rules)),
                () -> Assertions.assertTrue(passwordValidationService.isValid("1abcd", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("1", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("a", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("ab12", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("abcde", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("12345", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("0abcabc", rules)),
                () -> Assertions.assertFalse(passwordValidationService.isValid("012ab12abc0", rules))
        );
    }

}
