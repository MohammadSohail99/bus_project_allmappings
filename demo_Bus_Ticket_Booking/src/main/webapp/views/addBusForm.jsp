<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
            margin-top: 20px;
        }

        table {
            margin: 0 auto;
            border-collapse: collapse;
            width: 50%;
            background-color: white;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
        }

        table td {
            padding: 10px;
        }

        input[type="submit"] {
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #0056b3;
        }

        .error {
            color: red;
            font-size: 12px;
        }
    </style>
</head>
<body>
    <h2>Bus Page</h2>

    <form:form action="saveBus" modelAttribute="busModel">
        <table>
            <tr>
                <td>Bus Number </td> <td> <form:input path="busNumber"/> </td>
                <td><form:errors path="busNumber"/></td>
            </tr>
            <tr>
                <td>Source</td> <td> <form:input path="source"/> </td>
                <td><form:errors path="source" cssClass="error"/></td>
            </tr>
            <tr>
                 <td>Destination </td> <td> <form:input path="destination"/> </td>
                 <td><form:errors path="destination" cssClass="error"/></td>
            </tr>
            <tr>
                 <td>Tickets</td> <td> <form:input path="ticket"/> </td>
                 <td><form:errors path="ticket" cssClass="error"/></td>
            </tr>
            <tr>
                <td colspan="2"> <input type="submit" value="Add Bus"> </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
