package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.interfaces.Shape;

public class AutowiredAnnotation {
	public static void main(String args[]){
		ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		Shape shape=(Shape)context.getBean("Autowiredannotation");
		shape.draw();
		}
		
}
/*
Note:
a)@Autowired will default use byType,it will created problem when it find multiple beans of same type
b)First it will checks for type, if it found only bean of such type, it will wire automatically,
if it find multiple beans of same type:it will check for the bean with name member variable(center)
c)solution for the above problems are using Qualifier annotation








*/