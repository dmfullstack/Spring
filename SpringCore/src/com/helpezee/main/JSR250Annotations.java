package com.helpezee.main;


import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.interfaces.Shape;

public class JSR250Annotations {
	public static void main(String args[]){
		AbstractApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		Shape shape=(Shape)context.getBean("jsr250annotation");
		shape.draw();
		}
}
/*

Annotation 		Use 			Description
@PostConstruct 	Method 			Indicates a method to be invoked after a bean has been created and dependency injection is complete. Used to perform any initialization work necessary.
@PreDestroy 	Method 			Indicates a method to be invoked just before a bean is removed from the Spring context. Used to perform any cleanup work necessary.
@Resource 		Method, Field 	Indicates that a method or field should be injected with a named resource (by default, another bean).
*/