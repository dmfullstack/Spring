package com.helpezee.beans;

import com.helpezee.interfaces.Shape;

public class Circle1 implements Shape{

	private Point center;
	
	public Point getCenter() {
		return center;
	}

	public void setCenter(Point center) {
		this.center = center;
	}

	@Override
	public void draw() {
		System.out.println("Drawing circle");
		System.out.println("Circle is::("+center.getX()+","+center.getY()+")");
		
	}

}
