package com.helpezee.beans;

public class Traingle {

	private String type;
	public void draw(){
		System.out.println(getType()+"Drawn Traingle");
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
