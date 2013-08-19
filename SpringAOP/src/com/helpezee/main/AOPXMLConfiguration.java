package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.service.Shape;

public class AOPXMLConfiguration {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
		Shape shape=context.getBean("shapeService",Shape.class);
		shape.getCircle().setName("Yahoo");  // for @After
		//shape.getCircle().setNamethrowsException("Yahoo"); // for @AfterThrowing
		shape.getCircle().setNameandReturns("Yahoo"); // for @AfterReturning
		shape.getCircle() ; // for @Around
	}

}

/*Note: In order to test the XML AOP Configuration functionality,
 please comment all the annotation in the class: LoggingAspect.java 
 */