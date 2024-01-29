package com.zzm;

import com.example.EnableHeaderConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 自动配置原理
 * 	方案一: @ComponentScan 组件扫描
 * 	方案二: @Import 导入。使用@Import导入的类会被Spring加载到I0C容器中，导入形式主要有以下几种:
 * 		导入 普通类
 * 		导入 配置类
 * 		导入 ImportSelector 接口实现类
 * 		@EnableXxxx注解，封装@Import注解
 *
 *  源码跟踪
 *  	@springBootApplication
 * 			该注解标识在SpringBoot工程引导类上，是SpringBoot中最最最重要的注解。该注解由三个部分组成:
 * 				@SpringBootConfiguration: 该注解与 @Configuration 注解作用相同，用来声明当前也是一个配置类。
 * 				@ComponentScan:组件扫描，默认扫描当前引导类所在包及其子包。
 * 				@EnableAutoConfiquration:SpringBoot实现自动化配置的核心注解。
 *
 * 				@EnableAutoConfiquration ->
 * 					@Import({AutoConfigurationImportSelector.class}) ->
 * 						getCandidateConfigurations() ->
 * 								String[] selectImports() ->
 * 									getAutoConfigurationEntry() ->
 * 										META-INF/spring/org.springframework.boot.autoconfigure.AutoConfiguration.imports
 * 										(spring-boot 2.7.x 之前版本的配置文件在 META-INF/spring.factories)
 */

//@ComponentScan({"com.example", "com.zzm"}) //组件扫描

//@Import({TokenParser.class}) //导入普通类，交给IOC容器管理
//@Import({HeaderConfig.class}) //导入配置类，交给IOC容器管型
//@Import({MyImportSelector.class}) //导入ImportSelector接口实现类

@EnableHeaderConfig
@SpringBootApplication
public class SpringbootWebConfig2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebConfig2Application.class, args);
	}
}
