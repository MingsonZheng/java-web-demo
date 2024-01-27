package com.zzm.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 切入点表达式-execution
 *
 * execution(访问修饰符? 返回值 包名.类名.?方法名(方法参数) throws 异常?)
 *
 * 其中带?的表示可以省略的部分
 *  访问修饰符: 可省略(比如:public、protected)
 *  包名.类名: 可省略
 *  throws 异常: 可省略(注意是方法上声明抛出的异常，不是实际抛出的异常)
 *
 * 可以使用通配符描述切入点
 * *: 单个独立的任意符号，可以通配任意返回值、包名、类名、方法名、任意类型的一个参数，
 *    也可以通配包、类、方法名的一部分(比如 update* 通配 updateEmp，updateDept 方法)
 *      execution(* com.*.service.*.update*(*))
 * ..: 多个连续的任意符号，可以通配任意层级的包，或任意类型、任意个数的参数
 *      execution(* com.zzm..DeptService.*(..))
 *
 * 注意事项
 *  根据业务需要，可以使用 且(&&)、或()、非(!)来组合比较复杂的切入点表达式。
 *
 * 书写建议
 *  所有业务方法名在命名时尽量规范，方便切入点表达式快速匹配。如:查询类方法都是 find 开头，更新类方法都是 update开头。
 *  描述切入点方法通常基于接口描述，而不是直接描述实现类，增强拓展性。
 *  在满足业务需要的前提下，尽量缩小切入点的匹配范围。如:包名匹配尽量不使用.. ，使用 * 匹配单个包。
 *
 * @author Mingson
 * @version 1.0
 */
@Slf4j
//@Aspect
@Component
public class MyAspect6 {

//    @Pointcut("execution(public void com.zzm.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
//    @Pointcut("execution(void com.zzm.service.impl.DeptServiceImpl.delete(java.lang.Integer))")
//    @Pointcut("execution(void delete(java.lang.Integer))") //包名.类名不建议省略
//    @Pointcut("execution(void com.zzm.service.DeptService.delete(java.lang.Integer))")

//    @Pointcut("execution(void com.zzm.service.DeptService.*(java.lang.Integer))")
//    @Pointcut("execution(* com.*.service.DeptService.*(*))") // 方法里面必须有一个任意类型的参数
//    @Pointcut("execution(* com.zzm.service.*Service.delete*(*))")

//    @Pointcut("execution(* com.zzm.service.DeptService.*(..))") // 方法里面可以有任意个任意类型的参数
//    @Pointcut("execution(* com..DeptService.*(..))")
//    @Pointcut("execution(* com..*.*(..))")
//    @Pointcut("execution(* *(..))") // 当前环境所有方法，形参任意，慎用

    @Pointcut("execution(* com.zzm.service.DeptService.list()) || " +
            "execution(* com.zzm.service.DeptService.delete(java.lang.Integer))")
    private void pt(){}

    @Before("pt()")
    public void before() {
        log.info("MyAspect6 ... before ...");
    }

}
