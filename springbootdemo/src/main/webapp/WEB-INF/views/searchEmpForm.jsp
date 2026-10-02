<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link  href="<c:url value='/static/css/bootstrap.min.css'/>" rel="stylesheet"></link>
<link  href="<c:url value='/static/css/style.css'/>" rel="stylesheet"></link>

<script src="<c:url value='/static/javascript/jquery-3.5.1.min.js'/>"></script>
<script src="<c:url value='/static/javascript/myscript.js'/>"></script>
</head>   
<body>
	<h2> Employee Form</h2>
	<form:form action="updateEmp" method="post" modelAttribute="emp">
	  	<table class="table table-striped ">
	  	<tr><td>Empno </td><td><form:input path="empno" id="empno"/><input type="button" id="searchEmpBut" value="Search Employee"/><span id="empnoMsg"></span></td></tr>
	    <tr><td>Empname </td><td><form:input path="ename" id="ename"/></td></tr>
	    <tr><td>Job </td><td><form:input path="job" id="job"/></td></tr>
	    <tr><td>Salary </td><td><form:input path="salary" id="salary"/></td></tr>
	    <tr><td colspan="2"> <input type="submit" value="Update Employee"/></td></tr>
  </table>
  </form:form>
</body>
</html>

