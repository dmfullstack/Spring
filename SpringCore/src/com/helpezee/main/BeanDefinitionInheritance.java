package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.beans.Line;
import com.helpezee.beans.ListLine;


public class BeanDefinitionInheritance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("spring.xml");
		
		//Using Property ref
		Line tri= (Line)context.getBean("childLine");
		tri.draw();
		System.out.println("----------------------------------------------------");
		
		//using list
		ListLine tri1= (ListLine)context.getBean("childLine1");
		tri1.draw();
	}

}
/* 
  Note: 
 parent="" is used for defining the parent class in inheritance concept
 merge attribute in list will combined both list values instead of over-writing 
 abstract="true" means spring won't create any object for this bean but used at template for references purpose
 */