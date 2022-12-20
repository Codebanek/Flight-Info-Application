<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 21/11/2022
  Time: 22:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Flight-Info</title>
</head>
<body>
<jsp:include page="fragments/welcomePage-header.jsp"></jsp:include>
<div style="text-align: center;">
<form method="post">
    <table class="center">

        <tr>
            <td><input type="text" name="username" value="username"/></td>
        </tr>
        <tr>
            <td><input type="password" name="password" value="password"/></td>
        </tr>
    </table>
    <input type="submit" value="Sign in" /></br>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form></br>
    ${loginError}<br>
<a href="<%=request.getContextPath() %>/createAccount">Create an account now</a></br></br>

</div>
</body>
</html>
