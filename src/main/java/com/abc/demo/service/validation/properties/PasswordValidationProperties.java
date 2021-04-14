package com.abc.demo.service.validation.properties;

import com.abc.demo.service.validation.rule.character.Character;
import com.abc.demo.service.validation.rule.character.DigitCharacter;
import com.abc.demo.service.validation.rule.character.LowercaseCharacter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;

@Slf4j
public class PasswordValidationProperties {

    private PasswordValidationProperties() {
    }

    private static final String FILENAME = "password-validation-config.properties";

    public static final int MIN_LENGTH;
    public static final int MAX_LENGTH;

    private static final Set<Character> characterSet;

    static {
        log.info("load properties from {}", FILENAME);
        InputStream inputStream =
                PasswordValidationProperties.class
                        .getClassLoader().getResourceAsStream(FILENAME);
        Properties properties = new Properties();
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            log.error("load {} error", FILENAME);
            e.printStackTrace();
        }

        MIN_LENGTH = getNumberProperties(properties,"rule.length.min");
        MAX_LENGTH = getNumberProperties(properties,"rule.length.max");

        String[] charTypes = getArrayProperties(properties,"rule.char.types");
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

    private static int getNumberProperties(Properties properties, String propertyKey) {
        try {
            return Integer.parseInt(properties.getProperty(propertyKey));
        } catch (NumberFormatException e) {
            return 0;
        }
    }

    private static String[] getArrayProperties(Properties properties, String propertyKey) {
        String arrayValue = properties.getProperty(propertyKey);
        if (arrayValue == null) {
            return new String[]{};
        }

        return arrayValue.split(",");
    }
}
