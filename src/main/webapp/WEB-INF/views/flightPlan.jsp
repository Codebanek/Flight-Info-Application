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
</br>
<div style="text-align: center;">
<form:form method="post" modelAttribute="flightDetailsDTO">

    Aircraft type:
    <form:select path="type">
        <form:option value="0">Choose</form:option>
        <form:options items="${planes}" itemValue="type" itemLabel="type"/>
    </form:select>
    <form:errors path="type"/><br><br>


    Speed - IAS (KTS)
    <form:input path="speed"/>
    <form:errors path="speed"/>
    <br><br>

    Departure
    <form:select path="departure_code">
    <form:option value="0">Choose</form:option>
    <form:options items="${airports}" itemValue="icaoCode" itemLabel="icaoCode"/>
    </form:select>
    <form:errors path="departure_code"/>
    <br><br>
    Target
    <form:select path="arrival_code">
        <form:option value="0">Choose</form:option>
        <form:options items="${airports}" itemValue="icaoCode" itemLabel="icaoCode"/>
    </form:select>
    <form:errors path="arrival_code"/>
    <br><br>

    <label><input type="submit" value="  Calculate  "></label>
</form:form>
</div>
</body>
</html>
