package com.helpezee.main;



import com.helpezee.service.FactoryService;

import com.helpezee.service.ShapeService;

public class UnderStandingAOPProxy {
public static void main(String args[])
{
	/*
	ApplicationContext context=new ClassPathXmlApplicationContext("Spring.xml");
	Shape shape=context.getBean("shapeService",Shape.class);
	
	is using silmilary logic defined below
	 	  
	FactoryService service=new FactoryService();
	ShapeService shape=(ShapeService)service.getBean("ShapeService");
	
	*/
	

	FactoryService service=new FactoryService();
	ShapeService shape=(ShapeService)service.getBean("shapeService");
	shape.getCircle();
	
	
}

}

/*
 This example shows how Spring internally do process.we have done some harding in order to show actual Spring flow
 a)How it returns the Bean Objects from factory Service Class
 b)How it will call AOP Methods using proxy objects
 */
