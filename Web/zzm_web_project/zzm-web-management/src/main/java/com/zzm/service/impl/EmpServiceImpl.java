package com.zzm.service.impl;

import com.zzm.mapper.EmpMapper;
import com.zzm.pojo.Emp;
import com.zzm.pojo.PageBean;
import com.zzm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mingson
 * @version 1.0
 */
@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize) {
        // 1. 获取总记录数
        Long count = empMapper.count();

        // 2. 获取分页查询结果列表
        Integer start = (page - 1) * pageSize;
        List<Emp> empList = empMapper.page(start, pageSize);

        // 3. 封装PageBean对象
        PageBean pageBean = new PageBean(count, empList);
        return pageBean;
    }
}
