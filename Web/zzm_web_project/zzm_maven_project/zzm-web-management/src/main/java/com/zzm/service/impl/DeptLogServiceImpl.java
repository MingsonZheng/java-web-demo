package com.zzm.service.impl;

import com.zzm.mapper.DeptLogMapper;
import com.zzm.pojo.DeptLog;
import com.zzm.service.DeptLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Mingson
 * @version 1.0
 */
@Service
public class DeptLogServiceImpl implements DeptLogService {

    @Autowired
    private DeptLogMapper deptLogMapper;

    /**
     * 事务属性-传播行为
     * 属性值          含义
     * REQUIRED       【默认值】需要事务，有则加入，无则创建新事务
     * REQUIRED_NEW    需要新事务，无论有无，总是创建新事务
     * SUPPORTS        支持事务，有则加入，无则在无事务状态中运行
     * NOT_SUPPORTED   不支持事务，在无事务状态下运行,如果当前存在已有事务,则挂起当前事务
     * MANDATORY       必须有事务，否则抛异常
     * NEVER           必须没事务，否则抛异常
     * @param deptLog
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    @Override
    public void insert(DeptLog deptLog) {
        deptLogMapper.insert(deptLog);
    }
}
