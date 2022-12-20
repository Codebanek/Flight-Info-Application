<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 21/11/2022
  Time: 23:27
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User-Form</title>
</head>
<body>
<jsp:include page="fragments/welcomePage-header.jsp"></jsp:include>
</br>
<div style="text-align: center; class=center">
<form:form method="post" modelAttribute="user">
    Username:
    <form:input path="username"/>
    <form:errors path="username"/><br><br>
    Password:
    <form:password path="password"/>
    <form:errors path="password"/><br><br>

        Name:
        <form:input path="firstName"/>
    <form:errors path="firstName"/><br><br>
        Lastname:
        <form:input path="lastName"/>
    <form:errors path="lastName"/><br><br>
        Email address:
        <form:input path="email"/>
    <form:errors path="email"/><br><br>
    <input type="submit" value="Save"/>
</form:form>
</div>
</body>
</html>
