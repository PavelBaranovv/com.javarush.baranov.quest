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
    </c:when>
    <c:when test="${sessionScope.gameState.name() eq 'LOSE'}">
        <h1>&#10060; Миссия провалена!</h1>
    </c:when>
</c:choose>

<p>${sessionScope.gameState.getMessage()}</p>

<form method="post" class="restart-form">
    <button type="submit" name="choice" value="restart" class="restart-button">
        Играть снова
    </button>
</form>
</body>
</html>
