package com.abc.demo.service.validation.rule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CharactersTypeRuleTests {

    @Autowired
    private CharactersTypeRule rule;

    @Test
    public void match_1lowercaseAnd1digit() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(rule.match("1ab")),
                () -> Assertions.assertFalse(rule.match(null)),
                () -> Assertions.assertFalse(rule.match("")),
                () -> Assertions.assertFalse(rule.match("aB"))
        );
    }

}
