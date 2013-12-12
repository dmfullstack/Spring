package com.helpezee.beans;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.Collection;

public class CollectionsClass {
	
	public List getEnrolledCourses() {
		return enrolledCourses;
	}

	public void setEnrolledCourses(List enrolledCourses) {
		this.enrolledCourses = enrolledCourses;
	}

	public Set getEnrolledActivities() {
		return enrolledActivities;
	}

	public void setEnrolledActivities(Set enrolledActivities) {
		this.enrolledActivities = enrolledActivities;
	}

	public Map getStudentInfoMap() {
		return studentInfoMap;
	}

	public void setStudentInfoMap(Map studentInfoMap) {
		this.studentInfoMap = studentInfoMap;
	}

	public Properties getEmailProps() {
		return emailProps;
	}

	public void setEmailProps(Properties emailProps) {
		this.emailProps = emailProps;
	}

	public List enrolledCourses;  
	  
    public Set enrolledActivities;  
  
    public Map studentInfoMap;  
  
    public Properties emailProps; 
    
    public List<Object> objectList;

	public List<Object> getObjectList() {
		return objectList;
	}

	public void setObjectList(List<Object> objectList) {
		this.objectList = objectList;
	}
}
