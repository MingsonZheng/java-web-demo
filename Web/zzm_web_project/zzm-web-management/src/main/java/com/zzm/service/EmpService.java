package com.zzm.service;

import com.zzm.pojo.PageBean;

/**
 * 员工管理
 *
 * @author Mingson
 * @version 1.0
 */
public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
    PageBean page(Integer page, Integer pageSize);
}
