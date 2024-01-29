package com.zzm;

import com.zzm.controller.DeptController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class SpringbootWebConfig2ApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

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
}
