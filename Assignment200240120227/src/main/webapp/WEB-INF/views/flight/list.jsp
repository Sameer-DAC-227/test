<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight List Page</title>
</head>
<body>
<h5>Flight List Page</h5>
<table border="1">
<tr>
<td>Airline</td>
<td>Departure City</td>
<td>Arrival City</td>
<td>Departure Time</td>
<td>&nbsp;</td>
</tr>
<c:forEach var="flight" items="${requestScope.flights}">
<tr>
<td>${flight.airline}</td>
<td>${flight.depCity}</td>
<td>${flight.arrCity}</td>
<td>${flight.flightTime}</td>
<td><a href="/booking/book?fid=${flight.id}">Select</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>