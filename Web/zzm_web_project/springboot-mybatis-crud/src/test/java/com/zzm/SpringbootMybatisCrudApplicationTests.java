package com.zzm;

import com.zzm.mapper.EmpMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootMybatisCrudApplicationTests {

    @Autowired
    private EmpMapper empMapper;

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
