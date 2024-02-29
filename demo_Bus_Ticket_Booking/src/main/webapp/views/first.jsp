<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome to Bus Ticket Booking</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f4;
        }

        h1 {
            text-align: center;
            margin-top: 20px;
        }

        h2 {
            margin-top: 30px;
            margin-bottom: 10px;
        }

        a {
            display: block;
            text-align: center;
            padding: 10px 20px;
            margin: 10px auto;
            width: 200px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border-radius: 5px;
        }

        a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1>Welcome to Bus Ticket Booking</h1>
    <h2>Add Bus</h2>
    <a href="/addBus">Add Bus</a>
    <h2>View All Buses</h2>
    <a href="/viewBusses">View All Buses</a>
</body>
</html>
