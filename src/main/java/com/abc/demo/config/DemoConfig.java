package com.abc.demo.config;

import com.abc.demo.aop.annotation.Intercept;
import com.abc.demo.aop.interceptor.DemoMethodInterceptor;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisorByAspectJExpressionPointcut() {
        MethodInterceptor interceptor = new DemoMethodInterceptor();
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.abc.demo.service..*.*(..))");

        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(interceptor);
        return advisor;
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisorByAnnotationMatchingPointcut() {
        MethodInterceptor interceptor = new DemoMethodInterceptor();
        AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut.forMethodAnnotation(Intercept.class);

        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(interceptor);
        return advisor;
    }
}
