package com.helpezee.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.helpezee.beans.Contact;

public class ContactValidator implements Validator{

	

	@Override
	public void validate(Object action, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "FirstName Required", "First Name is Manditory");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "lastname", "Last Name is Required","Last Name is Required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "Email is Required","Email is Required");
		
	}

	@Override
	public boolean supports(Class classz) {
		return Contact.class.equals(classz);
	}

}
