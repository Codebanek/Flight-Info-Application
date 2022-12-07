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
<form:form method="post" modelAttribute="user">
    Podaj nazwe użytkownika:
    <form:input path="username"/><br><br>
    Podaj hasło:
    <form:password path="password"/><br><br>

        Podaj imię:
        <form:input path="firstName"/><br><br>
        Podaj nazwisko:
        <form:input path="lastName"/><br><br>
        Podaj email kontaktowy:
        <form:input path="email"/><br><br>
    <input type="submit" value="Zapisz"/>
</form:form>
</body>
</html>
