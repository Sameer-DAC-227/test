<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Completion Page</title>
</head>
<body>

<h5>Your booking ID ${requestScope.booking.id} - is completed and flight details are:</h5>
<br>
<table>
<tr>
<td>Airline</td>
<td>${requestScope.booking.flightId.airline}</td>
</tr>
<tr>
<td>From</td>
<td>${requestScope.booking.flightId.depCity}</td>
</tr>
<tr>
<td>To</td>
<td>${requestScope.booking.flightId.arrCity}</td>
</tr>
<tr>
<td>Dep Date</td>
<td>${requestScope.booking.flightId.flightDate}</td>
</tr>
<tr>
<td>Dep Time</td>
<td>${requestScope.booking.flightId.flightTime}</td>
</tr>
</table>
<br>
<h5>You have been logged out</h5>
<br>
<h5><a href="/user/login">Click here to login again</a></h5>
</body>
</html>