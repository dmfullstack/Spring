
package com.helpezee.beans;

public class Scope {

	String message;
	 
	public String getMessage() {
		return message;
	}
 
	public void setMessage(String message) {
		this.message = message;
	}
	
	public void draw(){
		System.out.println(message);
	}
}
