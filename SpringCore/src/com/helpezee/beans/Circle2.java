package com.helpezee.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;


import com.helpezee.interfaces.Shape;

public class Circle2 implements Shape{

	
	private Point center;
	
	public Point getCenter() {
		return center;
	}
	@Resource(name="Point")
	public void setCenter(Point center) {
		this.center = center;
	}
	
	@PostConstruct
	public void init(){
		System.out.println("init method");
	}
	
	@PreDestroy
	public void destroy(){
		System.out.println("Destroy method");	
	}
	
	

	@Override
	public void draw() {
		System.out.println("Drawing circle");
		System.out.println("Circle is::("+center.getX()+","+center.getY()+")");
		
	}

}
