package com.helpezee.service;

import com.helpezee.aspect.LoggingAspect;
import com.helpezee.model.Circle;

public class ShapeServiceProxy extends ShapeService {

public Circle getCircle(){
	new LoggingAspect().loggerAdvice();
	return super.getCircle();
}
}
