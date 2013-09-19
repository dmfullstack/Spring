<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Document Manager </title>
</head>
<body>
 
<h2>Document Manager</h2>
 
<h3>Add new document</h3>
<form:form method="post" action="docsave.html"  modelAttribute="document" enctype="multipart/form-data" >
    <form:errors path="*" cssClass="error"/>
    <table>
    <tr>
        <td><form:label path="name">Name</form:label></td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td><form:label path="description">Description</form:label></td>
        <td><form:textarea path="description" /></td>
    </tr>
    <tr>
        <td><form:label path="content">Document</form:label></td>
        <td><input type="file" name="file" id="file"></input></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Add Document" />
        </td>
    </tr>
</table> 
</form:form>
 
<br/>
<h3>Document List</h3>
<c:if  test="${!empty documentList}">
<table class="data" border="1">
<tr>
    <th>Name</th>
    <th>Description</th>
    <th>&nbsp;</th>
</tr>
<c:forEach items="${documentList}" var="document">
    <tr>
        <td width="100px" align="center">${document.name}</td>
        <td width="250px" align="center">${document.description}</td>
        <td width="100px" align="center">
            <a href="${pageContext.request.contextPath}/docdownload.html?documentId=${document.id}"><img
                src="${pageContext.request.contextPath}/images/docsave.png"  width="20px" height="20px" border="0"
                title="Download this document"/></a>
         
            <a href="${pageContext.request.contextPath}/docremove.html?documentId=${document.id}"
                onclick="return confirm('Are you sure you want to delete this document?')"><img
                src="${pageContext.request.contextPath}/images/docdelete.png" width="20px" height="20px" border="0"
                title="Delete this document"/></a>
        </td>
    </tr>
</c:forEach>
</table>
</c:if>
</body>
</html>