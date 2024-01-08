package com.zzm;

import com.zzm.mapper.EmpMapper;
import com.zzm.pojo.Emp;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    private EmpMapper empMapper;

    // 根据ID查询员工
    @Test
    public void testGetById() {
        Emp emp = empMapper.getById(6);
        System.out.println(emp);
    }

    @Test
    public void testUpdate() {
        // 构造员工对象
        Emp emp = new Emp();
        emp.setId(6);
        emp.setUsername("Tom1");
        emp.setName("汤姆1");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        // 执行更新员工操作
        empMapper.update(emp);
    }

    @Test
    public void testInsert() {
        // 构造员工对象
        Emp emp = new Emp();
        emp.setUsername("Tom3");
        emp.setName("汤姆3");
        emp.setImage("1.jpg");
        emp.setGender((short)1);
        emp.setJob((short)1);
        emp.setEntrydate(LocalDate.of(2000, 1, 1));
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        emp.setDeptId(1);

        // 执行新增员工信息操作
        empMapper.insert(emp);
        System.out.println(emp.getId());
    }

    @Test
    public void testDelete() {
//        int delete = empMapper.delete(1);
//        System.out.println(delete);
        empMapper.delete(1);
    }

    @Test
    void contextLoads() {
    }

}
