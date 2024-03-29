package com.zzm;

import com.zzm.pojo.Dept;
import com.zzm.service.DeptService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class SpringbootAopQuickstartApplicationTests {

    @Autowired
    private DeptService deptService;

    @Test
    void contextLoads() {
    }

    @Test
    public void testAopDelete() {
        deptService.delete(10);
    }

    @Test
    public void testAopList() {
        List<Dept> list = deptService.list();
        System.out.println(list);
    }

    @Test
    public void testAopGetById() {
        Dept dept = deptService.getById(1);
        System.out.println(dept);
    }
}
