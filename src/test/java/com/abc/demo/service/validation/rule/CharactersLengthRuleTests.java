package com.abc.demo.service.validation.rule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CharactersLengthRuleTests {

    @Autowired
    private CharactersLengthRule charactersLengthRule;

    @Test
    public void match_5to12_true() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(charactersLengthRule.match("12345")),
                () -> Assertions.assertFalse(charactersLengthRule.match(null)),
                () -> Assertions.assertFalse(charactersLengthRule.match("")),
                () -> Assertions.assertFalse(charactersLengthRule.match("123"))
        );
    }

}
