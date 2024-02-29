<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Book Ticket</title>
</head>
<body>
    <h1>Book Ticket</h1>
    <form action="bookticket">
        <label for="busNumber">Bus Number:</label>
        <input type"number" name="busNumber" id="busNumber" value="${busNumber}">
        <label for="ticket">Available Tickets:</label>
        <input type"number" name="ticket" id="ticket" value="${ticket}">
        <label for="numberOfTickets">Number of Tickets to book:</label>
        <input type"number" name="numberOfTickets" id="numberOfTickets">
        <input type="submit" value="Book Ticket">
    </form>
</body>
</html>

