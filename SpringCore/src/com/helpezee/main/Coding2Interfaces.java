package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.interfaces.Shape;

public class Coding2Interfaces {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		Shape shape=(Shape)context.getBean("circle1");
		shape.draw();
		
		Shape shape1=(Shape)context.getBean("triangle1");
		shape1.draw();
		
		
		

	}

}
/*Note:  it  is better to use interfaces,so that they won't be  tight coupling with code.
 * tomarrow if we want to add new rectangle, just add new bean entry for that in xml 
  and change the bean calling
 No need to change any implementation part */