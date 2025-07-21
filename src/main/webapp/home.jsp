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
    <h1>Космический квест</h1>

    <div class="message">
        <p>
            Ты проснулся в странной каюте, напоминающей космический корабль. Повсюду какие-то медицинские приборы. Кровать
            напоминает капсулу.<br>
            Ничего не помнишь, словно стёрли твою память. Единственное, что вертится в голове - это то, что ты - часть чего-то
            важного, часть какой-то важной миссии и от каждого твоего действия сейчас зависит её исход.<br>
        </p>
        <p>Голос компьютера монотонно повторяет: "Назовите своё имя".</p>
        <p>Вспомнить бы имя...</p>
        <c:if test="${sessionScope.player.name != null}">
            <p>Точно! Моё имя: ${sessionScope.player.name}</p>
        </c:if>
    </div>

    <c:if test="${sessionScope.player.name == null}">
    <form method="post" class="player-name-form">
        <label for="playerName">Вспомни своё имя:</label>
        <input type="text" id="playerName" name="playerName" required
               placeholder="имя" class="player-name-input">

        <button type="submit" class="submit-button">Начать игру</button>
    </form>
    </c:if>

    <c:if test="${sessionScope.player.name != null}">
    <form method="post" class="start-form">
        <button type="submit" class="start-button">Продолжить</button>
    </form>
    </c:if>

    <c:if test="${not empty error}">
        <div class="error-message">
            <p>${error}</p>
        </div>
    </c:if>
</div>
</body>
</html>
