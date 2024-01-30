package com.aliyun.oss;

import org.springframework.boot.context.properties.ConfigurationProperties;

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
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliOSSProperties {
    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucketName;

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public String getBucketName() {
        return bucketName;
    }

    public void setBucketName(String bucketName) {
        this.bucketName = bucketName;
    }
}
