<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 21/11/2022
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Flight-Info</title>
</head>
<body>
<jsp:include page="fragments/welcomePage-header.jsp"></jsp:include>

<form method="post">
    <table style="width: 20%">
        <tr>
            <td>UserName</td>
            <td><input type="text" name="username" /></td>
        </tr>
        <tr>
            <td>Password</td>
            <td><input type="password" name="password" /></td>
        </tr>
    </table>
    <input type="submit" value="Sign in" /></br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form></br>

<a href="<%=request.getContextPath() %>/createAccount">Create an account now</a>

</body>
</html>
