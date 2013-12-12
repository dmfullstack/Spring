package com.helpezee.beancreationusingFactoryMethod;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainController {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext beanFactory = new ClassPathXmlApplicationContext("test-servlet.xml");
		Singer factoryMadeSingerBean =  (Singer)beanFactory.getBean("factoryMadeSingerBean");
		System.out.println(factoryMadeSingerBean.getSong());
		
		Musician musicianMadeSingerBean =  (Musician)beanFactory.getBean("duplicateBean");
		System.out.println(musicianMadeSingerBean.getInstrument());

	}

}
