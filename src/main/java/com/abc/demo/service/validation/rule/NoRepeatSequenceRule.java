package com.abc.demo.service.validation.rule;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class NoRepeatSequenceRule implements Rule {

    @Override
    public boolean match(String password) {
        return !isRepeat(password);
    }

    private boolean isRepeat(String password) {
        if (password == null || password.length() < 1) {
            log.info("password is empty");
            return false;
        }
        char[] chars = password.toCharArray();

        int lastIndex = chars.length - 1;
        for (int i = 0; i < chars.length; i++) {
            if (i >= lastIndex) { // last index
                break;
            }
            char nextChar = chars[i + 1];
            label:
            for (int j = 0; j <= i; j++) {
                if (nextChar == chars[j]) {
                    for (int k = 0; k <= (i - j); k++) {
                        if (i + 1 + k > lastIndex) { // 超出範圍
                            continue label;
                        }
                        if (chars[j + k] != chars[i + 1 + k]) {
                            continue label;
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "NoRepeatSequenceRule";
    }
}
