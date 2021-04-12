package com.abc.demo.service.validation.rule.character.type;

import java.util.Objects;

public class LowercaseCharacter extends AbstractCharacter {

    public LowercaseCharacter(int count) {
        super(count);
    }

    @Override
    protected String pattern() {
        return "[a-z]";
    }

}
