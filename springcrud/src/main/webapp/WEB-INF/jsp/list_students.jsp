<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table border="1">
<tr><td>Name</td><td>Gender</td><td>Department</td><td>Hobby</td><td>Delete</td><td>Edit</td></tr>
<c:forEach var="stu_list" items="${student_list}">
<tr>
<td>${stu_list.namee}</td>
<td>${stu_list.gender}</td>
<td>${stu_list.department}</td>
<td>${stu_list.hobby}</td>
<td><a href="deletestudent/${stu_list.namee}">Delete</a></td>
<td><a href="updatestudent/${stu_list.namee}">Edit</a></td>
</tr>
</c:forEach></table>
</body>
</html>