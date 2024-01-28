package com.zzm;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 配置
 * 	SpringBoot 中支持三种格式的配置文件:
 *
 * 		application.properties 优先级1
 * 			server.port=8081
 *
 * 		application.yml 优先级2
 * 			server:
 *   			port: 8082
 *
 * 		application.yaml 优先级3
 * 			server:
 *   			port: 8083
 *
 * 注意事项
 * 	虽然springboot支持多种格式配置文件，但是在项目开发时，推荐统一使用一种格式的配置(yml是主流)
 *
 * SpringBoot 除了支持配置文件属性配置，还支持Java系统属性和命令行参数的方式进行属性配置。
 * 	Java系统属性 (优先级高于三种配置文件)
 * 		-Dserver.port=9000
 * 	命令行参数 (优先级高于Java系统属性，三种配置文件)
 * 		--server.port=10010
 *
 *  idea 中配置 VM options (Java系统属性 -Dserver.port=9000)
 *  	Run/Debug Configurations -> Modify options -> Add VM options
 * 	idea 中配置 Program arguments (命令行参数 --server.port=10010)
 * 		Run/Debug Configurations -> Modify options -> Program arguments
 *
 * 打包运行
 * 1. 执行maven打包指令package
 * 2. 执行java指令，运行jar包
 * 	java -Dserver.port=9000 -jar springboot-web-config-0.0.1-SNAPSHOT --server.port=10010
 *
 * 注意事项
 * 	Springboot项目进行打包时，需要引入插件 spring-boot-maven-plugin(基于官网骨架创建项目，会自动添加该插件)
 */
@SpringBootApplication
public class SpringbootWebConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebConfigApplication.class, args);
	}

}
