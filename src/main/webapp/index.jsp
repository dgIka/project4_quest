<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Текстовый квест</title>
    <style> /* перенос текста */
    p {
        white-space: pre-wrap;
        word-wrap: break-word;
        max-width: 600px;
    }
    </style>
</head>
<body>
<h1>Пролог</h1>
<p>описание</p>
<form action="game" method="get">
    <label for="playerName">Имя игрока:</label>
    <input type="text" id="playerName" name="playerName">
    <input type="submit" value="Начать">
</form>
</body>
</html>