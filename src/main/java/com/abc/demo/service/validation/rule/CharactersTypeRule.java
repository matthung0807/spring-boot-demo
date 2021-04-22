package com.abc.demo.service.validation.rule;

import com.abc.demo.service.validation.properties.PasswordValidationProperties;
import com.abc.demo.service.validation.rule.character.Character;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Slf4j
@Setter
@Component
public class CharactersTypeRule implements Rule {

    @Autowired
    private PasswordValidationProperties passwordValidationProperties;

    @Autowired
    private List<Character> characterList;

    @Override
    public boolean match(String password) {
        if (password == null || password.length() < 1) {
            log.info("password is empty");
            return false;
        }

        characterList = characterList.stream()
                .filter(this::isInConfig).collect(Collectors.toList());

        for (Character character : characterList) {
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

    private boolean isInConfig(Character character) {
        Set<String> typeSet = new HashSet<>(Arrays.asList(passwordValidationProperties.getCharTyeps()));
        String className = character.getClass().getSimpleName();
        String type = className.substring(0, className.indexOf("Character")).toLowerCase();
        return typeSet.contains(type);
    }

    @Override
    public String toString() {
        return "CharactersTypeRule{characterList="+ characterList + "}";
    }

}
