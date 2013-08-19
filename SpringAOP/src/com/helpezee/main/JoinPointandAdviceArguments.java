package com.helpezee.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.helpezee.model.Circle;
import com.helpezee.service.Shape;

public class JoinPointandAdviceArguments {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("spring.xml");
		//Circle circle=ctx.getBean("circle",Circle.class);
		//System.out.println(circle.getName());
		Shape shape=ctx.getBean("shapeService",Shape.class);
		shape.getCircle().setName("Yahoo");
		//System.out.println(shape.getCircle().getName());

	}

}
