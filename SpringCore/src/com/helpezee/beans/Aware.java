package com.helpezee.beans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class Aware implements ApplicationContextAware,BeanNameAware{
	
	ApplicationContext context=null;
	

	@Override
	public void setBeanName(String bean) {
		System.out.println("Bean name::"+bean);
		
	}

	@Override
	public void setApplicationContext(ApplicationContext context)
			throws BeansException {
		this.context=context;
		
	}


	public void draw(){
		Point pointA=(Point) context.getBean("pointA");
		Point pointB=(Point) context.getBean("pointB");
		Point pointC=(Point) context.getBean("pointC");
		
		System.out.println("PointA(" + pointA.getX() + "," + pointA.getY()
				+ ")");
		System.out.println("PointB(" + pointB.getX() + "," + pointB.getY()
				+ ")");
		System.out.println("PointC(" + pointC.getX() + "," + pointC.getY()
				+ ")");
	}

	
}
