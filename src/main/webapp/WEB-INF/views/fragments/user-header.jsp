<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Zaplanuj Jedzonko</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link href="https://fonts.googleapis.com/css?family=Charmonman:400,700|Open+Sans:400,600,700&amp;subset=latin-ext"
          rel="stylesheet">
    <link href='<c:url value="/css/style.css"/>' rel="stylesheet" type="text/css">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.5.0/css/all.css" integrity="sha384-B4dIYHKNBt8Bc12p+WXckhzcICo0wtJAoU8YZTY5qE0Id1GSseTk6S+L3BlXeVIU" crossorigin="anonymous">
</head>

<header class="page-header">
    <nav class="navbar navbar-expand-lg justify-content-around">
        <a href="<c:url value="/user/flightplan"/>" class="navbar-brand main-logo">
            Welcome to <span>Flight-Info</span>
        </a>
        <ul class="nav nounderline text-uppercase">
            <li class="nav-item ml-4">
                <a class="nav-link color-header">
                <form action="<c:url value="/logout"/>" method="post">
                    <input class="fa fa-id-badge" type="submit" value="LOGOUT">
                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                </a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link color-header" href="${pageContext.request.contextPath}/user/plans">MY PLANS</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link" href="${pageContext.request.contextPath}/user/flightplan">NEW PLAN</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="<c:url value="/user/accountdetails"/>">ACCOUNT DETAILS</a>
            </li>
            <li class="nav-item ml-4">
                <a class="nav-link disabled" href="<c:url value="/user/author"/>">AUTHOR</a>
            </li>
        </ul>
    </nav>
</header>
