package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.interfaces.Shape;

public class MessageResourceInternalization {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
	    ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		//context.getMessage("testing", null, "Default Message",null);
		//context.registerShutdownHook();
		Shape shape=(Shape)context.getBean("circle2");
		shape.draw();
	    
		System.out.println(context.getMessage("testing", null, "Default Message",null));
	}

}
