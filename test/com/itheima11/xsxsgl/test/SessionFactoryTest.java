package com.itheima11.xsxsgl.test;

import org.hibernate.SessionFactory;
import org.junit.Test;

public class SessionFactoryTest extends SpringUtils{
	@Test
	public void testSessionFactory(){
		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
	}
}
