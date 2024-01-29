package com.zzm;

import com.example.HeaderGenerator;
import com.example.HeaderParser;
import com.example.TokenParser;
import com.google.gson.Gson;
import com.zzm.pojo.Result;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

/**
 * 自动配置原理测试
 *  SpringBoot的自动配置就是当spring容器启动后，一些配置类、bean对象就自动存入到了I0C容器中，不需要我们手动去声明，
 *  从而简化了开发，省去了繁琐的配置操作。
 *
 * @author Mingson
 * @version 1.0
 */
@SpringBootTest
public class AutoConfigurationTests {

    @Autowired
    private Gson gson;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testJson() {
        String json = gson.toJson(Result.success());
        System.out.println(json);
    }

    // 获取TokenParser
    @Test
    public void testTokenParser() {
        System.out.println(applicationContext.getBean(TokenParser.class));
    }

    // 获取HeaderParser
    @Test
    public void testHeaderParser() {
        System.out.println(applicationContext.getBean(HeaderParser.class));
    }

    // 获取HeaderGenerator
    @Test
    public void testHeaderGenerator() {
        System.out.println(applicationContext.getBean(HeaderGenerator.class));
    }
}
