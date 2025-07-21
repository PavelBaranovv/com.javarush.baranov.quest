<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Космический квест</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/style.css">
</head>

<body>
<div class="container">
    <c:choose>
        <c:when test="${sessionScope.gameState.name() eq 'VICTORY'}">
            <div class="victory">
                <h1>&#9989; Миссия выполнена!</h1>
            </div>
        </c:when>
        <c:when test="${sessionScope.gameState.name() eq 'LOSE'}">
            <div class="lose">
            <h1>&#10060; Миссия провалена!</h1>
            </div>
        </c:when>
    </c:choose>

    <div class="message">
        <p>${sessionScope.gameState.getMessage()}</p>
    </div>

    <form method="post" class="restart-form">
        <button type="submit" name="choice" value="restart" class="restart-button">
            Играть снова
        </button>
    </form>
</div>
</body>
</html>
