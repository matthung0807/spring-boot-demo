package com.abc.demo.entity.enumeration.converter;

import com.abc.demo.entity.enumeration.State;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class StateConverter implements AttributeConverter<State, Integer> {
    @Override
    public Integer convertToDatabaseColumn(State attribute) {
        return attribute.getCode();
    }

    @Override
    public State convertToEntityAttribute(Integer dbData) {
        if (dbData == null) {
            return State.OTHERS;
        }

        return State.of(dbData);
    }
}
