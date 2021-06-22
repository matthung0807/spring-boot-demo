package com.abc.demo.config;

import com.abc.demo.aop.annotation.Intercept;
import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.annotation.AnnotationMatchingPointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DemoConfig {

    @Autowired
    private MethodInterceptor demoMethodInterceptor;

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisorByAspectJExpressionPointcut() {
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* com.abc.demo.service..*.*(..))");

        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(demoMethodInterceptor);
        return advisor;
    }

    @Bean
    public DefaultPointcutAdvisor defaultPointcutAdvisorByAnnotationMatchingPointcut() {
        AnnotationMatchingPointcut pointcut = AnnotationMatchingPointcut.forMethodAnnotation(Intercept.class);

        DefaultPointcutAdvisor advisor = new DefaultPointcutAdvisor();
        advisor.setPointcut(pointcut);
        advisor.setAdvice(demoMethodInterceptor);
        return advisor;
    }
}
