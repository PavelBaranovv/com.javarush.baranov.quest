<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 19.07.2025
  Time: 14:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Космический квест</title>
    <meta charset="UTF-8">
</head>
<body>
<c:choose>
    <c:when test="${sessionScope.gameState.name() eq 'VICTORY'}">
        <h1>&#9989; Миссия выполнена!</h1>
        <p>${sessionScope.gameState.getMessage()}</p>
    </c:when>
    <c:when test="${sessionScope.gameState.name() eq 'LOSE'}">
        <h1>&#10060; Миссия провалена!</h1>
        <p>${sessionScope.loseMessage}</p>
    </c:when>
</c:choose>
</body>
</html>
