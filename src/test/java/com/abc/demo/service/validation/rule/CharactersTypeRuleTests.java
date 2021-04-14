package com.abc.demo.service.validation.rule;

import com.abc.demo.service.validation.rule.character.DigitCharacter;
import com.abc.demo.service.validation.rule.character.LowercaseCharacter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CharactersTypeRuleTests {

    @Test
    public void match_2lowercase() {
        Rule rule = new CharactersTypeRule(new LowercaseCharacter(2));
        Assertions.assertAll(
                () -> Assertions.assertTrue(rule.match("ab")),
                () -> Assertions.assertFalse(rule.match("aB"))
        );
    }

    @Test
    public void match_5lowercase() {
        Rule rule = new CharactersTypeRule(new LowercaseCharacter(5));
        Assertions.assertAll(
                () -> Assertions.assertTrue(rule.match("abcdef")),
                () -> Assertions.assertTrue(rule.match("abc123de")),
                () -> Assertions.assertFalse(rule.match("Abcde"))
        );
    }

    @Test
    public void match_2digit() {
        Rule rule = new CharactersTypeRule(new DigitCharacter(2));
        Assertions.assertAll(
                () -> Assertions.assertTrue(rule.match("12")),
                () -> Assertions.assertTrue(rule.match("abc12")),
                () -> Assertions.assertTrue(rule.match("12a21")),
                () -> Assertions.assertFalse(rule.match("1abc"))
        );
    }

    @Test
    public void match_1digitAnd1lowercase() {
        Rule rule = new CharactersTypeRule(new LowercaseCharacter(1), new DigitCharacter(1)
        );
        Assertions.assertAll(
                () -> Assertions.assertTrue(rule.match("1a")),
                () -> Assertions.assertTrue(rule.match("1a2b")),
                () -> Assertions.assertFalse(rule.match("123")),
                () -> Assertions.assertFalse(rule.match("abc"))
        );
    }
}
