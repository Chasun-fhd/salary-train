package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Parameter;
import java.util.Objects;

/**
 * @author: haidong.feng
 * @createdAt: 2020/6/18
 * @description:
 **/
@Aspect
@Component
@Slf4j
public class CacheAspect {

    @Before(value = "@annotation(Intercept)")
    public void intercept(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Object[] args = joinPoint.getArgs();
        Parameter[] parameters = methodSignature.getMethod().getParameters();
        int idx = 0;
        for (Parameter parameter : parameters) {
            if (parameter.isAnnotationPresent(CacheKey.class)) {
                Object paramValue = args[idx];
                System.out.println(parameter.getName() + ":" + paramValue);
            }
            idx++;
        }

    }
}
