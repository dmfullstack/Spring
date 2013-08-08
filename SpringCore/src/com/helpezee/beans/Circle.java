package com.helpezee.beans;

public class Circle {
private String  type;
private int height;

public Circle(String type,int height)
{
	
	this.type=type;
	this.height=height;
	System.out.println("construction1");
}

public Circle(String type)
{
	System.out.println("construction0");
	this.type=type;
	
}
public Circle(int height)
{
	System.out.println("construction1");
	this.height=height;
	
}
public Circle(int height,String type)
{
	System.out.println("construction2");
	this.type=type;
	this.height=height;
}

public String getType() {
	return type;
}

public int getHeight() {
	return height;
}

public void draw()
{
System.out.println(getType()+"-----"+getHeight());	
}

}
