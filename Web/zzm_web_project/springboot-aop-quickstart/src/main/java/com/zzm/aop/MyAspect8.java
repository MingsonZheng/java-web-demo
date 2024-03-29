package com.zzm.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 连接点
 * 在Spring中用JoinPoint抽象了连接点，用它可以获得方法执行时的相关信息，如目标类名、方法名、方法参数等
 *  对于 @Around 通知，获取连接点信息只能使用 ProceedingJoinPoint
 *  对于其他四种通知，获取连接点信息只能使用 JoinPoint，它是 ProceedingJoinPoint 的父类型
 *
 * @author Mingson
 * @version 1.0
 */
@Slf4j
@Aspect
@Component
public class MyAspect8 {

    @Pointcut("execution(* com.zzm.service.DeptService.*(..))")
    private void pt(){}

    @Before("pt()")
    public void before(JoinPoint joinPoint) {
        log.info("MyAspect8 ... before ...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("MyAspect8 around before ...");

        // 1. 获取 目标对象的类名
        String className = joinPoint.getTarget().getClass().getName();
        log.info("目标对象的类名: {}", className);

        // 2. 获取 目标方法的方法名
        String methodName = joinPoint.getSignature().getName();
        log.info("目标方法的方法名: {}", methodName);

        // 3. 获取 目标方法运行时传入的参数
        Object[] args = joinPoint.getArgs();
        log.info("目标方法运行时传入的参数: {}", Arrays.toString(args));

        // 4. 放行 目标方法执行
        Object result = joinPoint.proceed();

        // 5. 获取 目标方法运行的返回值
        log.info("目标方法运行的返回值: {}", result);

        log.info("MyAspect8 around after ...");
        return result;
    }
}
