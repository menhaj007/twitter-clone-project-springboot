<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
</head>
<body>
    <div class="container">
        <h2 class="heading">Login</h2>
        <div class="login-form">
            <span class="error"><c:out value="${error}" /></span>
            <div class="form">
                <form method="POST" action="/login">
                <div class="input-fields">
                    <label for="email">Email</label>
                    <input type="email" id="email" name="email" />
                </div>
                <div class="input-fields">
                    <label for="password">Password</label>
                    <input type="password" id="password" name="password" />
                </div>
                <div class="submit-button">
                    <input type="submit" value="Login" />
                </div>
                </form>
            </div>
        </div>
        <div class="register">
            <a href="/registration">Register here</a>
        </div>
    </div>
    
</body>
</html>