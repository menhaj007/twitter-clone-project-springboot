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
    <title>Registration Page</title>
</head>
<body>
    <div class="container">
        <h2 class="heading">Register</h2>
        <div class="error">
            <span>
                <form:errors path="user.*" />
            </span>
            <div class="register-form">
                <form:form method="POST" action="/registration" modelAttribute="user">
                    <div class="input-fields">
                        <form:label path="firstName">First Name:</form:label>
                        <form:input type="firstName" path="firstName" />
                    </div>
                    <div class="input-fields">
                        <form:label path="lastName">Last Name:</form:label>
                        <form:input type="lastName" path="lastName" />
                    </div>
                    
                    <div class="input-fields">
                        <form:label path="email">Email:</form:label>
                        <form:input type="email" path="email" />
                    </div>
                    <div class="input-fields">
                        <form:label path="password">password:</form:label>
                        <form:password path="password" />
                    </div>
                    <div class="input-fields">
                        <form:label path="passwordConfirmation">Password Confirmation:</form:label>
                        <form:password path="passwordConfirmation"/>
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

