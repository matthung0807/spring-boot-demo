package com.abc.demo.service.validation.rule.character;

import com.abc.demo.service.validation.rule.PasswordValidationProperties;
import com.abc.demo.service.validation.rule.Rule;
import com.abc.demo.service.validation.rule.character.type.Character;

import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CharactersTypeRule implements Rule {

    private final Set<Character> characterSet = PasswordValidationProperties.getCharacterSet();

    public CharactersTypeRule(Character... characters) {
        for (Character character : characters) {
            characterSet.add(character);
        }
    }

    @Override
    public boolean match(String content) {
        System.out.println("CharactersTypeRule.match()");

        for (Character character : characterSet) {
            System.out.println(character.getClass().getSimpleName());
            String pattern = character.getPattern();
            int count = character.getCount();
            if (count <= 0) {
                continue;
            }
            if (isLessThanCount(pattern, content, count)) {
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
