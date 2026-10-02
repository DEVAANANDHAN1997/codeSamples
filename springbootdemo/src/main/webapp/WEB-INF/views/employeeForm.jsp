<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Form</title>
</head>
<body>
<h3>Employee Form</h3>
<form:form action="addEmployee" modelAttribute="emp">
<table>
<tr><td>Employee Number</td><td><form:input path="empno"/></td></tr>
<tr><td>Employee Name</td><td><form:input path="ename"/></td></tr>
<tr><td>Job</td><td><form:input path="job"/></td></tr>
<tr><td>Salary</td><td><form:input path="salary"/></td></tr>
<tr><td colspan="2"> <input type="submit" value="Save"/></td></tr>
</table>
</form:form>
</body>
</html>