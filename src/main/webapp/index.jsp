<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Текстовый квест</title>
</head>
<body>
<h1>заголовок</h1>
<p>описание</p>
<form action="game.jsp" method="post">
    <label for="playerName">Имя игрока:</label>
    <input type="text" id="playerName" name="playerName">
    <input type="submit" value="Начать">
</form>
</body>
</html>