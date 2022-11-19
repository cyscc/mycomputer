package com.cyss.mycomputer.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: mycomputer
 * @PackageName: com.cyss.mycomputer.aop
 * @Author: cyss
 * @CreatTime: 2022-11-12 17:13
 * @Description:
 */
@Component
@Aspect
public class TimerAspect {

    @Around("execution(* com.cyss.mycomputer.service.impl.*.*(..))")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("耗时：" + (end - start));
        return result;
    }
}
