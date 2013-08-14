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

Annotation 		Use 									Description
@Autowired 		Constructor, Field, Method 				Declares a constructor, field, setter method, or configuration method to be autowired by type. Items annotated with @Autowired do not have to be public.
@Configurable 	Type 									Used with to declare types whose properties should be injected, even if they are not instantiated by Spring. Typically used to inject the properties of domain objects.
@Order 			Type, Method, Field 					Defines ordering, as an alternative to implementing the org. springframework.core.Ordered interface.
@Qualifier 		Field, Parameter, Type, Annotation Type Guides autowiring to be performed by means other than by type.
@Required 		Method (setters) 						Specifies that a particular property must be injected or else the configuration will fail.
@Scope 			Type 									Specifies the scope of a bean, either singleton, prototype, request, session, or some custom scope.








*/