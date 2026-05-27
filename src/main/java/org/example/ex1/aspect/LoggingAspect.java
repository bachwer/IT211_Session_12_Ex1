package org.example.ex1.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.hibernate.mapping.Join;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Before("execution(* org.example.ex1.controller.*.*(..))")
    public void logBeforeController(JoinPoint joinPoint){
        log.info("Method Called: {}", joinPoint.getSignature().getName());
        log.info("Arguments: {}", Arrays.toString(joinPoint.getArgs()) );
    }


    @AfterReturning(argNames = "execution(* org.example.ex1.controller.*.*(..))",
            returning =  "result")
    public void logAfterReturning(JoinPoint joinPoint, Objects objects){
        log.info("Service method: {}", joinPoint.getSignature().getName());

        log.info("Returned: {}", objects);
    }


    @Around("execution(* org.example.ex1.controller.*.*(..))")

    public Object measureExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long start = System.currentTimeMillis();

        Object result = joinPoint.proceed();

        long end = System.currentTimeMillis();

        log.info("Execution time of {} : {} ms",

                joinPoint.getSignature().getName(),

                (end - start));

        return result;

    }



}
