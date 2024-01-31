package com.zzm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * maven高级-分模块设计与开发
 *
 * 1. 什么是分模块设计?
 *      将项目按照功能拆分成若干个子模块
 * 2. 为什么要分模块设计?
 *      方便项目的管理维护、扩展，也方便模块间的相互调用，资源共享
 * 3. 注意事项
 *      分模块设计需要先针对模块功能进行设计，再进行编码。不会先将工程开发完毕，然后进行拆分
 */
@ServletComponentScan //开启了对servlet组件的支持
@SpringBootApplication
public class ZzmWebManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzmWebManagementApplication.class, args);
    }

}
