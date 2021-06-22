package com.abc.demo.aop.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DemoMethodInterceptor implements MethodInterceptor {

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        log.info("method={}, args={}", invocation.getMethod(), invocation.getArguments());
        Object ret = invocation.proceed();
        log.info("return={}", ret);
        return ret;
    }
}
