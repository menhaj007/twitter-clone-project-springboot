<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tweet Page</title>
</head>
<body>
    <div class="container">
        <h2 class="heading">Post Tweet</h2>
        <div class="error">
            <span>
                <form:errors path="tweet.*" />
            </span>
            <div class="register-form">
                <form:form method="POST" action="/newtweet" modelAttribute="tweet">
                    <div class="input-fields">
                        <form:label path="name">Tweet:</form:label>
                        <form:input type="text" path="name" />
                    </div>
                    <div class="submit-button">
                        <input type="submit" value="Register" />
                    </div>
                </form:form>
            </div>
        </div>

    </div>
    
</body>
</html>

