package com.zzm.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切入点表达式-@annotation
 * @annotation 切入点表达式，用于匹配标识有特定注解的方法
 *
 * @author Mingson
 * @version 1.0
 */
@Slf4j
//@Aspect
@Component
public class MyAspect7 {

    // 匹配DeptServiceImpl中的 list() 和 delete(Integer id) 方法
//    @Pointcut("execution(* com.zzm.service.DeptService.list()) || " +
//            "execution(* com.zzm.service.DeptService.delete(java.lang.Integer))")
    @Pointcut("@annotation(com.zzm.aop.MyLog)")
    private void pt(){}

    @Before("pt()")
    public void before() {
        log.info("MyAspect7 ... before ...");
    }

}
