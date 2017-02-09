package com.itheima11.xsxsgl.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringUtils {
	public static ApplicationContext context;
	static{
		context = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}
}
