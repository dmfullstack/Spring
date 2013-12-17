<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<pre>
<font color="red"><b>Binding Values</b></font>
In SimpleFormController, you need to tell Spring about how form controller will binds the value to/from the HTML form’s components. See code snippet :

public class YourController extends SimpleFormController{
		public CustomerController(){
		setCommandClass(Customer.class);
		setCommandName("customerForm");
	}

    setCommandClass(Customer.class) --> Forms values will store into this Customer object.
    setCommandName("customerForm") --> If HTML form action value with named 'customerForm' is submitted, Spring will forward request to this form controller.

<font color="red"><b>Form submission</b></font>

When HTML form is submitted, form controller’s onSubmit() method will be executed, to handle the submitted form’s value and return a ModelAndView if success. So, onSubmit() method is the ideal place to perform form submission business logic.

public class YourController extends SimpleFormController{
	
	@Override
	protected ModelAndView onSubmit(HttpServletRequest request,
		HttpServletResponse response, Object command, BindException errors)
		throws Exception {
 
		Customer customer = (Customer)command;
		System.out.println(customer);
		return new ModelAndView("CustomerSuccess","customer",customer);
	}
	
<font color="red"><b>Initialization</b></font>
In some cases, you may need to initialize the form component values before render the page, like default value for HTML form component. To do this, just override the formBackingObject() method.

public class YourController extends SimpleFormController{
	
	@Override
	protected Object formBackingObject(HttpServletRequest request)
		throws Exception {
 
		Customer cust = new Customer();
		cust.setFavFramework(new String []{"Spring MVC"});
		return cust;
	}

<font color="red"><b>Data Referencing</b></font>

Provide a list of data for HTML components, like checkbox , radio button or select options. To do this, just override the referenceData() method.

public class YourController extends SimpleFormController{
	//...
	@Override
	protected Map referenceData(HttpServletRequest request) throws Exception {
		Map referenceData = new HashMap();
		List&lt;String&gt; webFrameworkList = new ArrayList&lt;String&gt;();
		webFrameworkList.add("Spring MVC");
		webFrameworkList.add("Struts 1");
		webFrameworkList.add("Struts 2");
		referenceData.put("webFrameworkList", webFrameworkList);
		return referenceData;
	}

<font color="red"><b>SimpleFormController bean</b></font>
Finally, declares the SimpleFormController bean and override the “formView” and “successView” property value.

    formView – Indicate the form page that will shows to the user. If validation failed, the controller will return this page to the user as well.
    successView – If the form is submitted successful, return this page to the user.

With below InternalResourceViewResolver declared :

	&lt;bean class="com.mkyong.customer.controller.CustomerController"&gt;
		&lt;property name="formView" value="CustomerForm" /&gt;
		&lt;property name="successView" value="CustomerSuccess" /&gt;
	&lt;/bean&gt;
 
	&lt;bean id="viewResolver"
             class="org.springframework.web.servlet.view.InternalResourceViewResolver" &gt;
             &lt;property name="prefix"&gt;
                 &lt;value&gt;/WEB-INF/pages/&lt;/value&gt;
             &lt;/property&gt;
             &lt;property name="suffix"&gt;
                 &lt;value&gt;.jsp&lt;/value&gt;
             &lt;/property&gt;
       &lt;/bean&gt;

<font color="red"><b>Form Validator</b></font>

A form validator class to do the empty checking on the HTML components. If validation failed, get the error message from resource bundle, and associate it with the corresponds error field.
Note
In form views, you can use the &lt;form:errors /&gt; to renders and format the error message that is associated with the field.

package com.mkyong.customer.validator;
 
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.mkyong.customer.model.Customer;
 
public class CustomerValidator implements Validator{
 
	@Override
	public boolean supports(Class clazz) {
		//just validate the Customer instances
		return Customer.class.isAssignableFrom(clazz);
	}
 
	@Override
	public void validate(Object target, Errors errors) {
 
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userName",
			"required.userName", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address",
			"required.address", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password",
			"required.password", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword",
			"required.confirmPassword", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "sex", 
			"required.sex", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "favNumber", 
			"required.favNumber", "Field name is required.");
		ValidationUtils.rejectIfEmptyOrWhitespace(
			errors, "javaSkills", "required.javaSkills","Field name is required.");
 
		Customer cust = (Customer)target;
 
		if(!(cust.getPassword().equals(cust.getConfirmPassword()))){
			errors.rejectValue("password", "notmatch.password");
		}
		if(cust.getFavFramework().length==0){
			errors.rejectValue("favFramework", "required.favFrameworks");
		}
		if("NONE".equals(cust.getCountry())){
			errors.rejectValue("country", "required.country");
		}
	}
}

A properties file to store all the error messages.

File : Customer.properties

required.userName = Username is required!
required.address = Address is required!
required.password = Password is required!
required.confirmPassword = Confirm password is required!
required.favFrameworks = Please select at least a web frameworks!
required.sex = Please select a sex!
required.favNumber = Please select a number!
notmatch.password = Password and Conform password is not match!

  &lt;bean class="com.mkyong.customer.controller.CustomerController"&gt;
	&lt;property name="formView" value="CustomerForm" /&gt;
	&lt;property name="successView" value="CustomerSuccess" /&gt;
 
	******** Map a validator *******
	&lt;property name="validator"&gt;
		&lt;bean class="com.mkyong.customer.validator.CustomerValidator" /&gt;
	&lt;/property&gt;
  &lt;/bean&gt;
 
  ****** Register the Customer.properties *****
  &lt;bean id="messageSource"
	class="org.springframework.context.support.ResourceBundleMessageSource"&gt;
	&lt;property name="basename" value="com/mkyong/customer/properties/Customer" /&gt;
  &lt;/bean&gt;
  
<font color="red"><b>View</b></font>
This is the "formView", render the HTML components with Spring’s form tags, display and highlight the error message if any.
</pre>
</body>
</html>