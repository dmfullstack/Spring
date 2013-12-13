package com.helpezee.beans;

public class Part
{
private String name;

public void setName(String name) {
this.name = name;
}
public String getName() {
return name;
}

public String toString()
{
	return "[Name="+name+"]";
}

public String testMethod(){
	return "I am method called by SPEL";
	
}
}