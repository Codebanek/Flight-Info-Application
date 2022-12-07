<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 24/11/2022
  Time: 22:16
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>FLIGHT-INFO</title>
</head>
<body>
<jsp:include page="fragments/user-header.jsp"></jsp:include>

<form:form method="post" modelAttribute="flightDetails">

    Podaj typ samolotu:
    <form:select path="type">
        <form:option value="0">Wybierz samolot</form:option>
        <form:options items="${planes}" itemValue="type" itemLabel="type"/>
    </form:select><br>
    Podaj prędkość przelotową w węzłąch:
    <form:input path="speed"/><br>

    Lotnisko startu
    <form:select path="departure_code">
    <form:option value="0">Wybierz lotnisko</form:option>
    <form:options items="${airports}" itemValue="icaoCode" itemLabel="icaoCode"/>
    </form:select>
<br>
    Lotnisko lądowania:
    <form:select path="arrival_code">
        <form:option value="0">Wybierz lotnisko</form:option>
        <form:options items="${airports}" itemValue="icaoCode" itemLabel="icaoCode"/>
    </form:select>
    <br>

    <label><input type="submit" value="  Lecimy!  "></label>
</form:form>

</body>
</html>
