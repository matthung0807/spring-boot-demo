package com.abc.demo.service.validation.rule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CharactersLengthRuleTests {

    @Test
    public void match_5to12_true() {
        CharactersLengthRule charactersLengthRule = new CharactersLengthRule(5, 12);
        Assertions.assertAll(
                () -> Assertions.assertTrue(charactersLengthRule.match("12345")),
                () -> Assertions.assertFalse(charactersLengthRule.match("123"))
        );
    }

    @Test
    public void match_1to1_true() {
        Assertions.assertTrue(new CharactersLengthRule(1, 1).match("1"));
    }

    @Test
    public void match_5to1_exception() {
        try {
            new CharactersLengthRule(5, 1);
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof IllegalArgumentException);
        }
    }
}
