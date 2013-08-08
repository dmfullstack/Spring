package com.helpezee.beans;


import java.util.Map;
import com.helpezee.beans.Point;
public class MapLine {

	private Map<String,Point> points;

	public Map<String, Point> getPoints() {
		return points;
	}

	public void setPoints(Map<String, Point> points) {
		this.points = points;
	}
	public void draw(){
	       for(Point point:points.values()){
	    	   System.out.println("Point::{"+ point.getX()+","+point.getY()+"}");   
	       }
}
}