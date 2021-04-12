package com.abc.demo.service.validation.rule;

import com.abc.demo.service.validation.rule.character.type.Character;
import com.abc.demo.service.validation.rule.character.type.DigitCharacter;
import com.abc.demo.service.validation.rule.character.type.LowercaseCharacter;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

public class PasswordValidationProperties {

    private PasswordValidationProperties() {
    }

    private static final String FILENAME = "password-validation-config.properties";

    public static final int MIN_LENGTH;
    public static final int MAX_LENGTH;

    private static final Set<Character> characterSet;

    static {
        InputStream inputStream =
                PasswordValidationProperties.class
                        .getClassLoader().getResourceAsStream(FILENAME);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }

        MIN_LENGTH = Integer.parseInt(properties.getProperty("rule.length.min"));
        MAX_LENGTH = Integer.parseInt(properties.getProperty("rule.length.max"));

        String[] charTypes = properties.getProperty("rule.char.types").split(",");
        characterSet = new HashSet<>();
        for (String character : charTypes) {
            if (character.equalsIgnoreCase("lowercase")) {
                int count = Integer.parseInt(properties.getProperty("rule.char.lowercase.count"));
                characterSet.add(new LowercaseCharacter(count));
            }
            if (character.equalsIgnoreCase("digit")) {
                int count = Integer.parseInt(properties.getProperty("rule.char.digit.count"));
                characterSet.add(new DigitCharacter(count));
            }
        }
    }

    public static Set<Character> getCharacterSet() {
        return new HashSet<>(characterSet);
    }
}
