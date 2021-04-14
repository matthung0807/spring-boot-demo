package com.abc.demo.service.validation.rule.character;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class LowercaseCharacterTests {

    @Test
    public void construct_exception() {
        try {
            new LowercaseCharacter(0);
            Assertions.fail();
        } catch (Exception e) {
            Assertions.assertTrue(e instanceof IllegalArgumentException);
        }
    }
}
