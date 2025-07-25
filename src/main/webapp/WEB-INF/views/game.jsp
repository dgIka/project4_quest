<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Текстовый квест - Игра</title>
    <style>
        p {
            white-space: pre-wrap;
            word-wrap: break-word;
            max-width: 600px;
        }
        .heart {
            color: red;
            font-size: 24px;
            margin-right: 5px;
        }
        .health-message {
            color: red;
            font-style: italic;
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
<h1>Игра</h1>
<p><c:out value="${sceneText}"/></p>
<c:if test="${healthDecreased}">
    <p class="health-message">Теряешь <span class="heart">♥</span></p>
</c:if>
<div>
    Здоровье:
    <c:forEach begin="1" end="${hp}">
        <span class="heart">♥</span>
    </c:forEach>
</div>
<form action="game" method="post">
    <c:forEach var="option" items="${options}">
        <input type="radio" name="choice" value="${option.result}" id="option${option.id}" required/>
        <label for="option${option.id}">${option.text}</label><br/>
    </c:forEach>
    <br/>
    <br/>
    <input type="submit" value="Подтвердить"/>
</form>
<form action="restart" method="post">
    <input type="submit" value="Начать заново" class="restart-button"/>
</form>
</body>
</html>