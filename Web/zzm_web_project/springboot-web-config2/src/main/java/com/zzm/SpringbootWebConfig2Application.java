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
