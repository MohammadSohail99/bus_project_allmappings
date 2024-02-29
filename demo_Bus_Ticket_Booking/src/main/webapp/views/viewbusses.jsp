<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <meta charset="UTF-8">
    <title>Bus List Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
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

        form {
            margin-top: 20px;
            text-align: center;
        }

        input[type="submit"] {
            padding: 8px 16px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h2>Bus List Page</h2>
    <table border="1">
        <tr>
            <th>Bus ID</th>
            <th>Bus Number</th>
            <th>Bus Source</th>
            <th>Bus Destination</th>
            <th>Total Tickets</th>
            <th>View Tickets</th>
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
                    </td>
                </tr>
            </c:forEach>
        </c:if>
    </table>
    <form action="bookTicket">
        <input type="submit" value="Book Ticket">
    </form>
</body>
</html>
