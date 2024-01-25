package com.zzm.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 通知顺序
 * 当有多个切面的切入点都匹配到了目标方法，目标方法运行时，多个通知方法都会被执行
 *
 * 执行顺序
 * 1. 不同切面类中，默认按照切面类的类名字母排序
 *      目标方法前的通知方法: 字母排名靠前的先执行
 *      目标方法后的通知方法: 字母排名靠前的后执行
 * 2. 用 @Order(数字) 加在切面类上来控制顺序
 *      目标方法前的通知方法: 数字小的先执行
 *      目标方法后的通知方法: 数字小的后执行
 *
 * @author Mingson
 * @version 1.0
 */
@Order(3)
@Slf4j
@Component
//@Aspect
public class MyAspect2 {

    @Before("execution(* com.zzm.service.impl.DeptServiceImpl.*(..))")
    public void before() {
        log.info("before ...2");
    }

    @After("execution(* com.zzm.service.impl.DeptServiceImpl.*(..))")
    public void after() {
        log.info("after ...2");
    }
}
