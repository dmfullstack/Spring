
package com.helpezee.service;

import com.helpezee.aspect.Loggable;
import com.helpezee.model.Circle;
import com.helpezee.model.Triangle;

public class ShapeService {

private Circle circle;
private Triangle triangle;

public Circle getCircle() {
	System.out.println("GetCircle Called");
	return circle;
}
public void setCircle(Circle circle) {
	this.circle = circle;
}
public Triangle getTriangle() {
	return triangle;
}
public void setTriangle(Triangle triangle) {
	this.triangle = triangle;
}


}
