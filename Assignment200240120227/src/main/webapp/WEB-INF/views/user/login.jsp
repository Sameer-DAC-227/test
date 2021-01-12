<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Sign-Up Page</title>
</head>
<body>
<h5>User Sign-Up Page</h5>
<h5>${requestScope.message}</h5>
<form method="post">
<table>
<tr>
<td>Email</td>
<td><input type="text" name="email"/></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="Login">
</td>
</tr>
</table>
</form>
</body>
</html>