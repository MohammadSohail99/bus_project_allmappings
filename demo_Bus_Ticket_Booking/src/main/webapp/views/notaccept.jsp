<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Result</title>
</head>
<body>
    <h1>Login Result</h1>
    <% if (request.getAttribute("loginFailed") != null && (boolean) request.getAttribute("loginFailed")) { %>
        <p>Either username or password is incorrect. Please try again.</p>
    <% } else { %>
        <p>Login successful!</p>
    <% } %>
    <br>
    <br>
    <a href="/login">Login</a>
</body>
</html>
