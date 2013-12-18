package com.helpezee.ws.service;

public class SpringWS implements ISpringWS {

	public String sayHello(String message) {
		System.out.println(message);
		return message;
	}

	@Override
	public int add(int a, int b) {
		return a+b;
	}
}
