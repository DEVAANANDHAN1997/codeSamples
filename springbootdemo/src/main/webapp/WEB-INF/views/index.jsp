<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link href="<c:url value='/static/css/bootstrap.min.css'/>" rel='stylesheet'/>
<link href="<c:url value='/static/css/style.css'></c:url>" rel="stylesheet"/>
</head>
<body>

<center>
<!-- <img alt=""  src="<c:url value='/static/images/springmvc.png'/>"/ style="height: 25%;width: 25%;"> -->
<h2>Welcome to Spring Boot Tutorial  <span style="color: green;"> ${user }</span></h2> 
<a style="color: red;float: right;" href="logout" >Logout </a>

 
<table>
<tr><td><a href="employeeForm">Add Employee</a></br></td></tr>
<tr><td><a href="searchEmpForm">Search Employee</a></td></br></tr>
<tr><td><a href="listEmps">List Employees</a></td></tr>
</table></center>
</body>
</html>
