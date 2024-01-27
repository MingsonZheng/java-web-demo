package com.zzm.aop;

import com.zzm.mapper.OperateLogMapper;
import com.zzm.pojo.OperateLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author Mingson
 * @version 1.0
 */
@Slf4j
@Component
@Aspect //切面类
public class LogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.zzm.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 操作人ID - 当前登录员TID
        // 获取请求头中的iwt令牌，解析令牌


        // 操作时间
        // 操作类名
        // 操作方法名
        // 操作方法参数
        // 方法返回值
        // 操作耗时

        // 调用原始目标方法运行
        Object result = joinPoint.proceed();

        // 记录操作日志
        OperateLog operateLog = new OperateLog();
        operateLogMapper.insert(operateLog);
        return result;
    }
}
