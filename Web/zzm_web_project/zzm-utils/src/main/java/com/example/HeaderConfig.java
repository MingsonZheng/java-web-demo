package com.example;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动配置原理
 *  @Conditional
 *      作用: 按照一定的条件进行判断，在满足给定条件后才会注册对应的bean对象到SpringIOC容器中。
 *      位置: 方法、类
 *      @Conditional 本身是一个父注解，派生出大量的子注解:
 *          @ConditionalOnClass: 判断环境中是否有对应字节码文件，才注册bean到IOC容器
 *          @ConditionalOnMissingBean: 判断环境中没有对应的bean(类型 或名称)，才注册bean到IOC容器
 *          @ConditionalOnProperty: 判断配置文件中有对应属性和值，才注册bean到IOC容器。
 *
 * @author Mingson
 * @version 1.0
 */
@Configuration
public class HeaderConfig {

    @Bean
//    @ConditionalOnClass(name = "io.jsonwebtoken.Jwts") //判断环境(pom.xml -> jjwt)中是否有对应字节码文件，才注册bean到IOC容器
//    @ConditionalOnMissingBean //判断环境中没有对应的bean(类型(value属性 -> HeaderParser)或名称(name属性))，才注册bean到IOC容器
    @ConditionalOnProperty(name = "name", havingValue = "zzm") // 判断配置文件(application.yml)中有对应属性和值，才注册bean到IOC容器
    public HeaderParser headerParser() {
        return new HeaderParser();
    }

    @Bean
    public HeaderGenerator headerGenerator() {
        return new HeaderGenerator();
    }
}
