package com.helpezee.beans;

public class Student {
	 
    private String name;
    private Integer marks;
     
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getMarks() {
        return marks;
    }
    public void setMarks(Integer marks) {
        this.marks = marks;
    }
     
    @Override
    public String toString() {
        return "Student [name=" + name + ", marks=" + marks + "]";
    }
     
}