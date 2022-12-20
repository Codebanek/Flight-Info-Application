<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 07/12/2022
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %><html>
<head>
    <title>User Details</title>
</head>
<body>
<jsp:include page="fragments/user-header.jsp"></jsp:include>
<div style="text-align: center;">
    </br>
Username: ${userDetails.username}</br>
Email: ${userDetails.email}</br>
First name: ${userDetails.firstName}</br>
Last name: ${userDetails.lastName}</br>
Number of plans: ${numberOfPlans}
</div>
</body>
</html>
