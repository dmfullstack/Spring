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
