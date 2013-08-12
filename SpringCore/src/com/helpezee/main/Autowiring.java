package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.beans.Line;

public class Autowiring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

  ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
  Line line =(Line)context.getBean("Autowire");
  line.draw();
  

	}

}
/*
 Note: There are three types of Auto-wiring
 a)byName
 b)byType
 c)constructor
 
 byType and constructor should be used only when we have one bean 
 defined in the bean and as well as in spring.xml.
 
 For complex application it was suggested 
 that to define the bean configuration explicitly
 */
