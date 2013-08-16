package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.interfaces.Shape;

public class EventHandlerMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		Shape shape=(Shape)context.getBean("circle2");
		shape.draw();
	    
	
	}

}
