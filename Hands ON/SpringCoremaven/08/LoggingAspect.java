package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.service.*.*(..))")
    public void beforeAdvice(JoinPoint joinPoint) {

        System.out.println("Before executing : "
                + joinPoint.getSignature().getName());

    }

    @After("execution(* com.library.service.*.*(..))")
    public void afterAdvice(JoinPoint joinPoint) {

        System.out.println("After executing : "
                + joinPoint.getSignature().getName());

    }

}