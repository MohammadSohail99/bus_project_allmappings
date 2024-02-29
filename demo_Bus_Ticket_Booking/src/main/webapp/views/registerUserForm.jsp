<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <style>
        body {
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
        }

        h1 {
            text-align: center;
        }

        form {
            width: 300px;
            padding: 20px;
            border: 1px solid #ccc;
            border-radius: 5px;
            background-color: #f9f9f9;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="password"],
        input[type="email"],
        input[type="tel"] {
            width: 100%;
            padding: 8px;
            margin-bottom: 10px;
            box-sizing: border-box;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="submit"] {
            width: 100%;
            padding: 8px;
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
    <h1>User Registration Form</h1>
    <form:form action="registeruser" modelAttribute="user" >
            <label for="username">UserName:</label>
            <form:input path="username"/><br/>
            <form:errors path="username"/><br/>

            <label for="password">Password:</label>
            <form:input path="password" id="password" /><br/>
            <form:errors path="password"/><br/>

            <label for="email">Email:</label>
            <form:input path="email" id="email"/><br/>
            <form:errors path="email"/><br/>

            <label for="mobile">Mobile:</label>
            <form:input path="mobile" id="mobile"/><br/>
            <form:errors path="mobile"/><br/>

            <input type="submit" value="Register"/>
        </form:form>
</body>
</html>
