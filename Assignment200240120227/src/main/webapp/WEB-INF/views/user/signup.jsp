<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Sign-Up Page</title>
</head>
<body>
<h5>User Sign-Up Page</h5>
<form:form modelAttribute="user" method="post">
<table>
<tr>
<td>Name</td>
<td><form:input path="name"/></td>
</tr>
<tr>
<td>Email</td>
<td><form:input path="email"/></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="Save User">
</td>
</tr>
</table>
</form:form>
</body>
</html>