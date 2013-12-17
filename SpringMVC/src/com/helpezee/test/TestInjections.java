package com.helpezee.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.beancreationusingFactoryMethod.Singer;

public class TestInjections {
	public static void main(String[] args) {
		ApplicationContext beanFactory = new ClassPathXmlApplicationContext("test-servlet.xml");
		Singer factoryMadeSingerBean =  (Singer)beanFactory.getBean("Test");
		System.out.println(factoryMadeSingerBean.getSong());

	}

}
