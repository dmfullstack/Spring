<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="saveEmployee.htm" method="post">

		<table>

			<tr>
				<td>Employee Name</td>
				<td><input type="text" name="empName" /></td>
			</tr>

			<tr>
				<td>Salary</td>
				<td><input type="text" name="salary" /></td>
			</tr>


			<tr>
				<td>Address</td>
				<td><textarea rows="5" cols="10" name="addr"></textarea></td>
			</tr>


			<tr>
				<th colspan="2"><input type="submit" value="Save" />
				 <input	type="reset" value="Clear All" />
				</th>

			</tr>

		</table>

	</form>



</body>
</html>