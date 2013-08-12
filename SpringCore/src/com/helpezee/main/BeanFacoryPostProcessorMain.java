package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.beans.BeanFacoryPostProcessorBean;


public class BeanFacoryPostProcessorMain {
	public static void main(String args[]){
	  ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
	  BeanFacoryPostProcessorBean bean=(BeanFacoryPostProcessorBean)context.getBean("beanfactorypostprocess");
	  bean.draw();
	    
	}


}
