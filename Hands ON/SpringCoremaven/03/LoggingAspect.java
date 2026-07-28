package com.library.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;

import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

    @Before("execution(* com.library.service.*.*(..))")
    public void beforeMethod(JoinPoint joinPoint) {

        System.out.println("Before : " + joinPoint.getSignature().getName());

    }

    @After("execution(* com.library.service.*.*(..))")
    public void afterMethod(JoinPoint joinPoint) {

        System.out.println("After : " + joinPoint.getSignature().getName());

    }

}