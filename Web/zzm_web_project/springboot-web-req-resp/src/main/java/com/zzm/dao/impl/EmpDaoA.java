package com.zzm.dao.impl;

import com.zzm.dao.EmpDao;
import com.zzm.pojo.Emp;
import com.zzm.utils.XmlParserUtils;

import java.util.List;

/**
 * @author Mingson
 * @version 1.0
 */
public class EmpDaoA implements EmpDao {
    @Override
    public List<Emp> listEmp() {
        // 1. 加载并解析 emp.xml
        String file = this.getClass().getClassLoader().getResource("emp.xml").getFile();
        System.out.println(file);
        List<Emp> empList = XmlParserUtils.parse(file, Emp.class);
        return empList;
    }
}
