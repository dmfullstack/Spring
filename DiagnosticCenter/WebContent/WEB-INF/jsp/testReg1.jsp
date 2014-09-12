<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.reason {
	visibility: hidden;
}
</style>
<script type="text/javascript">
	function getSubTests() {

		var testId=document.getElementById("testId").value;
		
		if(testId=="-"){
			alert("Select One Test");
			return;
		}
		document.forms[0].action = "loadSubTests.htm?msg=abc";
		document.forms[0].submit();

	}

	function getSubTestsTotal() {

		document.forms[0].action = "loadSubTests.htm?msg=subTest";
		document.forms[0].submit();

	}

	function reason(s1) {

		//var s1 = document.getElementById("status").value;
		if (s1 == "Yes") {
			document.getElementById('urjency').style.visibility = 'visible';
		}

		if (s1 == "No") {
			document.getElementById('urjency').style.visibility = 'hidden';
		}
	}
</script>

</head>
<body>

	<form:form action="registerTest.htm" commandName="test">
	
First Name<form:input path="firstName" />
		<br>
Last Name:	<form:input path="lastName" />
		<br>

 

Gender: <form:radiobutton path="gender" value="Male" label="Male" />
		<form:radiobutton path="gender" value="Female" label="Female" />
		<br />
Select Age:<form:select path="age" items="${ageRange}"></form:select>
		<br>		
Mobile No: <form:input path="mobileNo" />
		<br>
		
Test to be Done: <form:select path="testId" id="testId"
			onchange="javascript:getSubTests()">
			<form:option value="-" label="--Select Test--" />
			<form:options items="${tests}"/>
		</form:select>
		<br>
Sub tests: <form:checkboxes items="${subTests}" path="subTestId"
			onclick="getSubTestsTotal()" />
		<br>				
Referred Doctor  <form:input path="ReferredDoctor" maxlength="30" />
		<br>
Sample Collected By: <form:select path="sampleDoctorId" items="${doctors}"></form:select>
		<br>
Sample Verified By: <form:select path="verifiedDoctorId"
			items="${doctors}"></form:select>
		<br>


Reports required immediately: <form:radiobutton path="status"
			value="Yes" label="Yes" id="status" onclick="reason('Yes')" />
		<form:radiobutton path="status" value="No" label="No" id="status"
			onclick="reason('No')" />
		<br />
		<span class="reason" id="urjency"> Reason for Urgency: <form:input
				path="urgencyReason" maxlength="20" size="20" />
		</span>
		<br>
		
Amount: <form:input path="amount" readonly="true" />
		<br>		
		
		
Comments: <form:textarea path="comments" />
		<br>

		<input type="submit" value="Submit">
		<input type="reset" value="Reset All">


	</form:form>

</body>
</html>