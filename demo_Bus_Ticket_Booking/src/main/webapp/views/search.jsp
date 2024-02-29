<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Search Bus</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }
        h2 {
            text-align: center;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
        tr:hover {
            background-color: #f1f1f1;
        }
        a {
            text-decoration: none;
            color: #007bff;
        }
    </style>
</head>
<body>
    <h2>Search Bus</h2>
    <table>
        <tr>
            <th>Bus ID</th>
            <th>Bus Number</th>
            <th>Bus Source</th>
            <th>Bus Destination</th>
            <th>Total Tickets</th>
            <th>Action</th>
        </tr>
        <c:if test="${!empty busList}">
            <c:forEach items="${busList}" var="busModel">
                <tr>
                    <td><c:out value="${busModel.getId()}"/></td>
                    <td><c:out value="${busModel.getBusNumber()}"/></td>
                    <td><c:out value="${busModel.getSource()}"/></td>
                    <td><c:out value="${busModel.getDestination()}"/></td>
                    <td><c:out value="${busModel.getTicket()}"/></td>
                    <td>
                        <a href="viewTickets?busNumber=${busModel.getBusNumber()}">View Tickets</a>
                        <a href="bookTicket?busNumber=${busModel.getBusNumber()}&ticket=${busModel.getTicket()}">Book Ticket</a>
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
</body>
</html>
