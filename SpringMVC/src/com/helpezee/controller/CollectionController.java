package com.helpezee.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import com.helpezee.beans.CollectionsClass;

public class CollectionController extends AbstractController {

	private CollectionsClass  collectionsPojo;
	
	public CollectionsClass getCollectionsPojo() {
		return collectionsPojo;
	}

	public void setCollectionsPojo(CollectionsClass collectionsPojo) {
		this.collectionsPojo = collectionsPojo;
	}

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest arg0,
			HttpServletResponse arg1) throws Exception {
		
		System.out.println("enrolledCourses----"+collectionsPojo.getEnrolledCourses());
		System.out.println("Enrolled Activities----"+collectionsPojo.getEnrolledActivities());
		System.out.println("StudentMap----"+collectionsPojo.getStudentInfoMap());
		System.out.println("Email Details----"+collectionsPojo.getEmailProps());
		System.out.println("Object1 in List"+collectionsPojo.getObjectList().get(0).toString());
		System.out.println("Object2 in List"+collectionsPojo.getObjectList().get(1).toString());
		return new ModelAndView("CollectionWiring","collectionsPojo",collectionsPojo);
	}

	


}
