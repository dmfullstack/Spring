package com.helpezee.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class CallBackBean implements InitializingBean,DisposableBean {
	
private Point pointA;
private Point pointB;
private Point pointC;


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
	public void destroy() throws Exception {
		System.out.println("DisposableBean  generated destroy");
		
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("InitializingBean generated init");
		
	}
	

	public void destroymethod() throws Exception {
		System.out.println("destroy-method from spring xml file");
		
	}

	
	public void initmethod() throws Exception {
		System.out.println("init-method  from spring xml file");
		
	}
	
	public void draw() {
		System.out.println("PointA(" + pointA.getX() + "," + pointA.getY()
				+ ")");
		System.out.println("PointB(" + pointB.getX() + "," + pointB.getY()
				+ ")");
		System.out.println("PointC(" + pointC.getX() + "," + pointC.getY()
				+ ")");
	}

}
