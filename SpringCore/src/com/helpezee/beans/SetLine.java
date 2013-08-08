package com.helpezee.beans;

import java.util.Set;

public class SetLine {

	private Set<Point> points;



public Set<Point> getPoints() {
		return points;
	}



	public void setPoints(Set<Point> points) {
		this.points = points;
	}



public void draw(){
	for(Point point:points){
		System.out.println("Point::{"+ point.getX()+","+point.getY()+"}");
	}
}
	
}
