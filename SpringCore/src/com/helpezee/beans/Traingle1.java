package com.helpezee.beans;

import com.helpezee.interfaces.Shape;

public class Traingle1 implements Shape{

Point pointA;
Point pointB;
Point pointC;
public Point getPointA() {
	return pointA;
}
public void setPointA(Point pointA) {
	this.pointA = pointA;
}
public Point getPointB() {
	return pointB;
}
public void setPointB(Point pointB) {
	this.pointB = pointB;
}
public Point getPointC() {
	return pointC;
}
public void setPointC(Point pointC) {
	this.pointC = pointC;
}
@Override
public void draw() {
	System.out.println("Drawing Traingle");
	System.out.println("PointA(" + pointA.getX() + "," + pointA.getY()
			+ ")");
	System.out.println("PointB(" + pointB.getX() + "," + pointB.getY()
			+ ")");
	System.out.println("PointC(" + pointC.getX() + "," + pointC.getY()
			+ ")");
}
	
}


