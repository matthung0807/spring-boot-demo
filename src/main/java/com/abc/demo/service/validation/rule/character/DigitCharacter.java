package com.abc.demo.service.validation.rule.character;

public class DigitCharacter extends AbstractCharacter {

    public DigitCharacter(int count) {
        super(count);
    }

    @Override
    public String pattern() {
        return "[0-9]";
    }

}
