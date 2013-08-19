package com.helpezee.service;

import com.helpezee.model.Circle;
import com.helpezee.model.Triangle;

public class FactoryService {
	
public Object getBean(String beanType){
	if(beanType.equals("shapeService")) return new ShapeServiceProxy();
	if(beanType.equals("circle")) return new Circle();
	if(beanType.equals("triangle")) return new Triangle();
	return null;
}

}
