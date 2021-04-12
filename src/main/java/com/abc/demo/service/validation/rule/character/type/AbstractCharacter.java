package com.abc.demo.service.validation.rule.character.type;

import java.util.Objects;

public abstract class AbstractCharacter implements Character {

    protected String pattern;
    protected int count;

    protected AbstractCharacter(int count) {
        if (count < 1) {
            throw new IllegalArgumentException("count is less than 1");
        }
        this.count = count;
        this.pattern = pattern();
    }

    protected abstract String pattern();

    public String getPattern() {
        return pattern;
    }
    public int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractCharacter that = (AbstractCharacter) o;
        return pattern.equals(that.pattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pattern);
    }
}
