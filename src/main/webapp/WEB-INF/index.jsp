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
        <h2 class="heading">Welcome to Twitter</h2>
        <c:forEach items="${allTweets}" var="tweet">
            <div class="tweet-line">
                <c:out value="${tweet.name}"/>
            </div>
        </c:forEach>

        <div class="login">
            <a href="/login">Login</a>
        </div>
        <div class="register">
            <a href="/registration">Registration</a>
        </div>
        <div class="home">
            <a href="/home">Home</a>
        </div>
    </div>
    
</body>
</html>