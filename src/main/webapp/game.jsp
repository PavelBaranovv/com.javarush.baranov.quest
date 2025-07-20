<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ page import="com.javarush.baranov.quest.gameLogic.GameState" %>
<html>
<head>
    <title>Космический квест</title>
    <meta charset="UTF-8">
</head>

<body>
<h1>Космический квест</h1>

<p>${sessionScope.gameState.getMessage().replace("[name]", sessionScope.player.getName())}</p>

<c:if test="${sessionScope.gameState.isInGame()}">
    <form method="post" class="choice-form">
        <c:choose>
            <c:when test="${sessionScope.gameState == GameState.QUESTION_1}">
                <button type="submit" name="choice" value="1" class="choice-button">
                    1
                </button>
                <button type="submit" name="choice" value="2" class="choice-button">
                    2
                </button>
                <button type="submit" name="choice" value="3" class="choice-button">
                    3
                </button>
                <button type="submit" name="choice" value="4" class="choice-button">
                    4
                </button>
            </c:when>
            <c:when test="${sessionScope.gameState == GameState.QUESTION_2}">
                <button type="submit" name="choice" value="Токио" class="choice-button">
                    Токио
                </button>
                <button type="submit" name="choice" value="Лондон" class="choice-button">
                    Лондон
                </button>
                <button type="submit" name="choice" value="Вашингтон" class="choice-button">
                    Вашингтон
                </button>
            </c:when>
            <c:when test="${sessionScope.gameState == GameState.BRIDGE}">
                <button type="submit" name="choice" value="Подняться на мостик" class="choice-button">
                    Подняться на мостик
                </button>
                <button type="submit" name="choice" value="Остаться в каюте" class="choice-button">
                    Остаться в каюте
                </button>
            </c:when>
            <c:when test="${sessionScope.gameState == GameState.COME_ON_BRIDGE ||
                                sessionScope.gameState == GameState.STAY_IN_ROOM}">
                <button type="submit" name="choice" value="Кто ты?" class="choice-button">
                    Кто ты?
                </button>
            </c:when>
            <c:when test="${sessionScope.gameState == GameState.CREWMATE_ASKING}">
                <button type="submit" name="choice" value="Проснешься?" class="choice-button">
                    Проснешься?
                </button>
                <button type="submit" name="choice" value="Миссия?" class="choice-button">
                    Миссия?
                </button>
            </c:when>
            <c:when test="${sessionScope.gameState == GameState.MISSION ||
                                sessionScope.gameState == GameState.SLEEPING}">
                <button type="submit" name="choice" value="Ничего не делать" class="choice-button">
                    Ничего не делать
                </button>
                <button type="submit" name="choice" value="Проверить шлюз" class="choice-button">
                    Проверить шлюз
                </button>
            </c:when>
            <c:when test="${sessionScope.gameState == GameState.ALIENS_MEETING}">
                <button type="submit" name="choice" value="Привет?" class="choice-button">
                    Привет?
                </button>
                <button type="submit" name="choice" value="Закрыть люк и улететь" class="choice-button">
                    Закрыть люк и улететь
                </button>
            </c:when>
            <c:when test="${sessionScope.gameState == GameState.ALIENS_PARTY}">
                <button type="submit" name="choice" value="Остаться с инопланетянами" class="choice-button">
                    Остаться с инопланетянами
                </button>
                <button type="submit" name="choice" value="Вернуться домой" class="choice-button">
                    Вернуться домой
                </button>
            </c:when>
        </c:choose>
    </form>
</c:if>

<hr>

<p><small><ul>
    <li>Игрок: <span class="highlight">${sessionScope.player.name}</span><br></li>
    <li>Игр сыграно: <span class="highlight">${sessionScope.player.getGamesCount()}</span></li>
</ul></small></p>
</body>
</html>
