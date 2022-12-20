<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 15/12/2022
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %><html>
<head>
    <title>All Users in DB</title>
</head>
<body>
<jsp:include page="fragments/admin-header.jsp"></jsp:include>
<table class="table border-bottom schedules-content">
    <thead>
    <tr class="d-flex text-color-darker">
        <th scope="col" class="col-1">ID</th>
        <th scope="col" class="col-2">USERNAME</th>
        <th scope="col" class="col-2">FIRSTNAME</th>
        <th scope="col" class="col-2">LASTNAME</th>
        <th scope="col" class="col-2">EMAIL</th>
        <th scope="col" class="col-1">ROLE</th>
        <th scope="col" class="col-2 center">ACTIONS</th>
    </tr>
    </thead>
    <tbody class="text-color-lighter">
    <c:forEach items="${users}" var="user">
        <tr class="d-flex">
            <th scope="row" class="col-1">${user.id}</th>
            <td class="col-2">${user.username}</td>
            <td class="col-2">${user.firstName}</td>
            <td class="col-2">${user.lastName}</td>
            <td class="col-2">${user.email}</td>
            <td class="col-1">${user.roles}</td>
            <td class="col-2 d-flex align-items-center justify-content-center flex-wrap">
               <c:choose>
                <c:when test = "${user.id != adminId}">
                    <label onclick="return confirm('Are you sure you want to remove this?')">
                        <a href="<c:url value="/admin/removeuser/${user.id}"/>" class="btn btn-danger rounded-0 text-light m-1">REMOVE</a>
                    </label>
                </c:when>
               </c:choose>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
