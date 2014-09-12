<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>



<title>REGISTER HERE</title>
<script type="text/javascript">

function UpdateCost() {
	  var sum = 0;
	  var gn, elem;
	  for (i=0; i<10; i++) {
	    gn = 'test'+i;
	    elem = document.getElementById(gn);
	    if (elem.checked == true) { sum += Number(elem.value); }
	  }
	  document.getElementById('totalcost').value = sum.toFixed(2);
	} 
function validateUser()
{
	var user;
	var luser;
	var phoneno;
	var comments;
	
	user = AppForm.firstname.value;
	luser = AppForm.lastname.value;
	phoneno=AppForm.phonenumber.value;
	comments=AppForm.comments.value;
	
	if (user=="") {
		alert("First Name Must Be Provided..");
		AppForm.firstname.focus();
		return false;
	}
	if(user.length>20)
		{
		alert("First name characters should be less than twenty ");
		AppForm.firstname.focus();
		return false;
		}
	var patt = /[0-9)#$%^&*(}{|,.;:~`<>'\"[*+-_]$/; 
	if(patt.test(user))
	{
	alert("First name special characters not allowed ");
	AppForm.firstname.focus();
	return false;
	}
	if (luser=="") {
		alert(" Last Name Must Be Provided..");
		AppForm.lastname.focus();
		return false;
	}
	if(luser.length>15)
		{
		alert(" Lastname characters should be less than fifteen ");
		AppForm.lastname.focus();
		return false;
		}
	var patt = /[0-9)#$%^&*(}{|,.;:~`<>'\"[*+-_]$/; 
	if(patt.test(luser))
	{
	alert("Last name special characters not allowed ");
	AppForm.lastname.focus();
	return false;
	}
	if(phoneno.length>10)
	{
	alert("  Phone Number should not exceed ten digits ");
	AppForm.phoneno.focus();
	return false;
	}
	
	
	if (phoneno.charAt(0)!=9 && phoneno.charAt(0)!=8 && phoneno.charAt(0)!=7  )
		{
		alert("phone number should start with 9 or 8 or 7");
		return false;
		}

	
	var number=/^(0-9)+$/;
	if(!(number.test(phoneno)))
		{
		alert("only numbers are allowed");
		AppForm.phoneno.focus();
		return false;
		}
	
	/*var patt = /[a-zA-Z)#$%^&*(}{|,.;:~`<>'\"[*+-_]$/; 
	if(patt.test(phoneno))
	{
	alert("Phone number  special characters not allowed ");
	AppForm.phoneno.focus();
	return false;
	}*/
	if (comments=="") {
		alert("Comments Must Be Provided..");
		AppForm.comments.focus();
		return false;
	}
	
	
	else{
	return true;
}
	}	





</script>
<script type="text/javascript">
 function noBack(){
	 window.history.forward();
	 } 
</script>
</head>

<body bgcolor ="#3399CC" onload="javascript:noBack()">

			
			
		
			
			
		
		
		

</body>
</html>