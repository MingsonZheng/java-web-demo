package com.zzm.service;

import com.zzm.pojo.Dept;

import java.util.List;

/**
 * 部门管理
 *
 * @author Mingson
 * @version 1.0
 */
public interface DeptService {
    /**
     * 查询全部部门数据
     * @return
     */
    List<Dept> list();

    /**
     * 删除部门
     * @param id
     */
    void delete(Integer id);

    /**
     * 新增部门
     * @param dept
     */
    void add(Dept dept);

    Dept getById(Integer id);
}
