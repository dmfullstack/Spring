package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



import com.helpezee.dao.SimpleJdbcDaoSuportClass;
import com.helpezee.dao.SpringDaoImpl;
import com.helpezee.model.Circle;

public class SpringDemo {
	public static void main(String args[]){
	ApplicationContext context= new ClassPathXmlApplicationContext("spring.xml");
	//SpringDaoImpl jdbc=(SpringDaoImpl)context.getBean("springDaoImpl");
	SimpleJdbcDaoSuportClass jdbc=(SimpleJdbcDaoSuportClass)context.getBean("simplejdbcdaosupportclass");
	/*Circle circle=jdbc.getCircle(1);
	System.out.println("id----"+circle.getId());
	System.out.println("name---"+circle.getName());*/
	
	//System.out.println("circle count---"+jdbc.getCircleRowCount());
	
	//System.out.println("circle name---"+jdbc.getCircleName(1));

	//System.out.println("No of circles in the list---"+jdbc.getAllCircles().size());

	//jdbc.insertCircle(new Circle(5,"Fourth circle"));
	
	//jdbc.insertCircle2(new Circle(7,"seventh circle"));
	
	//jdbc.deleteCircle(4);
	
	//jdbc.createTriangle();
	
	jdbc.insertCircle(new Circle(8,"eigth circle"));

	
	
	
}
}