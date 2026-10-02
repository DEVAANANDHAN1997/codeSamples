<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Student</title>
</head><center>
<body>
<form:form method="POST" action="/crud/Editstudent"  >
<table>
<tr><td>Name</td><td><form:input path="namee" /></td></tr>${command}
<tr><td>Gender</td><td><form:radiobutton path="gender" value="Male"/>Male<form:radiobutton path="gender" value="Female"/>Female</td></tr>
<tr><td>Department</td><td><form:select path="department">
<form:option value="MBA" label="MBA" />
<form:option value="MCA" label="MCA"/>
</form:select></td></tr>

<tr>
<td>Hobby</td>
<c:forEach var="hob" items="${command.hobby}"></c:forEach>
<td>
<form:checkbox path="hobby"   value="Swimming" />Swimming
<form:checkbox path="hobby"  value="Singing"  />Singing</td></tr>



</tr>
</table><input type="submit" value="Submit" style="width:20%;"/></form:form>
</center>
<h1>${hob}</h1>

</body>
</html>