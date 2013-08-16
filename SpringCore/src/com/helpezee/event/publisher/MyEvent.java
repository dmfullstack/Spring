package com.helpezee.event.publisher;

import org.springframework.context.ApplicationEvent;

public class MyEvent  extends ApplicationEvent{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyEvent(Object source) {
		super(source);
	}
	

	public String toString(){
		return "drawEvent Occurred";
	}
}
