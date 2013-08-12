package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.interfaces.Shape;

public class RequiredAnnotationMain {
	public static void main(String args[]){
	ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
	Shape shape=(Shape)context.getBean("requiredannotation");
	shape.draw();
	}
	
	
	
}
/*Note: 
  This @Required annotation is very much useful,
  it will check the dependency at the time of bean initialization
  and will throw the exception if any dependency is missing.it is suggesstedto use this
  annotation.
  
  for testing pls comment the property tag that is defined inside the bean id="requiredannotation"
 
*/