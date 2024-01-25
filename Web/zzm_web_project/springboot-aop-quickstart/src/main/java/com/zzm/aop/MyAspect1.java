package com.zzm.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 通知类型
 * 1. @Around: 环绕通知，此注解标注的通知方法在目标方法前、后都被执行
 * 2. @Before: 前置通知，此注解标注的通知方法在目标方法前被执行
 * 3. @After: 后置通知，此注解标注的通知方法在目标方法后被执行，无论是否有异常都会执行
 * 4. @AfterReturning: 返回后通知，此注解标注的通知方法在目标方法后被执行，有异常不会执行
 * 5. @AfterThrowing: 异常后通知，此注解标注的通知方法发生异常后执行
 *
 * @author Mingson
 * @version 1.0
 */
@Slf4j
@Component
//@Aspect
public class MyAspect1 {

    // @Pointcut 该注解的作用是将公共的切点表达式抽取出来，需要用到时引用该切点表达式即可。
    @Pointcut("execution(* com.zzm.service.impl.DeptServiceImpl.*(..))")
    public void pt(){}

//    @Before("execution(* com.zzm.service.impl.DeptServiceImpl.*(..))")
    @Before("pt()")
    public void before() {
        log.info("before ...");
    }

//    @Around("execution(* com.zzm.service.impl.DeptServiceImpl.*(..))")
    @Around("pt()")
    public Object around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        log.info("around before ...");

        // 调用目标对象的原始方法执行
        Object result = proceedingJoinPoint.proceed();

        log.info("around after ...");

        return result;
    }

//    @After("execution(* com.zzm.service.impl.DeptServiceImpl.*(..))")
    @After("pt()")
    public void after() {
        log.info("after ...");
    }

//    @AfterReturning("execution(* com.zzm.service.impl.DeptServiceImpl.*(..))")
    @AfterReturning("pt()")
    public void afterReturning() {
        log.info("afterReturning ...");
    }

//    @AfterThrowing("execution(* com.zzm.service.impl.DeptServiceImpl.*(..))")
    @AfterThrowing("pt()")
    public void afterThrowing() {
        log.info("afterThrowing ...");
    }
}
