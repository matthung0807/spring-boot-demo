package com.abc.demo.service.validation.rule;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class NoRepeatSequenceRuleTests {

    private NoRepeatSequenceRule noRepeatSequenceRule = new NoRepeatSequenceRule();

    @Test
    public void match() {
        Assertions.assertAll(
                () -> Assertions.assertTrue(noRepeatSequenceRule.match("1")),
                () -> Assertions.assertTrue(noRepeatSequenceRule.match("12345")),
                () -> Assertions.assertTrue(noRepeatSequenceRule.match("abc123abc")),
                () -> Assertions.assertTrue(noRepeatSequenceRule.match("abcde1abcde")),
                () -> Assertions.assertFalse(noRepeatSequenceRule.match("aa")),
                () -> Assertions.assertFalse(noRepeatSequenceRule.match("abab")),
                () -> Assertions.assertFalse(noRepeatSequenceRule.match("123123")),
                () -> Assertions.assertFalse(noRepeatSequenceRule.match("123aa")),
                () -> Assertions.assertFalse(noRepeatSequenceRule.match("123abab456")),
                () -> Assertions.assertFalse(noRepeatSequenceRule.match("123abcabc"))
        );
    }

}
