<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Enter Card Details</title>
</head>
<body>
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
<h5>Enter Card Details</h5>
<form:form modelAttribute="card" method="post">
<table border="1">
<tr>
<td>Card Number</td>
<td><form:input path="number"/></td>
</tr>
<tr>
<td>Expiry Date</td>
<td><form:input type="date" path="expDate"/></td>
</tr>
<tr>
<td>cvv Number</td>
<td><form:input path="cvv"/></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="Complete Booking">
</td>
</tr>
</table>
</form:form>
</body>
</html>