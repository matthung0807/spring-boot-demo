package com.abc.demo.service.validation.rule;

import lombok.ToString;

@ToString
public class NoRepeatSequenceRule implements Rule {

    @Override
    public boolean match(String password) {
        return !isRepeat(password);
    }

    private boolean isRepeat(String content) {
        char[] chars = content.toCharArray();

        int lastIndex = chars.length - 1;
        for (int i = 0; i < chars.length; i++) {
            if (i >= lastIndex) { // last index
                break;
            }
            char nextChar = chars[i + 1];
            label:
            for (int j = 0; j <= i; j++) { // 從第一個字元開始比較到目前的字元
                if (nextChar == chars[j]) { // 如果下一個字與第j個字相同
                    // 從j開始到i的字都與i到i + (i - j)的字都相同代表重複
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
}
