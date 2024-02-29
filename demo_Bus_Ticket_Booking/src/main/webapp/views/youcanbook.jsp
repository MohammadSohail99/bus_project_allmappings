<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Booking Success</title>
</head>
<body>
    <h1>Ticket Booking Successful</h1>
    <p>Your ticket has been booked successfully.</p>
   <form:form action="display">
    <p>Details:</p>
    <ul>
        <li>Bus Number: ${param.busNumber}</li>
        <li>Tickets:${param.numberOfTickets}
        </li>
    </ul>
   <form:form>
   <form action="viewbusses">
           <input type="submit" value="Back">
       </form>
</body>
</html>

