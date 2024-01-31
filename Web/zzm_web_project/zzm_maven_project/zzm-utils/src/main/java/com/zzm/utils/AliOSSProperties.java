package com.zzm.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ConfigurationProperties 与 @Value
 *  相同点
 *      都是用来注入外部配置的属性的。
 *  不同点
 *      @Value 注解只能一个一个的进行外部属性的注入。
 *      @ConfiqurationProperties 可以批量的将外部的属性配置注入到bean对象的属性中。
 *
 * pom.xml 添加依赖 -> spring-boot-configuration-processor -> application.yml 配置文件 添加配置会有提示
 * @author Mingson
 * @version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProperties {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;
}
