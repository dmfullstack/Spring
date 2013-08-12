package com.helpezee.main;

import org.springframework.context.ApplicationContext;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.beans.BeanPostProcessorBean;


public class BeanPostProcessorMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	     ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
	     BeanPostProcessorBean bean=(BeanPostProcessorBean)context.getBean("beanpostprocess");
		 bean.draw();

	}

}
/* Note: this bean has two methods
 
 postProcessAfterInitialization: called for every bean after initialization
 postProcessBeforeInitialization:called for every bean before initialization
 
 configure required is a) write a class that implements BeanPostProcessor 
 interface and metion tha bean in spring xml file as shown below
 
 	<bean class="com.helpezee.processors.DisplayNameBeanPostProcessor"/>
 */