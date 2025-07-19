<%--
  Created by IntelliJ IDEA.
  User: pavel
  Date: 18.07.2025
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<html>
<head>
    <title>Космический квест</title>
    <meta charset="UTF-8">
</head>

<body>
<h1>Космический квест</h1>
<p>Ты проснулся в странной каюте, напоминающей космический корабль. Повсюду какие-то медицинские приборы. Кровать
    напоминает капсулу.</p>
<p>Ничего не помнишь, словно стёрли твою память. Единственное, что вертится в голове - это то, что ты - часть чего то
    важного, часть какой-то важной миссии и от каждого твоего действия сейчас зависит её исход.</p>
<p>Голос компьютера монотонно повторяет: "Назовите своё имя".</p>
<p>Вспомнить бы хотя бы имя...</p>

<form method="post" class="player-name-form">
    <label for="playerName">Вспомни своё имя:</label>
    <input type="text" id="playerName" name="playerName" required
           placeholder="имя" class="player-name-input">

    <button type="submit" class="submit-button">Начать игру</button>
</form>
</body>
</html>
