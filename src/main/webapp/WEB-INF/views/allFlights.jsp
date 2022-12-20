<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 07/12/2022
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><html>
<head>
    <title>User Plans</title>
</head>
<body>
<jsp:include page="fragments/admin-header.jsp"></jsp:include>

<table class="table border-bottom schedules-content">
    <thead>
    <tr class="d-flex text-color-darker">
        <th scope="col" class="col-1">ID</th>
        <th scope="col" class="col-1">TYPE</th>
        <th scope="col" class="col-1">DEPARTURE</th>
        <th scope="col" class="col-1">DESTINATION</th>
        <th scope="col" class="col-1">DISTANCE (KM)</th>
        <th scope="col" class="col-1">SPEED</th>
        <th scope="col" class="col-1">FLIGHT TIME (MIN)</th>
        <th scope="col" class="col-1">CREATED BY</th>
        <th scope="col" class="col-1 center">ACTIONS</th>
    </tr>
    </thead>
    <tbody class="text-color-lighter">
    <c:forEach items="${flights}" var="flight">
        <tr class="d-flex">
            <th scope="row" class="col-1">${flight.id}</th>
            <td class="col-1">${flight.type}</td>
            <td class="col-1">${flight.departure_code}</td>
            <td class="col-1">${flight.arrival_code}</td>
            <td class="col-1">${flight.distance}</td>
            <td class="col-1">${flight.speed}</td>
            <td class="col-1">${flight.flight_time}</td>
            <td class="col-1">${flight.user.username}</td>
            <td class="col-1 center d-flex align-items-center justify-content-center flex-wrap">
                <label onclick="return confirm('Are you sure you want to remove this?')">
                    <a href="<c:url value="/admin/removeflight/${flight.id}"/>" class="btn btn-danger rounded-0 text-light m-1">REMOVE</a>
                </label>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>

</body>
</html>
