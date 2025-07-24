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
    input[type="submit"] {
        background-color: #4CAF50;
        color: white;
        padding: 10px 20px;
        border: none;
        border-radius: 5px;
        cursor: pointer;
        font-size: 16px;
    }
    </style>
</head>
<body>
<h1>Введение</h1>
<p>описание</p>
<form action="game" method="get">
    <label for="playerName">Имя игрока:</label>
    <input type="text" id="playerName" name="playerName">
    <br/>
    <input type="submit" value="Начать">
</form>
</body>
</html>