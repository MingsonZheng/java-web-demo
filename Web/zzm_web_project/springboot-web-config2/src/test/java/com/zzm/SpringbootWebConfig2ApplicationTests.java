package com.zzm;

import com.zzm.controller.DeptController;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringbootWebConfig2ApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Autowired
	private SAXReader saxReader;

	/**
	 * 获取bean
	 * 	默认情况下，Spring项目启动时，会把bean都创建好放在I0C容器中，如果想要主动获取这些bean，可以通过如下方式
	 *
	 * 注意事项
	 * 	上述所说的【Spring项目启动时，会把其中的bean都创建好】还会受到作用域及延迟初始化影响，这里主要针对于 默认的单例
	 * 非延迟加载的bean而言。
	 */
	@Test
	public void testGetBean() {
		// 根据bean的名称获取
		DeptController bean1 = (DeptController) applicationContext.getBean("deptController");
		System.out.println(bean1);

		// 根据bean的类型获取
		DeptController bean2 = applicationContext.getBean(DeptController.class);
		System.out.println(bean2);

		// 根bean的名称 及 类型获取
		DeptController bean3 = applicationContext.getBean("deptController", DeptController.class);
		System.out.println(bean3);
	}

	/**
	 * bean作用域
	 * 	Spring支持五种作用域，后三种在web环境才生效:
	 *
	 *  作用域 		说明
	 * 	singleton 	容器内同 名称 的 bean 只有一个实例(单例)(默认)
	 * 	prototype	每次使用该 bean 时会创建新的实例(非单例)
	 * 	request		每个请求范围内会创建新的实例(web环境中，了解)
	 * 	session		每个会话范围内会创建新的实例(web环境中，了解)
	 * 	application	每个应用范围内会创建新的实例(web环境中，了解)
	 *
	 * 	可以通过 @Scope 注解来进行配置作用域:
	 *
	 * 	注意事项
	 * 	默认singleton的bean，在容器启动时被创建，可以使用@Lazy注解来延迟初始化(延迟到第一次使用时)。
	 * 	prototype的bean，每一次使用该bean的时候都会创建一个新的实例。
	 * 	实际开发当中，绝大部分的Bean是单例的，也就是说绝大部分Bean不需要配置scope属性。
	 */
	@Test
	public void testScope() {
		for (int i = 0; i < 10; i++) {
			DeptController deptController = applicationContext.getBean(DeptController.class);
			System.out.println(deptController);
		}
	}

	/**
	 * 第三方bean
	 * @Bean
	 * 	如果要管理的bean对象来自于第三方(不是自定义的)，是无法用 @Component及衍生注解声明bean的，就需要用到 @Bean注解。
	 * 	若要管理的第三方bean对象，建议对这些bean进行集中分类配置，可以通过 @Configuration 注解声明一个配置类。
	 *
	 * 注意事项
	 * 	通过@Bean注解的name或value属性可以声明bean的名称，如果不指定，默认bean的名称就是方法名。
	 * 	如果第三方bean需要依赖其它bean对象，直接在bean定义方法中设置形参即可，容器会根据类型自动装配。
	 * @throws Exception
	 */
	@Test
	public void testThirdBean() throws Exception {
//		SAXReader saxReader = new SAXReader();

		Document document = saxReader.read(this.getClass().getClassLoader().getResource("1.xml"));
		Element rootElement = document.getRootElement();
		String name = rootElement.element("name").getText();
		String age = rootElement.element("age").getText();

		System.out.println(name + " : " + age);
	}

	@Test
	public void testGetBean2() {
		Object saxReader = applicationContext.getBean("saxReader");
		System.out.println(saxReader);
	}
}
