<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Конец игры</title>
    <style>
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
<h1>Игра окончена</h1>
<p>Видимо последнее решение было не самым удачным. Что привело к вашей смерти. Но вы всегда можете попробовать еще раз.</p>
<form action="restart" method="post">
    <input type="submit" value="Начать заново" class="restart-button"/>
</form>
</body>
</html>