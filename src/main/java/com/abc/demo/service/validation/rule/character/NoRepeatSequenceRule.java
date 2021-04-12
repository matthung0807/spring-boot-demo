package com.abc.demo.service.validation.rule.character;

import com.abc.demo.service.validation.rule.Rule;

public class NoRepeatSequenceRule implements Rule {

    @Override
    public boolean match(String content) {
        return false;
    }
}
