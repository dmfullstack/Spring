package com.helpezee.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.helpezee.interfaces.Shape;

public class ComponentandSterotypeAnnotations {
	public static void main(String args[]){
		AbstractApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		Shape shape=(Shape)context.getBean("circle2");
		shape.draw();
		}
}

/*
//@Component or @Service or @Repository or @Controller
 
 All the above tell the spring that this circle2 is a bean.
 for this  we need define a tag  shown below for telling the spring container that
 there are some more beans defined with annotation, go and check the package mentioned the tag

<context:component-scan base-package="com.helpezee.beans"></context:component-scan>

Annotation 		Use 	Description
@Component 		Type 	Generic stereotype annotation for any Spring-managed component.
@Controller 	Type 	Stereotypes a component as a Spring MVC controller.
@Repository 	Type 	Stereotypes a component as a repository. Also indicates that SQLExceptions thrown from the component's methods should be translated into Spring DataAccessExceptions.
@Service 		Type 	Stereotypes a component as a service.


Annotation | Meaning                                             |
+------------+-----------------------------------------------------+
| @Component | generic stereotype for any Spring-managed component |
| @Repository| stereotype for persistence layer                    |
| @Service   | stereotype for service layer                        |
| @Controller| stereotype for presentation layer (spring-mvc)      




*/