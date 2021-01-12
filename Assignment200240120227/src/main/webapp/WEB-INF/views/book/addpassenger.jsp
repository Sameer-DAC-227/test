<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Passenger Details</title>
</head>
<body>
<h4>Hello ${sessionScope.user.name}</h4>
<h5>Your selected flight details are:</h5>
<table>
<tr>
<td>Airline</td>
<td>${sessionScope.flight.airline}</td>
</tr>
<tr>
<td>From</td>
<td>${sessionScope.flight.depCity}</td>
</tr>
<tr>
<td>To</td>
<td>${sessionScope.flight.arrCity}</td>
</tr>
<tr>
<td>Dep Date</td>
<td>${sessionScope.flight.flightDate}</td>
</tr>
<tr>
<td>Dep Time</td>
<td>${sessionScope.flight.flightTime}</td>
</tr>
</table>

<h5>Enter Passenger Details</h5>
<form:form modelAttribute="passenger" method="post">
<table border="1">
<tr>
<td>Name</td>
<td><form:input path="name"/></td>
</tr>
<tr>
<td>Email</td>
<td><form:input path="email"/></td>
</tr>
<tr>
<td>Phone</td>
<td><form:input path="phone"/></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="Add Passenger">
</td>
</tr>
</table>
</form:form>
</body>
</html>