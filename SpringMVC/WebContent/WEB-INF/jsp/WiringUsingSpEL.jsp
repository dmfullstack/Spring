<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<pre>
Very good Concepts,Go through the Bean configuration for getting Idea.
Expained in  short words

List : ${products.parts}
thirdStudentInList: ${products.thirdStudentInList}
failedStudents: ${products.failedStudents}
studentNames: ${products.studentNames}


Note:
 
 
 
 Null check
 ============
 ?. --- Null value check
 
 
 

Selecting collection members
============================
 
 .?[]--- selection operator, creates a new collection  after filtering as per defined inside [] ex: studentList.?[marks lt 40]
 .^[] --- for selecting the first items of the collection ex :  studentList.^[marks lt 40]
 .$[] --- for selecting the last items of the collection ex :studentList.$[marks lt 40]
 
 
 
 
 Projecting Collections
 ======================
 .![] --- collection projection involves collecting particular property from each of the members of the collection into a new collection 
 
    ex: studentList.![name]
        studentList.![name+','+ marks] 
        
        
        
        
  Join of both selection and projection
  =====================================
  studentList.?[marks lt 40].![name] -- gives the student names whose marks  are less than 40
  

</pre>
</body>
</html>