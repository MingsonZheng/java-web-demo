package com.zzm.service;

import com.zzm.pojo.Emp;

import java.util.List;

/**
 * @author Mingson
 * @version 1.0
 */
public interface EmpService {
    // 获取员工列表
    public List<Emp> listEmp();
}
