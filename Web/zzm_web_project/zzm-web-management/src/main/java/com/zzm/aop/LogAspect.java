package com.zzm.aop;

import com.alibaba.fastjson.JSONObject;
import com.zzm.mapper.OperateLogMapper;
import com.zzm.pojo.OperateLog;
import com.zzm.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Arrays;

/**
 * 案例
 * 将案例中 增、删、改 相关接口的操作日志记录到数据库表中。
 *
 * 步骤
 *  准备:
 *      在案例工程中引入AOP的起步依赖
 *      导入资料中准备好的数据库表结构，并引入对应的实体类
 *  编码:
 *      自定义注解 @Log
 *      定义切面类，完成记录操作日志的逻辑
 *
 * 获取当前登录用户
 *  获取request对象，从请求头中获取到jwt令牌，解析令牌获取出当前用户的id。
 *
 * @author Mingson
 * @version 1.0
 */
@Slf4j
@Component
@Aspect //切面类
public class LogAspect {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Around("@annotation(com.zzm.anno.Log)")
    public Object recordLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 操作人ID - 当前登录员TID
        // 获取请求头中的iwt令牌，解析令牌
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJwt(jwt);
        Integer operateUser = (Integer) claims.get("id");

        // 操作时间
        LocalDateTime operateTime = LocalDateTime.now();

        // 操作类名
        String className = joinPoint.getTarget().getClass().getName();

        // 操作方法名
        String methodName = joinPoint.getSignature().getName();

        // 操作方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);

        long begin = System.currentTimeMillis();
        // 调用原始目标方法运行
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();

        // 方法返回值
        String returnValue = JSONObject.toJSONString(result);

        // 操作耗时
        Long costTime = end - begin;

        // 记录操作日志
        OperateLog operateLog = new OperateLog(null,operateUser,operateTime,className,methodName,methodParams,returnValue,costTime);
        operateLogMapper.insert(operateLog);

        log.info("AOP记录操作日志：{}", operateLog);

        return result;
    }
}
