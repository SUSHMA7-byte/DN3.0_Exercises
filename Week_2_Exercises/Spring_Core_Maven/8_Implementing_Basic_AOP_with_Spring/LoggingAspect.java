package com.library.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggingAspect {

    // Pointcut expression to match execution of any method in the service package
    @Pointcut("execution(* com.library.service.*.*(..))")
    private void selectAllMethodsInServicePackage() {}

    // Advice method that runs before any method matched by the pointcut
    @Before("selectAllMethodsInServicePackage()")
    public void beforeAdvice() {
        System.out.println("LoggingAspect: Before method execution.");
    }

    // Advice method that runs after any method matched by the pointcut
    @After("selectAllMethodsInServicePackage()")
    public void afterAdvice() {
        System.out.println("LoggingAspect: After method execution.");
    }
}
