<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
    
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link  href="<c:url value='/static/css/bootstrap.min.css'/>" rel="stylesheet"/>
<link  href="<c:url value='/static/css/style.css'/>" rel="stylesheet"/>
</head>
<body>
<center><h2>Employees List</h2></center>
<table class="table table-dark">
<tr><td>EmpNo</td> <td>EmpName</td> <td>Job</td> <td>Salary</td><td>Option</td> </tr>
<c:forEach var="emp" items="${empList}">
<tr><td>${emp.empno}</td> <td>${emp.ename}</td> <td>${emp.job}</td> <td>${emp.salary}</td><td><a href="deleteemp/${emp.empno}">Edit</a></td> </tr>
</c:forEach>
</table>
</body>
</html>