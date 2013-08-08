package com.helpezee.beans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import java.util.Properties;

public class Collections {

private List<String> nameList;
private Set<String>  classSet;
private Map<String,String> subjectMap;
private Properties noneProp;
public List<String> getNameList() {
	return nameList;
}
public void setNameList(List<String> nameList) {
	this.nameList = nameList;
}
public Set<String> getClassSet() {
	return classSet;
}
public void setClassSet(Set<String> classSet) {
	this.classSet = classSet;
}
public Map<String, String> getSubjectMap() {
	return subjectMap;
}
public void setSubjectMap(Map<String, String> subjectMap) {
	this.subjectMap = subjectMap;
}
public Properties getNoneProp() {
	return noneProp;
}
public void setNoneProp(Properties noneProp) {
	this.noneProp = noneProp;
}

public void displayList(){
	System.out.println(nameList);
}
public void displaySet(){
	System.out.println(classSet);
}
public void displayMap(){
	System.out.println(subjectMap);
}
public void displayProp(){
	System.out.println(noneProp);
}


}
