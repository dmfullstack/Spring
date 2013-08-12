package com.helpezee.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;

import com.helpezee.interfaces.Shape;

public class Circle3 implements Shape{

	@Autowired
	@Qualifier("circlerelated")
	private Point center;
	
	public Point getCenter() {
		return center;
	}
	//@Required
	@Autowired
	@Qualifier("circlerelated")
	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Drawing circle");
		System.out.println("Circle is::("+center.getX()+","+center.getY()+")");
		
	}

}
