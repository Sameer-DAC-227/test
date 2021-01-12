<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Search Page</title>
</head>
<body>
<h5>Flight Search Page</h5>
<br>
<h5>${requestScope.message}</h5>
<form method="post">
<table>
<tr>
<td>From</td>
<td><input type="text" name="depCity"/></td>
</tr>
<tr>
<td>To</td>
<td><input type="text" name="arrivCity"/></td>
</tr>
<tr>
<td>Date</td>
<td><input type="date" name="flightDate"/></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="Search">
</td>
</tr>
</table>
</form>

</body>
</html>