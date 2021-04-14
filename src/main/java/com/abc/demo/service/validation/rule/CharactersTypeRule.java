package com.abc.demo.service.validation.rule;

import com.abc.demo.service.validation.properties.PasswordValidationProperties;
import com.abc.demo.service.validation.rule.character.Character;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
@ToString
public class CharactersTypeRule implements Rule {

    private final Set<Character> characterSet = PasswordValidationProperties.getCharacterSet();

    public CharactersTypeRule(Character... characters) {
        if (characters.length == 0) {
            throw new IllegalArgumentException("no character");
        }
        for (Character character : characters) {
            characterSet.add(character);
        }
    }

    @Override
    public boolean match(String password) {

        for (Character character : characterSet) {
            String pattern = character.getPattern();
            int count = character.getCount();
            if (count <= 0) {
                continue;
            }
            if (isLessThanCount(pattern, password, count)) {
                return false;
            }
        }
        return true;
    }

    private boolean isLessThanCount(String pattern, String content, int count) {
        Matcher matcher = Pattern.compile(pattern).matcher(content);
        int matchCount = 0;
        while (matcher.find()) {
            matchCount++;
        }
        return matchCount < count;
    }

}
