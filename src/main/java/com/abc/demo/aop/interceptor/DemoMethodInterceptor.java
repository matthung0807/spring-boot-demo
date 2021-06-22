package com.abc.demo.aop.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

@Slf4j
public class DemoMethodInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation mi) throws Throwable {
        log.info("method={}, args={}", mi.getMethod(), mi.getArguments());
        Object ret = mi.proceed();
        log.info("return={}", ret);
        return ret;
    }
}
