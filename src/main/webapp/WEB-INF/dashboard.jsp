<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Dashboard</title>
</head>
<body>
    <div class="container">
        <h2>Welcome, <c:out value="${loggedUser.firstName}" /></h2>
        <div class="user-tweets">
            <c:forEach items="${userTweets}" var="tweet">
                <div class="users-tweet">
                    <c:out value="${tweet.name}" />
                </div>
            </c:forEach>
        </div>
        <div class="new-tweet">
            <a href="/newtweet">New Tweet</a>
        </div>
        <div class="logout">
            <a href="/logout">Logout</a>
        </div>
    </div>
    
</body>
</html>