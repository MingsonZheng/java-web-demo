package com.zzm.controller;

import com.aliyun.oss.AliOSSUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * 需求
 *  需求: 自定义aliyun-oss-spring-boot-starter，完成阿里云OSS操作工具类 AliyunOSSUtils 的自动配置。
 *  目标: 引入起步依赖引入之后，要想使用阿里云OSS，注入AliyunOSSUtils直接使用即可。
 *
 * 步骤
 *  创建 aliyun-oss-spring-boot-starter 模块
 *  创建 aliyun-oss-spring-boot-autoconfigure 模块，在starter中引入该模块
 *  在 aliyun-oss-spring-boot-autoconfigure 模块中的定义自动配置功能，并定义自动配置文件META-INF/spring/xxxx.imports
 *
 * aliyun-oss-spring-boot-starter 依赖管理功能
 * aliyun-oss-spring-boot-autoconfigure 自动配置功能
 *
 * @author Mingson
 * @version 1.0
 */
@RestController
public class UploadController {

    @Autowired
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public String upload(MultipartFile image) throws IOException {
        // 上传文件到阿里云 OSS
        String url = aliOSSUtils.upload(image);
        return url;
    }
}
