<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        .container {
            display: flex;
            justify-content: space-around;
            margin-top: 50px;
        }

        .panel {
            width: 45%;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .panel h1 {
            font-size: 24px;
            margin-bottom: 10px;
            text-align:center;
        }

        .panel h2 {
            font-size: 20px;
            margin-bottom: 10px;
            text-align:center;
        }

        .panel p {
            margin-bottom: 5px;
        }

        .panel a {
            display: block;
            margin-top: 10px;
            text-decoration: none;
            background-color: #007bff;
            color: #fff;
            padding: 5px 10px;
            border-radius: 3px;
            width: fit-content;
        }

        .panel a:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
    <h1 style="text-align:center;">Welcome to Bus Ticket Booking</h1>
    <div class="container">
        <div class="panel">

            <h2>Admin Panel</h2>
            <p>Please Register If you are a New Admin</p>
            <a href="/register">Register</a>
            <p>Login if Already Registered Admin</p>
            <a href="/login">Login</a>
        </div>
        <div class="panel">
            <h1>User Panel</h1>
            <p>Please Register If you are a New User</p>
            <a href="/registeruser">Register</a>
            <p>Login if Already Registered User</p>
            <a href="/loginuser">Login</a>
        </div>
    </div>
</body>
</html>
