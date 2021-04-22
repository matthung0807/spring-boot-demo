package com.abc.demo.service.validation.rule.character;

import java.util.Objects;

public abstract class AbstractCharacter implements Character {

    protected String pattern;
    protected int count;

    protected AbstractCharacter() {
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

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
                "count=" + count +
                '}';
    }
}
