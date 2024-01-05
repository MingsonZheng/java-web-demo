package com.zzm.dao;

import com.zzm.pojo.Emp;

import java.util.List;

/**
 * @author Mingson
 * @version 1.0
 */
public interface EmpDao {
    // 获取员工列表数据
    public List<Emp> listEmp();
}
