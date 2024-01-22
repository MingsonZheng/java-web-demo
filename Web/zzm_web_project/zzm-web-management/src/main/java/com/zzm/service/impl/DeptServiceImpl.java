package com.zzm.service.impl;

import com.zzm.mapper.DeptMapper;
import com.zzm.mapper.EmpMapper;
import com.zzm.pojo.Dept;
import com.zzm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author Mingson
 * @version 1.0
 */
@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;
    @Autowired
    private EmpMapper empMapper;

    @Override
    public List<Dept> list() {
        return deptMapper.list();
    }

    @Transactional(rollbackFor = Exception.class) //spring事务管理
    @Override
    public void delete(Integer id) throws Exception {
        deptMapper.deleteById(id);// 根据ID删除部门数据

//        int i = 1 / 0;// 模拟抛出异常

        // 默认情况下，只有出现 RuntimeException才回滚异常
        // rollbackFor属性用于控制出现何种异常类型，回滚事务。
        if (true) {
            throw new Exception("出错啦...");
        }

        empMapper.deleteByDeptId(id);// 根据部门ID删除该部门下的员工
    }

    @Override
    public void add(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.insert(dept);
    }
}
