package com.helpezee.model;

public class Circle {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name){
		this.name = name;
	}
	
	public void setNamethrowsException(String name){
		this.name = name;
		throw new RuntimeException();
	}
	
	public String setNameandReturns(String name){
		this.name = name;
		return name;
	}
}
