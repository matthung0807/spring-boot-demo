package com.abc.demo.service.validation;

import com.abc.demo.service.validation.rule.Rule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Scope("prototype")
@Component
public class PasswordValidationServiceImpl implements PasswordValidationService {

    @Autowired
    private List<Rule> ruleList;

    @Override
    public boolean isValid(String password) {

        log.info("validate password by rules={}", ruleList);

        for (Rule rule : ruleList) {
            if (!rule.match(password)) {
                log.info("password does not match rule of {}", rule);
                return false;
            }
        }
        return true;
    }

    @SafeVarargs
    @Override
    public final PasswordValidationService config(Class<? extends Rule>... ruleClasses) {
        if (ruleClasses == null || ruleClasses.length < 1) {
            ruleList = Collections.emptyList();
        }

        Set<Class<? extends Rule>> ruleSet = new HashSet<>(Arrays.asList(ruleClasses));
        ruleList = ruleList.stream().filter(rule -> ruleSet.contains(rule.getClass()))
                .collect(Collectors.toList());
        return this;
    }


}
