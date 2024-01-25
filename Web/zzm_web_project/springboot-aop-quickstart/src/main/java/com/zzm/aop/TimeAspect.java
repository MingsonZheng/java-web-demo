package com.zzm.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * AOP核心概念
 * 连接点: JoinPoint，可以被AOP控制的方法(暗含方法执行时的相关信息) 比如 DeptServiceImpl 中的方法
 * 通知: Advice，指哪些重复的逻辑，也就是共性功能(最终体现为一个方法) 比如 TimeAspect 的 recordTime 方法
 * 切入点: Pointcut，匹配连接点的条件，通知仅会在切入点方法执行时被应用 比如 TimeAspect 的 Around 注解
 * 切面: Aspect，描述通知与切入点的对应关系(通知+切入点) 比如 TimeAspect 这个切面类
 * 目标对象: Target，通知所应用的对象 比如 DeptServiceImpl 类
 *
 * @author Mingson
 * @version 1.0
 */
@Slf4j
@Component
//@Aspect //AOP类
public class TimeAspect {

//    @Around("execution(* com.zzm.service.*.*(..))") //切入点表达式
    @Around("com.zzm.aop.MyAspect1.pt()")
    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {
        // 1. 记录开始时间
        long begin = System.currentTimeMillis();

        // 2. 调用原始方法运行
        Object result = joinPoint.proceed();

        // 3. 记录结束时间，计算方法执行耗时
        long end = System.currentTimeMillis();
        log.info(joinPoint.getSignature() + "方法执行耗时：{}ms", end - begin);

        return result;
    }
}
