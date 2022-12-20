<%--
  Created by IntelliJ IDEA.
  User: sebastian
  Date: 06/12/2022
  Time: 17:33
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Flight details</title>
</head>
<jsp:include page="fragments/user-header.jsp"></jsp:include>
<div style="text-align: center;">
Your flight details:<br>
Plane: ${flightDetails.type}<br>
Departure airport: ${flightDetails.departure_code}<br>
Destination airport: ${flightDetails.arrival_code}<br>
Distance: ${flightDetails.distance} KM (STRAIGHT LINE)<br>
Flight speed: ${flightDetails.speed} KTS<br>
Estimated flight time: ${flightDetails.flight_time} MIN<br><br>

    Departure airport:<br>
    Temperature: ${departure[0]} C<br>
    Windspeed: ${departure[1]} KM/H<br>
    Winddirection: ${departure[2]} DEG<br><br>

    Destination airport:<br>
    Temperature: ${arrival[0]} C<br>
    Windspeed: ${arrival[1]} KM/H<br>
    Winddirection: ${arrival[2]} DEG<br><br>
</div>
</body>
</html>
